package com.kafka.consumer;

import java.util.stream.IntStream;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TestConsumer {
	
	@KafkaListener(topics = "#{T(com.kafka.model.type.TopicType).TEST_TOPIC.getName()}", 
					groupId = "#{T(com.kafka.model.type.ConsumerGroupType).TEST_CONSUMER_GROUP.getName()}")
    public void listen(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		IntStream.range(0, 10000000).forEach(t->{});
    	log.info("received message : {}, partition-id: {}", message, partition);
    }
	
}