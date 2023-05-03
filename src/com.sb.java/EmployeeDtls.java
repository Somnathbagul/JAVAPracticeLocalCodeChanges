package com.sb.java;

public class EmployeeDtls
{

    String name;
    Integer id;
    Integer age;
    Double salary;
    String designation;

    public EmployeeDtls(String name, Integer id, Integer age, Double salary, String designation) {
        super();
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    @Override
    public String toString() {
        return "EmployeeDtls [name=" + name + ", id=" + id + ", age=" + age + ", salary=" + salary + ", designation="
                + designation + "]";
    }

}
