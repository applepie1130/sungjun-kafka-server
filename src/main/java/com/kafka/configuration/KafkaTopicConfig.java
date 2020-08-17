
package com.kafka.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public NewTopic testTopic() {
        return new NewTopic(TopicType.TEST_TOPIC.getName(), 
        		TopicType.TEST_TOPIC.getNumberOfPartition(),
        		TopicType.TEST_TOPIC.getReplicationFactor());
    }
}
