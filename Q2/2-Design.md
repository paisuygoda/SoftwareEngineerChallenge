Here is the flow of the proposed system.

![Design Overview](./Q2/Design.png "Design Overview")

# 1. Register user purchases to database

Each PayPay App sends realtime purchase log to message queue.   
Here I chose Apache Kafka since we need high scalability, durability, and least downtime and data loss.  
Kafka meets those requirements and is proven in many major services.

Gathered log is then pre-processed to store in DB.  
Here I chose Apache Spark.  
Spark is a processing engine for large data so it fits to our needs.  
Hadoop can replace spark here. These two have similar functions,  
but Spark is faster in case like doing same operation to massive-scale data.  
Here we do that so I chose Spark, but Hadoop can be an option.

For database, I chose Apache Cassandra.  
Again, it has high scalability, durability, least downtime, data loss and proven.  
Also, it is a NoSQL database so it can handle schema change with least extra-work.

These tools all have high scalability which can handle our requirements: 1mil access per sec, 1GB write per sec.  
Another requirement was "<1h delay". It's not a severe real-time restriction and I think this design will handle it without any extra tools.

# 2. Give access to metrics to merchants

Google Analytics-like system needs to do quite simple operations,   
and for basic metrics, the system's API may actually access to DB directly.    
However Cassandra's native queries are relatively poor and lacks extensibility.  
Therefore I let Spark to access DB and do querying jobs.    
Spark and Cassandra can handle <1k per sec access so this will meet our requirements.
