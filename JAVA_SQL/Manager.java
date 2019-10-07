// ***************************************************************
// Name: Nathan Graves
// Date Last Modified: 9/30/2019
//
// The manager class is simply a test zone for the other classes
// in the foodSQL package
//
// ***************************************************************


package foodSQL;

public class Manager {

	public static void main(String[] args) {
		//Testing database creation and connection open/close
		System.out.println("Hey");
		DatabaseHandler testDB = new DatabaseHandler("testDb2");
		System.out.println("Hey");
		testDB.connClose();
		testDB.openConn();
		testDB.connClose();
		System.out.println("Hey");
		
		
		//Testing table creation
		String[] names = new String[3];
		names[0] = "PRIMARY_KEY"; names[1] = "Sebastian"; names[2] = "Joseph";
		
		String[] datatypes = new String[3];
		datatypes[0] = "int"; datatypes[1] = "VARCHAR(255)"; datatypes[2] = "int";
				
		String[] modifiers = new String[3];
		modifiers[0] = ""; modifiers[1] = "NOT NULL"; modifiers[2] = "";
		
		testDB.createTable("Test_table", names, datatypes, modifiers);

	}

}
