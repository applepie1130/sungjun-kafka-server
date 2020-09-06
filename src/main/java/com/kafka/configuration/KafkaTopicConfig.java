
package com.kafka.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import com.kafka.model.type.TopicType;

@Configuration
public class KafkaTopicConfig {
	
	@Value(value = "${kafka.bootstrap-servers}")
	private String bootstrapServers;

    /**
     * Topic에 대한 Bean 추가를 위한 KafkaAdmin 설정
     * @return
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic testTopic01() {
        return TopicBuilder.name(TopicType.TEST_TOPIC_01.getName())
        		.partitions(TopicType.TEST_TOPIC_01.getNumberOfPartition())
        		.replicas(TopicType.TEST_TOPIC_01.getReplicationFactor())
        		.build();
    }
    
    @Bean
    public NewTopic testTopic02() {
        return TopicBuilder.name(TopicType.TEST_TOPIC_02.getName())
        		.partitions(TopicType.TEST_TOPIC_02.getNumberOfPartition())
        		.replicas(TopicType.TEST_TOPIC_02.getReplicationFactor())
        		.build();
    }
    
    @Bean
    public NewTopic testTopic03() {
        return TopicBuilder.name(TopicType.TEST_TOPIC_03.getName())
        		.partitions(TopicType.TEST_TOPIC_03.getNumberOfPartition())
        		.replicas(TopicType.TEST_TOPIC_03.getReplicationFactor())
        		.build();
    }
    
    @Bean
    public NewTopic tempTableTopic() {
    	return TopicBuilder.name(TopicType.TEMP_TABLE_TOPIC.getName())
        		.partitions(TopicType.TEMP_TABLE_TOPIC.getNumberOfPartition())
        		.replicas(TopicType.TEMP_TABLE_TOPIC.getReplicationFactor())
        		.build();
    }
}
