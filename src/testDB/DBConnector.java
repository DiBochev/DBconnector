package testDB;

import java.sql.*;

public class DBConnector {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static String DB_URL = "jdbc:mysql://localhost/";
	static final String USER = "fgg";
	static final String PASS = "123456";
	static Connection conn = null;
	static Statement stmt = null;
	
	public static boolean Connect(String DBName) {
		boolean ifHasConnection = false;
		DB_URL += DBName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			ifHasConnection = false;
		}
		return ifHasConnection;
	}

	public static void CreateTable(String... args) {
		// in this method first variable must be table name, second col. name then type... then repeat 		
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
		System.out.println("table created");
	}
	
	public static void ConnectionClose(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DropTable(String table) {
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate("drop table "+ table);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void TableInsert(String... args){
		
		//INSERT INTO table_name
		//VALUES (value1,value2,value3,...);
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + args[0] + " VALUES (");
		for (int i = 1; i < args.length; i++) {
			sb.append(args[i] + ", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(");");
		try {
			stmt = conn.createStatement();
	      	stmt.executeUpdate(sb.toString());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TableView (String... args){
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("Select ");
		try {
			stmt = conn.createStatement();
			for (int i = 1; i < args.length; i++) {
				sb.append(args[i] + ", ");
			}
			sb.setLength(sb.length() - 2);
			sb.append(" FROM " + args[0]);
			rs = stmt.executeQuery(sb.toString());
			while ( rs.next() ) {
                 for (int i = 1; i < args.length; i++) {
					System.out.println(args[i] + ": " + rs.getString(args[i]));
				}
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}