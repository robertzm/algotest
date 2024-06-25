## Concepts
1. DAU: Daily Active User
2. ACID: Atomic, Consistency, Isolation, Durability

## Tech Comparison
1. **Compression Tools, ZSTD vs. GZIP ?**
> https://thedatafreak.medium.com/parquet-zstd-vs-gzip-740a83571ecd
Both are ~3x compression rate.
Both are lossless compression.

ZSTD:
* splittable
* faster compression and decompression rate
* real time
* slightly better of compression rate (< 10%)

GZIP:
* not splittable
* slower compression and decompression rate

2. **BLOB vs. CLOB ?**
> https://stackoverflow.com/questions/21570751/difference-between-clob-and-blob-from-db2-and-oracle-perspective
> https://www.cloudflare.com/learning/cloud/what-is-blob-storage/

BLOB: Binary Large Object (videos, images, documents, other)

CLOB: Character Large Object (text)

3. **Horizontal vs. Vertical Scaling ?**
While horizontal scaling refers to adding additional nodes, vertical scaling describes adding more power to your current machines. For instance, if your server requires more processing power, vertical scaling would mean upgrading the CPUs. You can also vertically scale the memory, storage, or network speed.

4. **Pub/Sub service vs. Aws SQS ?**
> https://cloud.google.com/pubsub/docs/overview

Both Fan-in mode.
Both standard queue, not guarantee duplicate, not guarantee order

Fan-out: native support on Pub/Sub; need integrate with SNS
FIFO: only for AWS SQS
Delay Queue: only on SQS

5. **CDN: Aws CloudFront vs. Google Cloud CDN**:
CDN: Content Delivery Network is a group of geographically distributed servers that speed up the delivery of web content by bring it closer to where users are.

Distributed Cache with SSL/TLS authentication, and DDoS protection, etc.

6. **Distributed Cache**:
Distributed cache is a cache shared by multiple app servers, typically maintained as an external service to the app servers that access it.

* AWS ElasticCache : Redis OSS vs. Memcached
* Google Cloud Redis Cache

| -  | Memcached | Redis OSS |
|----|-----------|-----------|
|Sub-millisecond latency | Yes | Yes |
|Developer ease of use | Yes | Yes |
|Data partitioning | Yes | Yes |
|Support for a broad set of programming languages |	Yes | Yes |
|Advanced data structures | - | Yes |
|Multithreaded architecture | Yes | - |
|Snapshots | - | Yes |
|Replication | - | Yes |
|Transactions | - | Yes |
|Pub/Sub | - | Yes |
|Lua scripting | - | Yes |
|Geospatial support | - | Yes |

7. **HTTP / HTTPS vs. WebSocket?**
> https://www.geeksforgeeks.org/what-is-web-socket-and-how-it-is-different-from-the-http/

HTTP/HTTPS and WebSocket both are communication protocols used in client-server communication.

**HTTP/HTTPS**:
* The HTTP protocol is a unidirectional protocol that works on top of TCP protocol which is a connection-oriented transport layer protocol, we can create the connection by using HTTP request methods after getting the response HTTP connection get closed.
* Simple RESTful application uses HTTP protocol which is stateless.
* When we do not want to retain a connection for a particular amount of time or reuse the connection for transmitting data; An HTTP connection is slower than WebSockets.

**WebSocket**:
* WebSocket is a bidirectional communication protocol that can send the data from the client to the server or from the server to the client by reusing the established connection channel. The connection is kept alive until terminated by either the client or the server.
* It is a stateful protocol, which means the connection between client and server will keep alive until it is terminated by either party (client or server).
* Almost all the real-time applications like (trading, monitoring, notification) services use WebSocket to receive the data on a single communication channel.
* All the frequently updated applications used WebSocket because it is faster than HTTP Connection.
* Real-time web application / Gaming application / Chat application

8. **Load Balancing: Round Robin vs. Weighted RR vs. Least Connection**
> https://www.geeksforgeeks.org/load-balancing-algorithms/

9. **Database Sharding vs. Partitioning?**
> https://www.baeldung.com/cs/database-sharding-vs-partitioning

Database sharding:
* sharding is a technique for horizontally partitioning a large database into smaller and more manageable subsets.
* By distributing the data across multiple servers, sharding can improve the performance, scalability, and availability of the database.
* Some popular strategies utilized in sharding are range-based sharding, hash-based sharding, and composite sharding.
* E-commerce app, social media, gaming, etc.


Database Partitioning:
* partitioning is a method for breaking down a massive database into small subsets.
* Partitioning can improve the performance, scalability, and availability of the database.
* There’re several different techniques for partitioning a database, including range partitioning, list partitioning, and composite partitioning.
* financial services, IoT apps, healthcare app

Diffs:
| Database Sharding | Database Partitioning |
|---|---|
|distribute data across multiple servers or clusters | divide data within a single database instance|
|each shard may contain duplicate copy to ensure high availability | No data redundancy within a partition |
| more administrative overhead | less administrative overhead |
| less flexibility | greater flexibility |

