/* CREATED BY: LEON SILAS
 * CREATED ON: 18/04/21
 * PURPOSE: SHOW USE OF SQLITE DATABASE WITH JAVA.
 * NOTES: CONNECTION AND STATEMENT IS STATED ONCE FOR ENTIRETY OF CODE, BUT IF YOU WANT TO TEST PARTS YOU MUST KEEP IT IN.
 * 		  DATABASE IS CONNECTED IN EACH BLOCK OF CODE FOR SAKE OF TESTING INDIVIDUAL CODE WHEN COMMENTING OUT.
 * 		  IDEALLY YOU WOULD ONLY CONNECT THE DATABSE ONCE AND THEN DISCONNECTED ONCE ALL IN A SINGLE TRY AND CATCH BLOCK.
 * 		  PLEASE NOTE THAT CERTAIN PARAMETERS ARE LABELED DIFFERENT FOR SQLITE SINCE IT DOES NOT TAKE VARIABLES SUCH AS LONG.
 */

package pw4;
import java.sql.*;
import java.util.ArrayList;

public class SQLiteMain {

	public static void main(String[] args) {
		
		/* Create a connection to a relational database using SQLite or MySQL.*/
		System.out.println("=====================================\n"); 
		//connection and statements **NEEDED FOR ALL PARTS OF THE CODE**
		Connection c = null;
		Statement stmt = null;
		
		//connection to database
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");  
		System.out.println("=====================================\n");
	      
		/* Create a single database table to hold information.
		 * 
		 * Note that once you have the DB created, you don�t want to do this again every time you run your test program. 
		 * The easiest way to deal with this � for this assignment - is to comment out the code that creates the DB creation 
		 * and the table creation while you experiment with the following.
		 * 
		 * Let's make a simple class called Person for this exercise. 
		 * 	 firstName (String), lastName(String), age (int), ssn (long), creditCard (long)
		 */
		System.out.println("=====================================\n");  
		try {
		//connection to database
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		
		//creation of table
			stmt = c.createStatement();
			String dropsql = "DROP TABLE PEOPLE";		//used for testing purposes to be able to drop the entire table and start over
			stmt.executeUpdate(dropsql);				//avoids errors with overlapping table and data usage by accident
			String sql = "CREATE TABLE PEOPLE " +
		                " (ssn				  CHAR(9)	PRIMARY KEY		NOT NULL, " + 
		                " firstName           TEXT						NOT NULL, " + 
		                " lastName            TEXT						NOT NULL, " + 
		                " age            	  INT						NOT NULL, " + 
		                " creditCard          CHAR(19))"; 
			stmt.executeUpdate(sql);
		 
		 //closing database
		     stmt.close();
		     c.close();
		  } catch ( Exception e ) {
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		  }
		
		  System.out.println("Table created successfully"); 
		  System.out.println("=====================================\n");
		/* Demonstrate the insertion of a record into the database. Insert several records.*/
		  System.out.println("=====================================\n");
		try {
			 //connection to database
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);

	         //insertion of records
	         stmt = c.createStatement();
	         String sql = "INSERT INTO PEOPLE (ssn, firstName, lastName, age, creditCard) " +
	                        "VALUES (336294798, 'John', 'Doe', 25, 4439677239200054 );"; 
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO PEOPLE (ssn, firstName, lastName, age, creditCard) " +
	        		 "VALUES (381330121, 'Crist', 'Cleo', 48, 378282246310005 );"; 
	         stmt.executeUpdate(sql);
	         
	         sql = "INSERT INTO PEOPLE (ssn, firstName, lastName, age, creditCard) " +
	        		 "VALUES (503840379, 'Hegmann', 'Gilda', 37, 5105105105105100 );"; 
	         stmt.executeUpdate(sql);
	         
	         sql = "INSERT INTO PEOPLE (ssn, firstName, lastName, age, creditCard) " +
	        		 "VALUES (678052883, 'Doyle', 'Gerard', 24, 4012888888881881 );"; 
	         stmt.executeUpdate(sql);

	         //closing database
	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	      System.out.println("=====================================\n");    
		/* Write a method called insertPerson(Person person) that adds a person object to your database. 
		 * Create another object of type Person, and demonstrate calling your method, passing the object to the method. 
		 */ 
	      System.out.println("=====================================\n");
		try {
			 //connection to database
		     Class.forName("org.sqlite.JDBC");
		     c = DriverManager.getConnection("jdbc:sqlite:test.db");
		     c.setAutoCommit(false);
		
		     //insertion of records
		     stmt = c.createStatement();
		     Person newPerson = new Person(123456789, "Leon", "Silas", 23, 239200054);
		     stmt.executeUpdate(insertPerson(newPerson));
		
		     //closing database
		     stmt.close();
		     c.commit();
		     c.close();
		  } catch ( Exception e ) {
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		  }
		System.out.println("Record inserted successfully");
		System.out.println("=====================================\n");
		/*Demonstrate the retrieval of information from the database. Use SQL Select statements, to retrieve a particular Person from the database.
		 */ 
		System.out.println("=====================================\n");
		try {
			 //connection to database
		     Class.forName("org.sqlite.JDBC");
		     c = DriverManager.getConnection("jdbc:sqlite:test.db");
		     c.setAutoCommit(false);
		
		     //selection of record
		     String sql = "SELECT * FROM PEOPLE WHERE age = 23";
		     Statement st = c.createStatement();
		     ResultSet rs = st.executeQuery(sql);
		     ResultSetMetaData rsmd = rs.getMetaData();
		     int colNum = rsmd.getColumnCount();
		     System.out.println("Record found successfully\n");
		     
		     //prints out selection
		     while (rs.next()) {
		         for (int i = 1; i <= colNum; i++) {
		             String columnValue = rs.getString(i);
		             System.out.println(rsmd.getColumnName(i) + ": " + columnValue);
		         }
		         System.out.println("");
		     }
		
		     //closing database
		     stmt.close();
		     c.commit();
		     c.close();
		  } catch ( Exception e ) {
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		  }
		System.out.println("=====================================\n");
		/* Write a method called selectPerson that returns a Person object. This method retrieves the data for a Person from the database. 
		 * We also need to pass a parameter to identify what person. You can use name if you like, or if you find it easier to use the 
		 * database generated ID that's fine too.  
		 * 
		 * This method returns the object that represents that person. This will require that you extract the data that is returned from the database,
		 * and call the Person constructor. (This is the data-exchange between the relational database and the business layer. )
		 */
		System.out.println("=====================================\n");
		try {
			 //connection to database
		     Class.forName("org.sqlite.JDBC");
		     c = DriverManager.getConnection("jdbc:sqlite:test.db");
		     c.setAutoCommit(false);
		
		     //selection of all records in the database
		     System.out.println(selectPerson("Leon", "Silas", c).toString());
		
		     //closing database
		     stmt.close();
		     c.commit();
		     c.close();
		  } catch ( Exception e ) {
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		  }
		System.out.println("=====================================\n");
		/* Write a method called findAllPeople that returns an ArrayList<Person> of objects containing all the people in the database. 
		 * Demonstrate that it is working correctly.
		 */
		System.out.println("=====================================\n");
		try {
			 //connection to database
		     Class.forName("org.sqlite.JDBC");
		     c = DriverManager.getConnection("jdbc:sqlite:test.db");
		     c.setAutoCommit(false);
		
		     //selection of all records in the database
		     findAllPeople(c);
		
		     //closing database
		     stmt.close();
		     c.commit();
		     c.close();
		  } catch ( Exception e ) {
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		  }
		System.out.println("=====================================\n");
		 /*Write a method called deletePerson that removes a person from the database. The parameters will be first name and last name. 
		 * Print out on the console the data from the record that is being deleted. Use your findAllPeople method to verify that that person has been
		 * removed from the database. Consider what this method should return. 
		 * Suppose the person is not found, should the method return that information somehow?
		 */
		System.out.println("=====================================\n");
		try {
			 //connection to database
		     Class.forName("org.sqlite.JDBC");
		     c = DriverManager.getConnection("jdbc:sqlite:test.db");
		     c.setAutoCommit(false);
		
		     //deletion of person
		     deletePerson("Leon", "Silas", c); //test to show existing record
		     deletePerson("Bailey", "McDaniel", c); //test to show non-existent record
		
		     //closing database
		     stmt.close();
		     c.commit();
		     c.close();
		  } catch ( Exception e ) {
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		  }
		System.out.println("=====================================\n");
	      
	}//end of Main 
	  
