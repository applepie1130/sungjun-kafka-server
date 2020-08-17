package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.model.type.TopicType;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TestProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
    public TestProducer(final KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	/**
	 * 메시지 발송
	 * @param message
	 */
	public void sendMessage(TopicType topicType, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicType.getName(), message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
            	log.info("send message : {}, offset : {}", result.getProducerRecord().value(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
            	log.info("Failed send message : {}, offset : {}", message, ex.getMessage());
            }
        });
    }
}
