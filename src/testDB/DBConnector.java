package testDB;

import java.sql.*;

public class DBConnector {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";
	static final String USER = "fgg";
	static final String PASS = "123456";
	static Connection conn = null;
	static Statement stmt = null;
	
	public static boolean Connect() {
		boolean ifHasConnection = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (Exception e) {
			ifHasConnection = false;
		}
		return ifHasConnection;
	}

	public static void ImportTable(String... args) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE IF NOT EXISTS " + args[0] + "(");
		for (int i = 1; i < args.length; i+=2) {
			sb.append(args[i] + " " + args[i+1] + ",");
		}
		sb.setLength(sb.length() - 1);
		sb.append(");");
		try {
			stmt = conn.createStatement();
	      	stmt.executeUpdate(sb.toString());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ConnectionClose(){
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
	
	
	
	
	public static void DropTable(String string) {
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate("drop table "+ string);
		} catch (Exception e) {
		}
	}

	/*public static String TableView (String... string){
		String returnTable;
		stmt = conn.createStatement();
		returnTable = (String) stmt.executeQuery("SELECT * FROM public.users;");
		return returnTable;
	}*/
	
	public static void TableInsert(){
		
	}

	public static void TableUpdate(){
		
		
	}
}