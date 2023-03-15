package com.example.siemens_spring_boot_assignment.controller;

import com.example.siemens_spring_boot_assignment.entity.Teacher;
import com.example.siemens_spring_boot_assignment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @PostMapping("")
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Teacher> getTeacherByFirstName(@PathVariable String firstName) {
        Teacher teacher = teacherService.getTeacherByFirstName(firstName);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public List<Teacher> getAllTeachersByLetter(@RequestParam(required = false) String name) {
        if (name.equals("")) {
            return teacherService.findAll();
        } else {
            return teacherService.getAllTeachersContaining(name);
        }
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacherById(teacherId);
    }
}
