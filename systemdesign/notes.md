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

8. **Load Balancing: Round Robin vs. Weighted RR vs. Least Connection
> https://www.geeksforgeeks.org/load-balancing-algorithms/



## Terms
* Scalable
* Cloud-native
* Programming language agnostic
* Cost-effective
