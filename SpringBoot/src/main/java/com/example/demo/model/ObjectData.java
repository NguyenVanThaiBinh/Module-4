package com.example.demo.model;

public class ObjectData {
    private EmployeeEntity employeeEntity;
    private Province province;

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public ObjectData() {
    }
}
