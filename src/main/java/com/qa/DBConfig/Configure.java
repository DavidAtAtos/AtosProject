package com.qa.DBConfig;

public class Configure {
	
		//Connect to database, we need 3 things:
			// - url
			// - password
			// - username
			// static - only one instance of that variable/method
			// final - fixed, can't be changed (constant)
		
		//                                                                db
		protected static final String URL = "jdbc:mysql://localhost:3306/amazon";
		protected static final String USER = "root";
		protected static final String PASS = "pass";
		public static String getUrl() {
			return URL;
		}
		public static String getUser() {
			return USER;
		}
		public static String getPass() {
			return PASS;
		}

	}
	


