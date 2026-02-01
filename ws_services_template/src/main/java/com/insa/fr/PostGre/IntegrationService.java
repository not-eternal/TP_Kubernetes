package com.insa.fr.PostGre;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.insa.fr.entity.Students;



@Service
public class IntegrationService {

    private final StudentDatabase studentDatabase;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public IntegrationService(StudentDatabase studentDatabase,
                                     KafkaTemplate<String, Object> kafkaTemplate) {
        this.studentDatabase = studentDatabase;
        this.kafkaTemplate = kafkaTemplate;
    }

    // =========================
    // ADD STUDENT
    // =========================
    @KafkaListener(topics = "AddStudent")
    public void onAddStudent(Students student) {

        studentDatabase.insert(student);

        System.out.println("Student inséré en base : " + student.getNom());
    }

    // =========================
    // GET STUDENTS
    // =========================
    @KafkaListener(topics = "GetStudent")
    public void onGetStudents(String message) {

        List<Students> students = studentDatabase.findAll();

        kafkaTemplate.send("ListStudent", students);

        System.out.println("Liste étudiants envoyée : " + students.size());
    }
}