10. **Relational DB vs. NoSQL DB**?
> RDBMS stands for Relational Database Management Systems. It is most popular database. In it, data is store in the form of row that is in the form of tuple. It contain numbers of table and data can be easily accessed because data is store in the table. This Model was proposed by E.F. Codd.

> NoSQL Database stands for a non-SQL database. NoSQL database doesn’t use table to store the data like relational database. It is used for storing and fetching the data in database and generally used to store the large amount of data. It supports query language and provides better performance.

| Relational Database | NoSQL |
| ---- | ---- |
| It is used to handle data coming in low velocity. | It is used to handle data coming in high velocity. |
| It gives only read scalability. | It gives both read and write scalability. |
| It manages structured data. | It manages all type of data. |
| Data arrives from one or few locations. | Data arrives from many locations. |
| It supports complex transactions. | It supports simple transactions. |
| It has single point of failure. | No single point of failure. |
| It handles data in less volume. | It handles data in high volume. |
| Transactions written in one location. | Transactions written in many locations. |
| support ACID properties compliance | doesn’t support ACID properties |
| Its difficult to make changes in database once it is defined | Enables easy and frequent changes to database |
schema  is mandatory to store the data | schema design is not required |
| Deployed in vertical fashion. | Deployed in Horizontal fashion. |

11. **Cassandra vs. DynamoDB**?
> https://www.geeksforgeeks.org/cassandra-vs-dynamodb/

 Cassandra and DynamoDB are both NoSQL database, which is scalable and fault-tolerant with high availability.

| **Feature** | **cassandra** | **DynamoDB** |
| ---- | ---- | ---- |
| Type | Open-source, distributed NoSQL database designed for scalability and fault tolerance accross geographically distributed clusters. | Fully managed NoSQL database by AWS, offering scalability, fault tolerance, high availability, and predictable performance |
| Data Model | Wide-column store architecture, allowing for flexible storage of various types of data with dynamic schemas. | Key-value store model storing data in the form of key-value pairs. |
| Consistency | Offers tunable consistency levels, allowing for a balance between consistency and performance. | Provides strong consistency by default, ensuring that all copies of data are updated simultaneously. (Allow eventual consistency as well. ) |
| Partitioning | Requires **manual partitioning**, giving users control over how data is distributed across nodes in the cluster. | Utilize **automatic partitioning** managed by AWS, simplifying the scaling process for users. |
| Scalability | Supports horizontal scaling, enabling users to add more nodes to the clusters. | Offers horizontal scaling managed by AWS, automatically adjusting capacity to handle varying demand. |
| Secondary Index | Supports secondary indexes, allowing for faster data retrieval based on frequently queried columns. | Supports both Global and Local Secondary Indexes, enhancing query flexibility and performance. |
| ACID Compliance | Provides limited ACID compliance, offering atomicity, consistency, isolation, and durability to a certain extent. | Ensures ACID properties, providing strong data integrity and reliability. |
| Query Language | Utilize CQL (Cassandra QL) for interacting with database, offering a familiar SQL-like syntax. | Accessed through AWS SDK and APIs, providing developers with programmatic access to database operations. |
| Performance | Known for high write and read throughput, making it suitable for rea-time data-intensive applications. | Offers high write and read throughput, ensuring efficient data access and processing for various use cases. |

* **DAX** is available and helpful for high volume read on DynamoDB with distributed Cache features.

12. **Long Polling vs. WebSocket**?
> https://www.geeksforgeeks.org/difference-between-long-polling-and-websocket/

| | **Long Polling** | **WebSocket** | 
| ---- | ---- | ---- |
| 1. | It offers a unidirectional communication channel. | It offers a bidirectional communication channel. |
| 2. | There is an issue of resource wastage. | There is no such issue of resource wastage. |
| 3. | It has a short waiting period. | It has a long waiting period. |
| 4. | It does not offer resource utilization. | It offers resource utilization. |
| 5. | There are not many complications wile enabling a connection process. | There are different complications while enabling a connection process. |
| 6. | In this, there are several kinds of delays during the process. | In this, there are no delays during the process. | 
| 7. | It uses AJAX to communicate properly. | It does not use AJAX to communicate over the network. |
| 8. | It uses HTTP protocal for connection. | It uses TCP/IP protocol for connection. | 
| 9. | It is easy to implement. | It is difficult to implement when compared with Long Polling. |
| 10. | Latency problems are there. | There are no latency problems. |
| 11. | Delay can occur since client always have to make new request after receiving data. | Provides real time updates. | 
| 12. | Poor scalability since new request has been sent each time. | Highly Scalable due to persistence connection. | 

10. **Hot Entity Issue vs. Fat Entity Issue**?



## Terms
* Scalable
* Cloud-native
* Programming language agnostic
* Cost-effective
