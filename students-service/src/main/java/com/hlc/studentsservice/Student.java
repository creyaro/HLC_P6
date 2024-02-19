package com.hlc.studentsservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String id;
    private String name;
    @Field("birth_date")
    private String birthDate;
    private String dni;

    public Student(String name, String birthDate, String dni) {
        this.name = name;
        this.birthDate = birthDate;
        this.dni = dni;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}