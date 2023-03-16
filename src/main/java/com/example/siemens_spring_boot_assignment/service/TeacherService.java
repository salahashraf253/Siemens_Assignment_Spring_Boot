package com.example.siemens_spring_boot_assignment.service;

import com.example.siemens_spring_boot_assignment.entity.Teacher;
import com.example.siemens_spring_boot_assignment.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Teacher> getAllTeachersContaining(String namePrefix) {
        return teacherRepository.findTeachersByFirstNameStartsWithIgnoreCaseOrLastNameStartsWithIgnoreCase(namePrefix, namePrefix);
    }

    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherByMail(String mail) {
        return teacherRepository.findTeacherByMail(mail);
    }

    public Optional<Teacher> getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId);
    }
}
