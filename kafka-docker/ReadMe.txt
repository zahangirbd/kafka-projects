Ref: https://hub.docker.com/r/bitnami/kafka

1) To run kafka docker, we need to run the following command

	>docker-compose up

2)  For testing whether producer and consumer is working or not, 
  a) Producer: open cli window and run the following command
	>kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic test
	
	Then type any message here in the sdt-input console 

  b) Consumer: open another cli window and run the following command
	> kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic test --from-beginning

	The producer published messages will be shown here in the consumer console
