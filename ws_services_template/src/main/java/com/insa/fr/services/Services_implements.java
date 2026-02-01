package com.insa.fr.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insa.fr.Kafka.StudentProducer;
import com.insa.fr.entity.Students;

@Service
public class Services_implements implements Services_Interface {

    private final StudentProducer studentProducer;
    private final StudentCache studentCache;

    public Services_implements(StudentProducer studentProducer, StudentCache studentCache) {
        this.studentProducer = studentProducer;
        this.studentCache = studentCache;
    }

    /**
     * CREATE student
     */
    @Override
    public int createStudent(Students stud) {
        studentProducer.sendStudentCreated(stud);
        return 1;
    }

    /**
     * GET all students
     */
    @Override
    public List<Students> getStudents() {

        studentProducer.ListStudent();

        try {
            Thread.sleep(500); // TP only
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return studentCache.getStudents();
    }

    /**
     * GET student by id
     */
    @Override
    public List<Students> getStudent(String id) {
        return Collections.emptyList();
    }

    @Override
    public boolean updateStudent(Students stud, String id) {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        return false;
    }
}
