package com.health.vo;

import java.util.Date;
import java.util.List;

public class EnrolleeVO {
    private int id;
    private String name;
    private boolean status;
    private Date birthDate;
    private String phoneNumber;
    private List<DependentVO> dependents;

    public EnrolleeVO(int id, String name, boolean status, Date birthDate, String phoneNumber, List<DependentVO> dependents) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.dependents = dependents;
    }

    public EnrolleeVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<DependentVO> getDependents() {
        return dependents;
    }

    public void setDependents(List<DependentVO> dependents) {
        this.dependents = dependents;
    }
}
