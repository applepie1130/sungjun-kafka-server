package com.kafka.model.type;

import lombok.Getter;

/**
 * ConsumerGroup
 *  
 * @author sungjunkim
 *
 */
public enum ConsumerGroupType {
	
	TEST_CONSUMER_GROUP_01("test-group-01", "테스트용 컨슈머 그룹-01"),
	TEST_CONSUMER_GROUP_02("test-group-02", "테스트용 컨슈머 그룹-02"),
	TEST_CONSUMER_GROUP_03("test-group-03", "테스트용 컨슈머 그룹-03")
	;

	@Getter
	private String name;
	
	@Getter
	private String description;
	
	private ConsumerGroupType(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
}
