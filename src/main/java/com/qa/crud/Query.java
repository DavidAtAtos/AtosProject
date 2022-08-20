package com.qa.crud;
import java.util.Scanner;
//import com.qa.crud.CRUD;
import com.qa.amazon.Person;

public class Query {
	


	

		private static Scanner sc = new Scanner(System.in);
		Person p = new Person();

		public String getInput() {
			System.out.println("Enter CRUD choice: ");
			return sc.nextLine();
		}

		public void choice() {
			// create an instance of the CRUD queries class to open the connection
			CRUD q = new CRUD();

			// Ask for user input on the CRUD choice in the getInput method and store the
			// result in the crud variable
			String crud = getInput();

			// try-finally block so the finally block can close the connection
			try {
				// do-while loop to start the loop and present the options to interact with the
				// database
				do {
					// switch case to match which CRUD operation to perform
					switch (crud.toLowerCase()) {
					case "create":
						System.out.println("Enter full name: ");
						//String name = sc.nextLine();
						String name = sc.nextLine();
						p.setName(name);
						System.out.println("Enter age: ");
						int age = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter postcode: ");
						String postcode = sc.nextLine();
						System.out.println("Enter mobile: ");
						long mobile = sc.nextInt();
						sc.nextLine();
						q.create(new Person(name, postcode, age, mobile));
						break;
					case "read":
						System.out.println("Do you want read a specific line? (y/n)");
						String ans = sc.nextLine();
						if(ans.equals("y")) {
							System.out.println("What is the id?");
							int id = sc.nextInt();
							sc.nextLine();
							p.setId(id);
							q.readById(p);
						}
						else
							q.read();
						break;
					case "update":
						System.out.println("Enter id of record to update: ");
						int uid = sc.nextInt();
						sc.nextLine();//capture enter key
						System.out.println("Enter the new model of the vehicle: ");
						String number = sc.nextLine();
						p.setId(uid);
						q.update(p, number);					
						break;
					case "delete":
						System.out.println("Enter id of record to delete: ");
						int id = sc.nextInt();
						sc.nextLine();//capture enter key
						p.setId(id);
						q.delete(p);
						break;
					default:
						System.out.println("Invalid CRUD choice");
					}
					// check if user wants to continue or break out of the loop
					System.out.println("Would you like to continue? (y/n)");
					String quit = sc.nextLine();
					if (quit.toLowerCase().equals("y")) {
						crud = getInput();
					} else if (quit.toLowerCase().equals("n")) {
						crud = "quit";
					} else {
						System.out.println("Please enter 'y' or 'n'");
					}

				} while (!crud.equals("quit"));
				System.out.println("Goodbye!");
			} finally {
				q.closeConn();
			}
		}

	}



