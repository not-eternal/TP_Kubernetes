package com.insa.fr.services;

import com.insa.fr.entity.Students;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class StudentCache {

    private List<Students> students = new CopyOnWriteArrayList<>();

    public void setStudents(List<Students> students) {
        this.students.clear();
        this.students.addAll(students);
    }

    public List<Students> getStudents() {
        return students;
    }
}
