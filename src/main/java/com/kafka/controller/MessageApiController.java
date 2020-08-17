package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.entity.MessageResponseEntity;
import com.kafka.model.type.TopicType;
import com.kafka.producer.TestProducer;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(path = "/v1/message/", produces = "application/json")
public class MessageApiController {
	
	private final TestProducer testProducer;
	
	@Autowired
	public MessageApiController(final TestProducer testProducer) {
		this.testProducer = testProducer;
	}
	
	@GetMapping(path="send")
	public ResponseEntity<MessageResponseEntity> send(@RequestParam("msg") String message) {
		
		// send message
		testProducer.sendMessage(TopicType.TEST_TOPIC, message);
		
		return new ResponseEntity<>(MessageResponseEntity.builder()
									.result(null)
									.status(HttpStatus.OK)
									.message("처리되었습니다.")
									.build()
									, HttpStatus.OK);
	}
}