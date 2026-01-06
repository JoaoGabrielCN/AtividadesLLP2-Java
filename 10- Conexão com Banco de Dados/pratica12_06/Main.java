package pratica12_06;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws Exception {

		DataBaseManager dbManager = new DataBaseManager();

		String query = "SELECT m.Titulo, a.Nome FROM musica m "
				+ "JOIN faixa f ON m.CodMus = f.CodMus "
				+ "JOIN disco d ON f.CodDisco = d.CodDisco "
				+ "JOIN artista a ON d.CodArt = a.CodArt;";

		dbManager.setConnection("root", "");
		dbManager.executeQuery(query);
		dbManager.printData();
		dbManager.saveData("data.txt");
		dbManager.closeConnection();

	}
}
