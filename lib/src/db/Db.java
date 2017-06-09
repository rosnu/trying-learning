package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {

	protected Connection connection;
	protected Statement statement;
	protected ResultSet resultSet;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public Db() {
	}

	public Db(String driver, String dbUrl) {

		try {
			
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(dbUrl);
			statement = connection.createStatement();

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}


	public Db(DbConnection dbName) {

		this(dbName.driver, dbName.dbUrl);

	}

	public void setPar(String parName, String value) {

		String sql = "update PARAMETERS set VALUE='" + value + "' where PARNAME='" + parName + "'";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createPropertiesTable() {

		String sql1 = "CREATE TABLE \"PARAMETERS\" ("
				+ "PARNAME varchar(50),"
				+ "VALUE varchar(500),"
				+ "STATUS varchar(50),"
				+ "COMMENT varchar(50),"
				+ "CONTEXT varchar(50) DEFAULT '',"
				+ "IDX bigint PRIMARY KEY NOT NULL"
				+ ")";
		String sql2 = "CREATE UNIQUE INDEX SQL170225002957070 ON \"PARAMETERS\"(IDX)";

		try {
			statement.execute(sql1);
			statement.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getPar(String name) {
		String out = null;
		String sSql = "select VALUE from PARAMETERS where PARNAME='" + name + "' and STATUS='ok' ";
		try {
			resultSet = statement.executeQuery(sSql);
			// resultSet.first();
			// System.out.println(rs.);
			resultSet.next();
			String sValue = (resultSet.getString("VALUE"));
			out = sValue;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void test(DbConnection connPar) {

		Db db = null;
		// db = new Db(connPar);
		db = new Db(connPar.driver, connPar.dbUrl);

		try {
			if (!db.connection.isClosed()) {
				System.out.println("ok!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();

	}

	public static void main(String[] args) {

		Db db = null;
		db = new Db(DbConnection.docCat);
		db.createPropertiesTable();

		// test(ConnPar.vidanaEmb);
		// test(DbConnection.docCat);

	}
}


