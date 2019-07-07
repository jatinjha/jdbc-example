package Example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	
	public static void main(String[] args) throws SQLException{
		
		
		Connection myconn = null;
	    PreparedStatement prepstat = null;//Statement stat = null;
		ResultSet rs = null;
		
		try {
			  myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentjj", "studentjj" , "jjjjjj");
			  
			  
			  /*
			   
			  stat = myconn.createStatement();
			   
			  int rows_effected_insert = stat.executeUpdate("insert into employees "+"(last_name,first_name,email,department,salary)"+"values"+"('jatin','jha','jatinjha007@gmail.com','tech','10000000')");
			  int rows_effected_update = stat.executeUpdate(" update employees "+"set email = 'jatinjha30@gmail.com'"+"where last_name = 'jha' and first_name = 'jatin' ");
			  int rowsAffected = stat.executeUpdate(
						"delete from employees " +
						"where last_name='Johnson' and first_name='Lisa'");
			  
			  
			  
			  rs = stat.executeQuery("select * from employees ");
			  
			  while(rs.next()) {
				  
				  System.out.println("first name "+rs.getString("first_name")+" "+"last name "+rs.getString("last_name"));
		
			  }
			  
			 */ 
			  ////////<<<<<<<<<<<<<<<<<<<<========================== Prepare statement example =================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//////////////////////////////////
			  
			  prepstat = myconn.prepareStatement("select * from employees where salary > ? and department = ? ");
			  
			  prepstat.setDouble(1, 10000);
			  prepstat.setString(2, "Legal");
			  
			  
			  rs = prepstat.executeQuery();
			  
              while(rs.next()) {
				  
				  System.out.println("first name "+rs.getString("first_name")+" "+"last name "+rs.getString("last_name"));
		
			  }
			  
			  
			  
		} finally {
			myconn.close();
			//stat.close();
			//rs.close();
		}
		
		
		
	}

}
