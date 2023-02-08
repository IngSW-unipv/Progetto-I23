package it.unipv.ingsfw.ispafd.atl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	private static String username;
	private static String password;
	private static String dbDriver;
	private static String dbURL;
	private static DBConnection conn;
	
	private static void init() {
		username="root";
		password="password";
		dbDriver ="com.mysql.cj.jdbc.Driver";
		dbURL ="jdbc:mysql://127.0.0.1:3306/%s";
			
	}

	public static Connection startConnection(Connection conn, String schema)
	{
		init();
		System.out.println(dbURL);
	
		
		
		if ( isOpen(conn) )
			closeConnection(conn);
	
		try 
		{
			
			dbURL=String.format(dbURL,schema); 
			System.out.println(dbURL);
			Class.forName(dbDriver);
			
			conn = DriverManager.getConnection(dbURL, username, password);// Apertura connessione

		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static boolean isOpen(Connection conn)
	{
		if (conn == null)
			return false;
		else
			return true;
	}

	public static Connection closeConnection(Connection conn)
	{
		if ( !isOpen(conn) )
			return null;
		try 
		{

			conn.close();
			conn = null;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}

