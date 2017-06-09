package db;

public class DbConnection {
	public String driver = null;
	public String dbUrl = null;
	
	public DbConnection() {}


	public DbConnection(String driver, String conn) {
		this.driver = driver;
		this.dbUrl = conn;
	}

	public static db.DbConnection docCat = new db.DbConnection("org.apache.derby.jdbc.ClientDriver",
			"jdbc:derby://localhost:1527/docCat;create=true;user=docCat;password=docCat");

}
