package com.insa.fr.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.insa.fr.entity.Students;

@Component
public class StudentProducer {

    private final KafkaTemplate<String, Students> kafkaTemplate;

    public StudentProducer(KafkaTemplate<String, Students> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStudentCreated(Students student) {
        kafkaTemplate.send("student.create", student);
    }
}
