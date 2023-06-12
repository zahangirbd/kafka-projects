# kafka projects
Here are kafka related testing projects

## Get started
To test the kafka projects, we need to run kafka docker first. 
Then we can use **producer** to publish the data and **consumer** to consume the published data.  

Here are steps to test the kafka projects
1. Go to `kafka-docker` folder and run docker image first

	```
	cd kafka-docker
	docker-compose up
	```

It will run at http://localhost:9092

2. Open the `kafka-java-proj` project into eclipse any IDE and follow the instructions mentioned in `kafka-java-proj/ReadMe.txt`
3. To run **producer**, please pass a **topicName** as program argument, e.g., `My-Kafka-Test-Topic-1`. 
In command line, you need to have all dependent libraris in `/lib` folder. Then from project build folder, you can run like following.

	```
	cd bin/default
	java -cp .;../../lib/* org.zahangirbd.kafka.MyProducer My-Kafka-Test-Topic-1
	```
	
Please note that using the dot `.` as the first entry in the `CLASSPATH` assumes that the `MyProducer.class` file exists in the directory (e.g. `/bin/default/org/zahangirbd/kafka/MyProducer.class`) from which we're running java.
Here `/lib` is two level up from that directory.

4. To run **consumer**, please pass the **topicName** as program argument, e.g., `My-Kafka-Test-Topic-1`
In command line, you need to have all dependent libraris in `/lib` folder. Then from project build folder, you can run like following.

	```
	cd bin/default
	java -cp .;../../lib/* org.zahangirbd.kafka.MyConsumer My-Kafka-Test-Topic-1
	```
	
Please note that using the dot `.` as the first entry in the `CLASSPATH` assumes that the `MyConsumer.class` file exists in the directory (e.g. `/bin/default/org/zahangirbd/kafka/MyProducer.class`) from which we're running java.
Here `/lib` is two level up from that directory.

 