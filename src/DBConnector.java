import java.sql.*;

import java.sql.DriverManager;

public class DBConnector {
	public static Connection  getDBconnector() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem","root","");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	

}
