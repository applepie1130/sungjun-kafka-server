package com.kafka.controller;

import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.entity.MessageResponseEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(path = "/v1/general/", produces = "application/json")
public class GeneralApiController {
	
	@GetMapping(path="send")
	public ResponseEntity<MessageResponseEntity> send() {
		
		IntStream.range(0, 10000000).forEach(t->{});
		
		return new ResponseEntity<>(MessageResponseEntity.builder()
									.result(null)
									.status(HttpStatus.OK)
									.message("처리되었습니다.")
									.build()
									, HttpStatus.OK);
	}
}