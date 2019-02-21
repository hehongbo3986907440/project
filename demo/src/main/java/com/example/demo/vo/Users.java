package com.example.demo.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;


public class Users implements Serializable{
//	@NotBlank(message="不能为空")
	private int id;
	@NotEmpty(message="不能为null")
	private String name;
	private int age;
	
	public Users(){
		
	}
	
	public Users(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
