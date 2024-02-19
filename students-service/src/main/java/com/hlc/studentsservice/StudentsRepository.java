package com.hlc.studentsservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends MongoRepository<Student, String> {

    // Método para buscar todas las asignaturas
    List<Student> findAll();
}
