package com.auca.StudentRegistration_24410.Model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;

@Entity
public class AcademicUnit_24410 {
    @Id
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private EAcademicUnit_24410 unitType;

    @ManyToOne
    @JoinColumn(name = "parent_unit_code")
    private AcademicUnit_24410 parentUnit;

    public AcademicUnit_24410() {
    }

    public AcademicUnit_24410(String code, String name, EAcademicUnit_24410 unitType, AcademicUnit_24410 parentUnit) {
        this.code = code;
        this.name = name;
        this.unitType = unitType;
        this.parentUnit = parentUnit;
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

    public EAcademicUnit_24410 getUnitType() {
        return unitType;
    }

    public void setUnitType(EAcademicUnit_24410 unitType) {
        this.unitType = unitType;
    }

    public AcademicUnit_24410 getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(AcademicUnit_24410 parentUnit) {
        this.parentUnit = parentUnit;
    }
}
