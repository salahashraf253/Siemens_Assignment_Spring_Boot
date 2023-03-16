package com.example.siemens_spring_boot_assignment.controller;

import com.example.siemens_spring_boot_assignment.entity.Teacher;
import com.example.siemens_spring_boot_assignment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/withPrefix/")
    public List<Teacher> getAllTeachersByPrefix(@RequestParam(required = false) String namePrefix) {
        if (namePrefix.isBlank()) {
            return teacherService.findAll();
        } else {
            return teacherService.getAllTeachersContaining(namePrefix);
        }
    }

    @GetMapping("/{mail}")
    public ResponseEntity<Teacher> getTeacherByMail(@PathVariable String mail) {
        Teacher teacher = teacherService.getTeacherByMail(mail);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long teacherId) {
        Optional<Teacher> teacher = teacherService.getTeacherById(teacherId);
        if (teacher.isPresent()) {
            teacherService.deleteTeacherById(teacherId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
