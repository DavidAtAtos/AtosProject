package com.qa.amazon;

public class Person {
	private int id ;
	
	


	private String name;
	private String postcode;
	private int age;
	private long mobile;
	
	
	public Person(String name,String postcode,int age,long mobile) {
		this.name = name;
		this.postcode = postcode;
		this.age = age;
		this.mobile = mobile;
}
	
	public Person() {
		
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
