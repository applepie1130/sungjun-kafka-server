package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.kafka.model.entity.TempEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TestConsumer {
	
	@KafkaListener(topics = "#{T(com.kafka.model.type.TopicType).TEST_TOPIC_01.getName()}", 
					groupId = "#{T(com.kafka.model.type.ConsumerGroupType).TEST_CONSUMER_GROUP_01.getName()}",
					containerFactory = "kafkaListenerContainerGroup01Factory")
    public void listen_test_topic_01(@Payload String message, 
    					@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
    					@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
    					@Header(KafkaHeaders.OFFSET) String offset,
    					@Header(KafkaHeaders.GROUP_ID) String groupId,
    					Acknowledgment acknowledgment) {
		log.info("received message : {}, group-id {}, topic : {}, partition-id: {}, offset : {}", message, groupId, topic, partitionId, offset);

		// 수동 커밋
		acknowledgment.acknowledge();
    }
	
	@KafkaListener(topics = "#{T(com.kafka.model.type.TopicType).TEST_TOPIC_02.getName()}", 
					groupId = "#{T(com.kafka.model.type.ConsumerGroupType).TEST_CONSUMER_GROUP_02.getName()}",
					containerFactory = "kafkaListenerContainerGroup02Factory")
	public void listen_test_topic_02(@Payload String message, 
						@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
						@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
						@Header(KafkaHeaders.OFFSET) String offset,
						@Header(KafkaHeaders.GROUP_ID) String groupId,
						Acknowledgment acknowledgment) {
		log.info("received message : {}, group-id {}, topic : {}, partition-id: {}, offset : {}", message, groupId, topic, partitionId, offset);
		
		// 수동 커밋
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = "#{T(com.kafka.model.type.TopicType).TEST_TOPIC_03.getName()}", 
					groupId = "#{T(com.kafka.model.type.ConsumerGroupType).TEST_CONSUMER_GROUP_03.getName()}",
					containerFactory = "kafkaListenerContainerGroup03Factory")
	public void listen_test_topic_03(@Payload String message, 
						@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
						@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
						@Header(KafkaHeaders.OFFSET) String offset,
						@Header(KafkaHeaders.GROUP_ID) String groupId,
						Acknowledgment acknowledgment) {
		log.info("received message : {}, group-id {}, topic : {}, partition-id: {}, offset : {}", message, groupId, topic, partitionId, offset);
		
		// 수동 커밋
		acknowledgment.acknowledge();
	}
	
	@KafkaListener(topics = "#{T(com.kafka.model.type.TopicType).TEMP_TABLE_TOPIC.getName()}", 
					groupId = "#{T(com.kafka.model.type.ConsumerGroupType).TEST_CONSUMER_GROUP_01.getName()}",
					containerFactory = "tempEntityKafkaListenerContainerFactory")
	public void listenTempEntity(@Payload TempEntity tempEntity, 
					@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
					@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
					@Header(KafkaHeaders.OFFSET) String offset,
					@Header(KafkaHeaders.GROUP_ID) String groupId,
					Acknowledgment acknowledgment) {
		log.info("received message : {}, group-id {}, topic : {}, partition-id: {}, offset : {}", tempEntity, groupId, topic, partitionId, offset);

		// 수동 커밋
		acknowledgment.acknowledge();
	}
}
