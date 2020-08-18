package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.model.entity.TempEntity;
import com.kafka.model.type.TopicType;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TestProducer {

	private final KafkaTemplate<String, String> kafkaStringTemplate;
	private final KafkaTemplate<String, TempEntity> kafkaTempEntityTemplate;

	@Autowired
    public TestProducer(final KafkaTemplate<String, String> kafkaStringTemplate,
    					final KafkaTemplate<String, TempEntity> kafkaTempEntityTemplate) {
		this.kafkaStringTemplate = kafkaStringTemplate;
		this.kafkaTempEntityTemplate = kafkaTempEntityTemplate;
	}

	/**
	 * 메시지 발송
	 * @param message
	 */
	public void sendString(TopicType topicType, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaStringTemplate.send(topicType.getName(), message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
            	log.info("send message : {}, offset : {}", result.getProducerRecord().value(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
            	log.info("Failed send message : {}, exception : {}", message, ex.getMessage());
            }
        });
    }
	
	/**
	 * 메시지 발송
	 * @param message
	 */
	public void sendData(TopicType topicType, TempEntity tempEntity) {
        ListenableFuture<SendResult<String, TempEntity>> future = kafkaTempEntityTemplate.send(topicType.getName(), tempEntity);

        future.addCallback(new ListenableFutureCallback<SendResult<String, TempEntity>>() {
            @Override
            public void onSuccess(SendResult<String, TempEntity> result) {
            	log.info("send message : {}, offset : {}", result.getProducerRecord().value(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
            	log.info("Failed send message : {}, exception : {}", tempEntity, ex.getMessage());
            }
        });
    }
}
