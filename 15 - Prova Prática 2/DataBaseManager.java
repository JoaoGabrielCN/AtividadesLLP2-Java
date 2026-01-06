
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseManager {

	Connection con;
	ResultSet rs;
	ResultSetMetaData rsmd;
	StringBuilder data;
	

	public void setConnection(String user, String password) throws SQLException {

		String nomeJDBC = "jdbc:mysql://127.0.0.1:3306/bd_pessoal?user=root?useTimezone=true&serverTimezone=UTC";

		con = DriverManager.getConnection(nomeJDBC, user, password);

		data = new StringBuilder();

	}

	public ArrayList<Pessoal> buscaDadosBD() {
		ArrayList<Pessoal> lista = new ArrayList<>();
		
			
		
		try {
			rs.first();
			while (rs.next()) {
				lista.add(new Pessoal(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));

			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;

	}

	private void saveQuery() throws SQLException {
		rs.first();
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
