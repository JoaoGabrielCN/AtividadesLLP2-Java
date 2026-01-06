package pratica12_06;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {

	Connection con;
	ResultSet rs;
	ResultSetMetaData rsmd;
	StringBuilder data;

	public void setConnection(String user, String password) throws SQLException {

		String nomeJDBC = "jdbc:mysql://localhost:3306/discdb?useTimezone=true&serverTimezone=UTC";

		con = DriverManager.getConnection(nomeJDBC, user, password);

		data = new StringBuilder();

	}

	private void saveQuery() throws SQLException {
		while (rs.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				data.append(rsmd.getColumnLabel(i) + ": " + rs.getString(i) + "  ");
			}

			data.append("\n");

		}
	}

	public void executeQuery(String query) throws SQLException {
		Statement st = con.createStatement();
		rs = st.executeQuery(query);
		rsmd = rs.getMetaData();
		saveQuery();
	}

	public void printData() throws SQLException {

		System.out.println(data.toString());
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	public void saveData(String path) throws Exception {
		FileWriter fw = new FileWriter(path);
		PrintWriter out = new PrintWriter(fw);

		out.write(data.toString());

		out.close();

	}
}
