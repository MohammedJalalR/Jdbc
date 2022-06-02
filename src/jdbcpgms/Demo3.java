package jdbcpgms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		System.out.println("*****Main Starts*****");
		// Step-1:Register Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step-2:Establishing DB connection
		Connection conobj = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "1234");
		// step-3:Create sql statement
		Statement stmt = conobj.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		// Step-4:Execute sql Query
		ResultSet rsobj = stmt.executeQuery("select * from actor");
		// Step-5:Process the Result & Navigation
		int CurrentRow = rsobj.getRow();
		System.out.println("CurrentRow:" + CurrentRow);
		rsobj.next();
		rsobj.next();
		rsobj.next();
		System.out.println("CurrentRow:" + CurrentRow);
		rsobj.previous();
		CurrentRow = rsobj.getRow();
		System.out.println("CurrentRow:" + CurrentRow);
		rsobj.last();
		CurrentRow = rsobj.getRow();
		System.out.println("CurrentRow:" + CurrentRow);
		rsobj.beforeFirst();
		CurrentRow = rsobj.getRow();
		System.out.println("CurrentRow:" + CurrentRow);
		rsobj.afterLast();
		CurrentRow = rsobj.getRow();
		System.out.println("CurrentRow:" + CurrentRow);

		// Step-6:close the db connection
		rsobj.close();
		stmt.close();
		conobj.close();
		System.out.println("*****Main Ends*****");
	}

}
