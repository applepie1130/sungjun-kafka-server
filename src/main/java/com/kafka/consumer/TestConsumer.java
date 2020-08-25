package com.kafka.consumer;

import com.kafka.model.entity.TempEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class TestConsumer {
	
	@KafkaListener(topics = "#{T(com.kafka.model.type.TopicType).TEST_TOPIC.getName()}", 
					groupId = "#{T(com.kafka.model.type.ConsumerGroupType).TEST_CONSUMER_GROUP.getName()}")
    public void listen(@Payload String message, 
    					@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
    					@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
    					@Header(KafkaHeaders.OFFSET) String offset,
					   Acknowledgment acknowledgment

    		) {
		log.info("received message : {}, topic : {}, partition-id: {}, offset : {}", message, topic, partitionId, offset);

		// 수동 커밋
		acknowledgment.acknowledge();
    }
	
	@KafkaListener(topics = "#{T(com.kafka.model.type.TopicType).TEMP_TABLE_TOPIC.getName()}", 
					groupId = "#{T(com.kafka.model.type.ConsumerGroupType).TEST_CONSUMER_GROUP.getName()}",
					containerFactory = "tempEntityKafkaListenerContainerFactory")
	public void listenTempEntity(@Payload TempEntity tempEntity, 
					@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
					@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
					@Header(KafkaHeaders.OFFSET) String offset,
					Acknowledgment acknowledgment
		) {
		
		log.info("tempEntity : {}", tempEntity);
		log.info("received message : {}, topic : {}, partition-id: {}, offset : {}", tempEntity, topic, partitionId, offset);

		// 수동 커밋
		acknowledgment.acknowledge();
	}
}
