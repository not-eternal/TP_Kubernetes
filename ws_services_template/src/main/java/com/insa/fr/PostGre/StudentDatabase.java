package com.insa.fr.PostGre;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDatabase {

    private final JdbcTemplate jdbcTemplate;

    public StudentDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Student student) {
        jdbcTemplate.update(
            "INSERT INTO students(nom, prenom, mail, formation) VALUES (?, ?, ?, ?)",
            student.getNom(),
            student.getPrenom(),
            student.getMail(),
            student.getFormation()
        );
    }

    public List<Student> findAll() {
        return jdbcTemplate.query(
            "SELECT nom, prenom, mail, formation FROM students",
            (rs, rowNum) -> {
                Student student = new Student();
                student.setNom(rs.getString("nom"));
                student.setPrenom(rs.getString("prenom"));
                student.setMail(rs.getString("mail"));
                student.setFormation(rs.getString("formation"));
                return student;
            }
        );
    }
}
