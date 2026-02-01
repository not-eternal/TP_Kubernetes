package com.insa.fr;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.admin.AdminClient;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaTopicChecker {

    private final AdminClient adminClient;

    public KafkaTopicChecker(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void checkTopics() throws ExecutionException, InterruptedException {
        ListTopicsResult topics = adminClient.listTopics();
        System.out.println("Topics Kafka présents : " + topics.names().get());
    }
}
