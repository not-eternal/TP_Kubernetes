package com.insa.fr.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    public static final String ADD_STUDENT_TOPIC = "AddStudent";
    public static final String GET_STUDENT_TOPIC = "GetStudent";
    public static final String LIST_STUDENT_TOPIC = "ListStudent";

    @Bean
    public NewTopic addStudentTopic() {
        return new NewTopic(ADD_STUDENT_TOPIC, 1, (short) 1);
    }

    @Bean
    public NewTopic getStudentTopic() {
        return new NewTopic(GET_STUDENT_TOPIC, 1, (short) 1);
    }

    @Bean
    public NewTopic listStudentTopic() {
        return new NewTopic(LIST_STUDENT_TOPIC, 1, (short) 1);
    }
}
