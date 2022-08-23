package com.qa.amazon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
	
	String name = "Tommy Jones";
	String ps = "E8 4QB";
	int age = 32;
	long m = 779456435;
	
	@Test
	public void constructerTest() {
		Person p = new Person(name,ps,age,m);
		assertEquals(name,p.getName());
		assertEquals(age,p.getAge());
		assertEquals(ps,p.getPostcode());
		assertEquals(m,p.getMobile());
		
	}
	@Test
	public void gettersAndSettersTest() {
		Person p = new Person();
		p.setAge(age);
		p.setMobile(m);
		p.setPostcode(ps);
		p.setName(name);
		p.setId(10);
		
		assertEquals(name,p.getName());
		assertEquals(age,p.getAge());
		assertEquals(ps,p.getPostcode());
		assertEquals(m,p.getMobile());
		assertEquals(10,p.getId());
		
	}

}
