package org.zahangirbd.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyProducer {
	
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Enter topic name");
	        return;
	    }
		 
		//Assign topicName to string variable
	    String topicName = args[0].toString();
  
		// create instance for properties to access producer configs   
		Properties props = new Properties();
  
		//Assign localhost id, 
		props.put("bootstrap.servers", "127.0.0.1:9092");
		//config.put("bootstrap.servers", "host1:9092,host2:9092");
  
		//Set acknowledgements for producer requests.      
		props.put("acks", "all");
  
		//If the request fails, the producer can automatically retry,
		props.put("retries", 0);
  
		//Specify buffer size in config
		props.put("batch.size", 16384);
  
		//Reduce the no of requests less than 0   
		props.put("linger.ms", 1);
  
		//The buffer.memory controls the total amount of memory available to the producer for buffering.   
		props.put("buffer.memory", 33554432);
  
		props.put("key.serializer", 
		  "org.apache.kafka.common.serialization.StringSerializer");
     
		props.put("value.serializer", 
		  "org.apache.kafka.common.serialization.StringSerializer");
  
		Producer<String, String> producer = new KafkaProducer
				<String, String>(props);
        
		for(int i = 0; i < 10; i++)
			producer.send(new ProducerRecord<String, String>(topicName, 
					Integer.toString(i), Integer.toString(i)));
  
		System.out.println("Message sent successfully");
		producer.close();
	}
}
