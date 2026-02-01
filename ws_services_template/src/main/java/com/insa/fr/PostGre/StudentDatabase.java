package com.insa.fr.PostGre;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.insa.fr.entity.Students;


@Repository
public class StudentDatabase {

    private final JdbcTemplate jdbcTemplate;

    public StudentDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Students student) {
        jdbcTemplate.update(
            "INSERT INTO students(nom, prenom, mail, formation) VALUES (?, ?, ?, ?)",
            student.getNom(),
            student.getPrenom(),
            student.getMail(),
            student.getFormation()
        );
    }

    public List<Students> findAll() {
        return jdbcTemplate.query(
            "SELECT nom, prenom, mail, formation FROM students",
            (rs, rowNum) -> {
                Students student = new Students();
                student.setNom(rs.getString("nom"));
                student.setPrenom(rs.getString("prenom"));
                student.setMail(rs.getString("mail"));
                student.setFormation(rs.getString("formation"));
                return student;
            }
        );
    }
}
