package com.qa.crud;
import com.qa.DBConfig.Configure;
import com.qa.amazon.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




public class CRUDTest {
	CRUD c = new CRUD();
	String name = "Tommy Jones";
	String ps = "E8 4QB";
	int age = 32;
	long m = 779456435;
	
	
	Person p = new Person(name,ps,age,m);
	Person q = new Person("Johny","E8 4QB",16,77896532);
	
	private Statement stmt;
	 Connection conn;
	 private ResultSet rs;
	 
	
	@Before
	public void connection() {
		 Connection conn;// has a driver manager class which contains the methods to connect to db
		Statement stmt;
		try {
			conn = DriverManager.getConnection(Configure.getUrl(), Configure.getUser(), Configure.getPass());
			this.stmt = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			
		}
		
		
	 
		
	}
	
	@Test
	public void createTest() {
		//p.setId(4);
		c.create(p);
		assertEquals(name,p.getName());
		assertEquals(ps,p.getPostcode());
		 
		}
	
	//@Test
	//public void throwcreateexception() {
		//SQLException dummyexe = assertThrows(SQLException.class,() -> q.(-1));
			
	

	@Test
	public void readTestbyid()  {
		//p.setId(4);
		
		
		c.readById(p);
		
		String readStmt = "SELECT * FROM person WHERE id = " +p.getId()+";";
		try {
			rs = stmt.executeQuery(readStmt);
			System.out.println(p.getId());
			while(rs.next()) {
			//assertEquals(p.getName(),rs.getString("full_name"));
			}
		} catch (SQLException e) {
		
		}

}
	@Test
	public void readTest() {
		c.read();
		
	}
	
	@Test
	public void updateTest() {
		c.update(p, 445643276);
		
	}
	
	@Test
	public void deleteTest() {
		c.delete(p);
	
	}
	

	
	
	
		
	}