	 public static String insertPerson(Person person) {
		 String firstName = person.getFirstName();
		 String lastName = person.getLastName();
		 int age = person.getAge();
		 long ssn = person.getSsn();
		 long creditCard = person.getCreditCard();
		  
		 String sql = "INSERT INTO PEOPLE (ssn, firstName, lastName, age, creditCard) " + 
				  		  "VALUES (" + ssn + ", '" + firstName + "', '" + lastName + "', " + age + ", " + creditCard + " );";
		 return sql;  
	 }//end of insertPerson
	 
	 public static Person selectPerson(String firstName, String lastName, Connection c) {
		 try {
			 //variables, setting statement, etc
			 String sql = "SELECT * FROM PEOPLE WHERE firstName = ? AND lastName = ?";
			 PreparedStatement ps = c.prepareStatement(sql);
			 ps.setString(1, firstName);
			 ps.setString(2, lastName);
			 ResultSet rs = ps.executeQuery();
		     
		     //checks if data even exists in the table
		     if (rs.next()) {
				 rs = ps.executeQuery();
		    	 //print of record being deleted
		    	 System.out.println("Here is the record you searched for");
		    	 while (rs.next()) {
		    		 Long ssn = rs.getLong("ssn"); 
		    		 int age = rs.getInt("age");							
		    		 Long creditCard = rs.getLong("creditCard");
		    		 Person tempPerson = new Person(ssn, firstName, lastName, age, creditCard);
		    		 return tempPerson;
		    	 }
		     }
		     else 
		    	 System.out.println("Record not found");
			 
			} catch ( Exception e ) {
			     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			     System.exit(0);
			}
		 return null;
			
     }//end of selectPerson
	 
