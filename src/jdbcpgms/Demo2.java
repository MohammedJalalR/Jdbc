package jdbcpgms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Demo2 {
	public static void main(String[] args) throws Exception {
		System.out.println("*****Main Starts*****");
		// Step-1:Register Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step-2:Establishing DB connection
		Connection conobj = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "1234");
		// step-3:Create sql statement
		Statement stmt = conobj.createStatement();
		// Step-4:Execute sql Query
		ResultSet rsobj = stmt.executeQuery("select * from actor");
		// Step-5:Process the Result & fetch the record one row at a time 
		rsobj.next();
		int id=rsobj.getInt("actor_id");
		String fname=rsobj.getString("first_name");
		String lname=rsobj.getString("last_name");
		System.out.println(id+"\t"+fname+"\t"+lname);	
		// Step-6:close the db connection
		rsobj.close();
		stmt.close();
		conobj.close();
		System.out.println("*****Main Ends** ***");
	}
}



