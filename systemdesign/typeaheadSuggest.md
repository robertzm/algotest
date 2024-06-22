# Typeahead Suggestion

## System Requirements
### Functional:

* I will focus on a browser as a client. We can extent it to a mobile device later;
* As user types a letter, the Typeahead Service finds relevant words;
* The top priority word would be used as a candidate to auto complete. If the user hits a tab key at this point, this word would be used;
* Some (default 10, but configurable) high priority words would be listed right under the form the user is typing in, so that the user can pick a word from them;
* I assume the search engine, which is part of the backend for this service, has a way to sort words with priority, based on how often the words are searched. Personalization should be used as part of this sorting.

### Non-Functional:
* Response time is very important. After a user types a letter, typeahead suggestion should show up within 100ms. 
* Scalability. We can expect 100M DAU.
* Availability - It is probably acceptable to not over-focus on availability. If typeahead is unavailable for a short period of time, users probably would not suffer critical consequences.

I assume that there is a web service which can return a personalized (via email address) list of 1,000 most likely search words. Because this is an external web service, we will consider an error scenario where this service is down.

Other error scenario is the Typeahead service being unavailable. We will ensure the client will be able to operate gracefully even if the server is unreachable. 

## Capacity Estimation
* I assume 100M DAU and 300M MAU;
* At peak, let's consider 25M requests per second;
* Let's assume we would store 100 most likely search words for each user, and 1,000 for general most likely search words;

* 300M users * 100 = 30GB of data. With user increase, it might become like 60GB in 2 years.

* For scalability and performance, I think a NoSQL, such as MongoDB, would be a good choice for data storage.
* We would not need complex join operations for this data set, so we would not have to rely on relational DB's rich query functionality.

## API Design
The key to high performance is that the client (browser) has enough information to make typeahead recommendation, without asking server each time the user types.

Client would call:

* **get_words(priority_from, priority_to)**
* **get_personalized_words(priority_from, priority_to, user_ID)**

Let's say the popular words are stored by priority, 0 to 1,0000. 

Upon page load, the client would ask for themost popular words, e.g. first 1,000. It will be personalized for the user.

If the client has bandwidth or resource concern, it may choose to ask for fewer number of words at a time (let's say first 100 first), and ask for more later. This would be similar to paging. 

But I expect most client to ask for all the words (e.g. 1,000). If each word is 10 letters on average, it'd amount to 10KB. Most modern browsers and networks are capable of sending and receiving this much data. 

The return data (words) can be transmitted in a simple array in JSON format.

## Database Design
*Defining the system data model early on will clarify how data will flow among different components of the system. Also you could draw an ER diagram using the diagramming tool to enhance your design...*

## High-Level Design

On page load, the client uses get_words() API.

CDN would be important. It caches the most common search words (un-personalized). it will be able to return the common words very quickly (e.g. in the order of 10 ms).

The client would store the candidate words in a Trie data structure. This tree structure would let the client to quickly narrow down the number of candidate words, as the user types.

In the background, the client would also make a call to get_personalized_words(). This would hit the Load Balancer directly. This would take more time (e.g. in the order of 100 ms or even s). 

Words Server would have to request personalized list of words to External Search Service for the first time it sees the user. Once the words are received, they would be store in Database (for performance storage) and in Redis (for fast access).

Once the personalized words arrive, the client would add these words to the Trie data structure.

This Trie data structure can be locally stored in the client as client side cache. 

```mermaid
flowchart TD
    CL[Client] --"get_words()'--> CDN[CDN]
    CDN --> LB[Load Balancer]
    CL--get_personalized_words()-->LB
    LB --> WS[Words Server]
    WS --> DB[Database]
    WS --> CC[Redis Cache]
    WS --> EX[External Search Service]
```

## Request Flows

## Detailed Component Design

Once Trie is built, it enables fast look up of potential words. For example: 

```
a-p-p-l-e
       -i-c-a-t-i-o-n
```

This Trie gives tree choices: app, apple, application, when a user types the first letter 'a'. It quickly cuts off possibilities of any words starting from other letters.

As long as the client has this Trie structure in memory, it can quickly traverse it and show word completion candidates.

As such, the client's job is to maintain this Trie (built it and store it in the client side storage). The server's job is to give this information to the client in an efficient way, from CDN and from Words Server.

## Trade-offs / Tech Choices

An interesting choice is who synthesizes the personalized word list with the general word list to create one word list.

The approach I took is for the client to receive two separate lists and synthesizes them.

Another approach is for the Words Server to create and combined list and return it to the client.

I took the first approach primarily for the response time. 

The general list can be given to the client very quickly. It is the same list for all users, so we can simply store the list in CDN. The CDN, which would be close to the client, can return it quickly. 

The personalized list, on the other hand, would take some time to generate, especially if Words Server has to reach out to External Search Service to obtain it.

As such, it would be better give the general list to the client first. The personalized list can reach the later at a later time. At that point, the client can add the personalized words to the Trie data structure, without the user noticing any change. 

## Failure Scenarios / Bottlenecks

One common failure scenario would be the loss of network. The client would not be able to reach the Words Server. 

The design handles this error case gracefully. Because the client stores the necessary information for the functionality (the popular words stores in Trie data structure), the client can function correctly.

A Service Worker in a browser can periodically download new candidate words and keep the Trie up to date, so that it would be ready when the network goes offline.

## Future Improvements
*What are some future improvements you would make? How would you mitigate the failure scenario(s) you described above?*
