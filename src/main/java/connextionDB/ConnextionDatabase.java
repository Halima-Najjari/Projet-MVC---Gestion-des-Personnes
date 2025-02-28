package connextionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnextionDatabase {
	public static Connection getConnextion() {
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/gestionpersonne";
		String user = "root";
		String passwd = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("Driver ok");
			connection = DriverManager.getConnection(url,user,passwd);
			System.out.print("Connextion effective");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	

}
