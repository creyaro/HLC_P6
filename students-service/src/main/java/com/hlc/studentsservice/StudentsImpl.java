package com.hlc.studentsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentsImpl {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = studentsRepository.findAll();
        // Log or print the students list to check the birthDate field
        System.out.println(students);
        return students;
    }

    @GetMapping("/example")
    public List<Student> getExampleStudents() {
        return Arrays.asList(
                new Student("1", "John", "29/01/2000", "12312312A"),
                new Student("2", "Alice", "12/04/2003", "87654321B"));
    }

    @PostMapping("/students")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        // Se verifica que los campos requeridos no sean nulos
        if (student.getName() == null || student.getBirthDate() == null || student.getDni() == null) {
            return ResponseEntity.badRequest().body("Fields name, birth_date and dni are required.");
        }

        // Se verifica que la fecha de nacimiento sea pasada
        LocalDate birthDate = LocalDate.parse(student.getBirthDate());
        LocalDate currentDate = LocalDate.now();
        if (birthDate.isAfter(currentDate)) {
            return ResponseEntity.badRequest().body("Field birthDate must be a past date.");
        }

        // Se crea el estudiante en bd
        Student persistedStudent = studentsRepository.save(new Student(student.getName(), student.getBirthDate(), student.getDni()));

        return ResponseEntity.status(HttpStatus.CREATED).body(persistedStudent.toString());
    }
}