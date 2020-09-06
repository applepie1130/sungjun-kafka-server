package com.kafka.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.entity.MessageResponseEntity;
import com.kafka.model.entity.TempEntity;
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
	
	@GetMapping(path="string-send")
	public ResponseEntity<MessageResponseEntity> send(@RequestParam("msg") String message) {
		
		// send message
		testProducer.sendString(TopicType.TEST_TOPIC_01, message);
		testProducer.sendString(TopicType.TEST_TOPIC_02, message);
		testProducer.sendString(TopicType.TEST_TOPIC_03, message);
		
		return new ResponseEntity<>(MessageResponseEntity.builder()
									.result(null)
									.status(HttpStatus.OK)
									.message("처리되었습니다.")
									.build()
									, HttpStatus.OK);
	}
	
	@PostMapping(path="data-send")
	public ResponseEntity<MessageResponseEntity> send() {
		
		// send data
		testProducer.sendData(TopicType.TEMP_TABLE_TOPIC, TempEntity.builder()
																.regDate(LocalDateTime.now())
																.build());
		
		return new ResponseEntity<>(MessageResponseEntity.builder()
									.result(null)
									.status(HttpStatus.OK)
									.message("처리되었습니다.")
									.build()
									, HttpStatus.OK);
	}
}