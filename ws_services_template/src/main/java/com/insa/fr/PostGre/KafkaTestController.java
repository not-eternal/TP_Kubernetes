package com.insa.fr.PostGre;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class KafkaTestController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaTestController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // =========================
    // ADD STUDENT
    // =========================
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        kafkaTemplate.send("AddStudent", student);
        return "Student envoyé à Kafka";
    }

    // =========================
    // GET STUDENTS
    // =========================
    @GetMapping("/students")
    public String getStudents() {
        kafkaTemplate.send("GetStudent", "get");
        return "Demande de liste envoyée à Kafka";
    }
}
