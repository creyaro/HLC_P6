package com.hlc.studentsservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "students")

public class Student {
    @Id
    private String dni;
    private String name;

    @Field("birth_date")
    private String fNacimiento;

    public Student(String dni, String name, String fNacimiento) {
        this.dni = dni;
        this.name = name;
        this.fNacimiento = fNacimiento;
    }

    public Student() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }
}
