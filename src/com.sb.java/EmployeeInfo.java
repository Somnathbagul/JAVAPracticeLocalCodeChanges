package com.sb.java;

public class EmployeeInfo {
	Integer id;
	String name;
	String dept;
	String gender;
	Double salary;

	public EmployeeInfo(Integer id, String name, String dept, String gender, Double salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.gender = gender;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeInfo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dept='" + dept + '\'' +
				", gender='" + gender + '\'' +
				", salary=" + salary +
				'}';
	}
}
