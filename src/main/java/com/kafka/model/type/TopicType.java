package com.kafka.model.type;

import lombok.Getter;

/**
 * TopicType
 *  
 * @author sungjunkim
 *
 */
public enum TopicType {
	
	TEST_TOPIC_01("test-topic-01", 2, 1, "테스트용 topic-01"),
	TEST_TOPIC_02("test-topic-02", 2, 1, "테스트용 topic-02"),
	TEST_TOPIC_03("test-topic-03", 2, 1, "테스트용 topic-03"),
	TEMP_TABLE_TOPIC("temp-table-topic", 2, 1, "mysql temp table topic")
	;

	@Getter
	private String name;
	
	// Topic의 파티션 수
	@Getter
	private Integer numberOfPartition;
	
	// Repication 수 
	@Getter
	private Integer replicationFactor;
	
	@Getter
	private String description;
	
	private TopicType(String name, Integer numberOfPartition, Integer replicationFactor, String description) {
		this.name = name;
		this.numberOfPartition = numberOfPartition;
		this.replicationFactor = replicationFactor;
		this.description = description;
	}
	
}