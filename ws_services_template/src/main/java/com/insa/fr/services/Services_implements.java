package com.insa.fr.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insa.fr.Kafka.StudentProducer;
import com.insa.fr.entity.Students;

@Service
public class Services_implements implements Services_Interface {

    private final StudentProducer studentProducer;

    public Services_implements(StudentProducer studentProducer) {
        this.studentProducer = studentProducer;
    }

    /**
     * CREATE student
     * → publication d’un événement Kafka
     */
    @Override
    public int createStudent(Students stud) {
        studentProducer.sendStudentCreated(stud);
        return 1; // succès symbolique
    }

    /**
     * GET all students
     * → pas encore implémenté (EDA)
     */
    @Override
    public List<Students> getStudents() {
        return Collections.emptyList();
    }

    /**
     * GET student by id
     * → non utilisé par le front
     */
    @Override
    public List<Students> getStudent(String id) {
        return Collections.emptyList();
    }

    /**
     * UPDATE student
     * → non implémenté
     */
    @Override
    public boolean updateStudent(Students stud, String id) {
        return false;
    }

    /**
     * DELETE student
     * → non implémenté
     */
    @Override
    public boolean deleteStudent(String id) {
        return false;
    }
}
