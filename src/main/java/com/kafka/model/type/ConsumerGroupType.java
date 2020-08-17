package com.kafka.model.type;

/**
 * ConsumerGroup
 *  
 * @author sungjunkim
 *
 */
public enum ConsumerGroupType {
	
	TEST_CONSUMER_GROUP("test-group-id", "테스트용 컨슈머 그룹")
	;
	
	private String name;
	
	private String description;
	
	private ConsumerGroupType(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	
	
}
