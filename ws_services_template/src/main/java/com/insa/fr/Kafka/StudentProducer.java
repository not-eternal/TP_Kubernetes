package com.insa.fr.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.insa.fr.entity.Students;

@Component
public class StudentProducer {

    private final KafkaTemplate<String, Students> kafkaTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate2;

    public StudentProducer(KafkaTemplate<String, Students> kafkaTemplate, KafkaTemplate<String, String> kafkaTemplate2) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplate2 = kafkaTemplate2;
    }

    public void sendStudentCreated(Students student) {
        kafkaTemplate.send("AddStudent", student);
    }

    public void ListStudent() {
        kafkaTemplate2.send("GetStudent", "Request");
    }
}
