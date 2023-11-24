package com.auca.StudentRegistration_24410.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CourseDefinition_24410 {
    @Id
    private String code;
    private String name;
    private String description;

    public CourseDefinition_24410() {
    }

    public CourseDefinition_24410(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
