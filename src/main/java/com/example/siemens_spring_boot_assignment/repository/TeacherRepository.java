package com.example.siemens_spring_boot_assignment.repository;

import com.example.siemens_spring_boot_assignment.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherByFirstName(String firstName);

    //    List<Teacher> findTeachersByFirstNameOrLastNameContaining(char letter,char letter2);
    List<Teacher> findTeachersByFirstNameContainsOrLastNameContains(char letter, char letter2);
}
