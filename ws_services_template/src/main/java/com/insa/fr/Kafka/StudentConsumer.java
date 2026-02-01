package com.insa.fr.Kafka;

import com.insa.fr.entity.Students;
import com.insa.fr.services.StudentCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentConsumer {

    @Autowired
    private StudentCache studentCache;

    @KafkaListener(topics = "ListStudent", groupId = "student-group")
    public void onStudentsList(List<Students> students) {
        studentCache.setStudents(students);
        System.out.println("Cache étudiants mis à jour : " + students.size());
    }
}
