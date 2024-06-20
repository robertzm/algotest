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


## Terms
* Scalable
* Cloud-native
* Programming language agnostic
* Cost-effective
