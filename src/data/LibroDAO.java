package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAO {
	private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private String DB_URL = "jdbc:mysql://localhost/bibliotecadb";
	private String DB_USER = "bibliotecario";
	private String DB_PASS = "bibliotecario";
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
		
	public LibroDAO() {
		super();
		// TODO Auto-generated constructor stub
		 try {
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	     } catch (ClassNotFoundException e) {
	            System.err.println("ERROR: failed to load MySQL JDBC driver.");
	            e.printStackTrace();
	     } catch (SQLException e) {
	    	 	System.err.println("ERROR: failed to access database.");
	            e.printStackTrace();
	     }
	}
	
	public ArrayList<Libro> getLibros() {
		try {
			stm = conn.createStatement();
			String consulta = "select * from libros";
			rs = stm.executeQuery(consulta);
			ArrayList<Libro> libros = new ArrayList<Libro>();
			while (rs.next()) {
				Libro libro = new Libro(rs.getInt("isbn"),rs.getString("titulo"),rs.getString("autor"));
				libros.add(libro);
			}
			
			return libros;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: failed to create statement.");
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error cerrando el resultset" + e.getMessage());}
			}
		
	}
	
	
}




