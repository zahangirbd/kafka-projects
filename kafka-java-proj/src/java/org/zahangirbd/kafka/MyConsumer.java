package org.zahangirbd.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class MyConsumer {

	public static void main(String[] args) {
		 //Kafka consumer configuration settings
		 if(args.length == 0){
	         System.out.println("Enter topic name");
	         return;
	      }
		 
	      //Kafka consumer configuration settings
	      String topicName = args[0].toString();
	      Properties props = new Properties();
	      
	      props.put("bootstrap.servers", "127.0.0.1:9092");
	      //config.put("bootstrap.servers", "host1:9092,host2:9092");
	      props.put("group.id", "test");
	      props.put("enable.auto.commit", "true");
	      props.put("auto.commit.interval.ms", "1000");
	      props.put("session.timeout.ms", "30000");
	      props.put("key.deserializer", 
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      props.put("value.deserializer", 
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      KafkaConsumer<String, String> consumer = new KafkaConsumer
	         <String, String>(props);
	      
	      //Kafka Consumer subscribes list of topics here.
	      consumer.subscribe(Arrays.asList(topicName));
	      
	      //print the topic name
	      System.out.println("Subscribed to topic " + topicName);
	      
	      while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records) {
	        	 // print the offset,key and value for the consumer records.
	        	 System.out.printf("offset = %d, key = %s, value = %s\n", 
	        			 record.offset(), record.key(), record.value());	        	 
	         }
	      }
	}
}
