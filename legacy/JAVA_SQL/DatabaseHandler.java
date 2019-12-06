// ***************************************************************
// Name: Nathan Graves
// Date Last Modified: 9/30/2019
//
// The DatabaseHandler class is written to allow java interaction
// with a SQL database.
//
// ***************************************************************

package foodSQL;
import java.sql.*;


public class DatabaseHandler {
	
	private Connection conn;
	private String dataBaseName;
	private ResultSet rs;
	
	public DatabaseHandler(String dbName) { //Constructor for Database Handler
		
		setDataBaseName(dbName);
		
		try { //create connection with database, makes new if does not exist
			setConn(DriverManager.getConnection("jdbc:h2:~/".concat(dbName), "sa", ""));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void dbInsert(String tableName, String[] values) {//inserts values into table
		System.out.println("Function not yet implemented");
		
		this.openConn();
		
		String query = "INSERT INTO " + tableName;
		
		try {
			Statement stmt = this.getConn().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void createTable(String tableName, String[] names, String[] datatypes, String[] modifiers) {
		this.openConn();
		
		String query = "CREATE TABLE IF NOT EXISTS " + tableName +" (";
		
		for(int i = 0; i<names.length; i++) { //loop through to create SQL statement
			query = query.concat(names[i] + " " + datatypes[i] + " " + modifiers[i]);
			
			if(i == names.length-1) {
				continue; //escape loop to prevent comma at end
			}
			query = query.concat(", ");
		}
		query = query.concat(");");
		
		try { //try executing the SQL statement
			Statement stmt = getConn().createStatement();
			
			int rs = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.connClose();
	}
	
	public ResultSet dbQuery(String query) { //submits generic query to database
		
		this.openConn();
		this.setRs(null);
		
		try {
			Statement stmt = getConn().createStatement();
			
			this.setRs(stmt.executeQuery(query));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.connClose();
		
		return this.getRs();
	}
	
	public void PrintResultSet() {
		System.out.println("Function not yet implemented");
		this.getRs();
		
		
	}
	
	public void connClose() {
		try {
			getConn().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openConn() {
		
		try { //create connection with database, makes new if does not exist
			setConn(DriverManager.getConnection("jdbc:h2:~/".concat(this.getDataBaseName()), "sa", ""));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//SETTERS AND GETTERS
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
	
	

} // End Class DatabaseHandler
