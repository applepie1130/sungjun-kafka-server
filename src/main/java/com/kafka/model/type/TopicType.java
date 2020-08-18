package com.kafka.model.type;

/**
 * TopicType
 *  
 * @author sungjunkim
 *
 */
public enum TopicType {
	
	TEST_TOPIC("test-topic", 2, 1, "테스트용 topic"),
	TEMP_TABLE_TOPIC("temp-table-topic", 2, 1, "mysql temp table topic")
	;

	private String name;
	
	// Topic의 파티션 수
	private Integer numberOfPartition;
	
	// Repication 수 
	private Integer replicationFactor;
	
	private String description;
	
	private TopicType(String name, Integer numberOfPartition, Integer replicationFactor, String description) {
		this.name = name;
		this.numberOfPartition = numberOfPartition;
		this.replicationFactor = replicationFactor;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public Integer getNumberOfPartition() {
		return numberOfPartition;
	}

	public Integer getReplicationFactor() {
		return replicationFactor;
	}

	public String getDescription() {
		return description;
	}
	
}