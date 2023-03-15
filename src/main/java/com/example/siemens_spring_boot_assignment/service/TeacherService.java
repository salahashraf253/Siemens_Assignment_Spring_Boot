package com.example.siemens_spring_boot_assignment.service;

import com.example.siemens_spring_boot_assignment.entity.Teacher;
import com.example.siemens_spring_boot_assignment.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher getTeacherByFirstName(String firstName) {
        return teacherRepository.findTeacherByFirstName(firstName);
    }

    public List<Teacher> getAllTeachersContaining(String name) {
        return teacherRepository.findTeachersByFirstNameContainsOrLastNameContains(name, name);
    }

    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
