package com.example.demo.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "kafka_test", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed Message: " + message);
	}
	
	@KafkaListener(topics = "kafka_topic_json", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
	public void consumeUser(User user) {
		System.out.println("Consumed Message: " + user.toString());
	}
}
