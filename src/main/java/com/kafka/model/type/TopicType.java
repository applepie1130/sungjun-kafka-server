package com.kafka.model.type;

import java.util.Optional;


/**
 * TopicType
 *  
 * @author sungjunkim
 *
 */
public enum TopicType {
	
	TEST_TOPIC("test-topic", Optional.of(2), Optional.of((short)1), "테스트용 topic")
	;

	private String name;
	
	// Topic의 파티션 수
	private Optional<Integer> numberOfPartition;
	
	// Repication 수 
	private Optional<Short> replicationFactor;
	
	private String description;
	
	private TopicType(String name, Optional<Integer> numberOfPartition, Optional<Short> replicationFactor, String description) {
		this.name = name;
		this.numberOfPartition = numberOfPartition;
		this.replicationFactor = replicationFactor;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public Optional<Integer> getNumberOfPartition() {
		return numberOfPartition;
	}

	public Optional<Short> getReplicationFactor() {
		return replicationFactor;
	}

	public String getDescription() {
		return description;
	}
	
}
