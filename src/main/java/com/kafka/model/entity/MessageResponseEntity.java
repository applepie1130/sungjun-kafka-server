package com.kafka.model.entity;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseEntity implements Serializable {
	
	private static final long serialVersionUID = 4313595806701558765L;
	
	private HttpStatus status;
	
	private String message;
	
	private Object result;

}