	 public static void deletePerson(String firstName, String lastName, Connection c) {
		 try {
			 //variables, setting statement, etc
			 String sql = "SELECT * FROM PEOPLE WHERE firstName = ? AND lastName = ?";
			 PreparedStatement ps = c.prepareStatement(sql);
			 ps.setString(1, firstName);
			 ps.setString(2, lastName);
			 ResultSet rs = ps.executeQuery();
		     ResultSetMetaData rsmd = rs.getMetaData();
		     int colNum = rsmd.getColumnCount();
		     
		     //checks if data even exists in the table
		     if (rs.next()) {
				 rs = ps.executeQuery();
		    	 //print of record being deleted
		    	 System.out.println("This is the record you are trying to delete");
			     while (rs.next()) {
			         for (int i = 1; i <= colNum; i++) {
			             String columnValue = rs.getString(i);
			             System.out.println(rsmd.getColumnName(i) + ": " + columnValue);
			         }
			         System.out.println("");
			     }
				 //deletion of record
				 sql = "DELETE FROM PEOPLE WHERE firstName = ? AND lastName = ?";
				 ps = c.prepareStatement(sql);
				 ps.setString(1, firstName);
				 ps.setString(2, lastName);
				 ps.executeUpdate(); 
				 System.out.println("Record deleted successfully");
		     	 System.out.println("Here is the updated database\n");
		     	 findAllPeople(c);
		     }
		     else 
		    	 System.out.println("Record not found\nDeletion cancelled");
			 
			} catch ( Exception e ) {
			     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			     System.exit(0);
			}

     }//end of deletePerson
	 
	 public static void findAllPeople(Connection c) {
		 try {
			//variables
			ArrayList<Person> allPeople = new ArrayList<Person>();
			String sql = "SELECT * FROM PEOPLE";
			PreparedStatement ps = c.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
			
			//adds to ArrayList
			while(rs.next()) {
	            Person person = new Person(rs.getLong("ssn"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("age"), rs.getLong("creditCard"));
	            allPeople.add(person);
	        }
			for(Person i : allPeople) {
				System.out.println(i.toString() + "\n");
			}
			
		} catch ( Exception e ) {
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		}

     }//end of findAllPeople
	
}//end of SQLiteJDBC
