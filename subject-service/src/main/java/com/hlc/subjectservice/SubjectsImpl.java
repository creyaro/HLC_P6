package com.hlc.subjectservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectsImpl implements Subjects {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable String id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        return optionalSubject.map(subject -> new ResponseEntity<>(subject, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/subjects")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject newSubject) {
        Subject createdSubject = subjectRepository.save(newSubject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String id, @RequestBody Subject updatedSubject) {
        if (subjectRepository.existsById(id)) {
            updatedSubject.setId(id);
            Subject savedSubject = subjectRepository.save(updatedSubject);
            return new ResponseEntity<>(savedSubject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
