import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        ArrayList<Conta> contas = new ArrayList<Conta>();

        System.out.println("LINHAS NAO CARREGADAS: ");
       
        try {
            contas = carregaDados("contas.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nO NUMERO TOTAL DE CONTAS CARREGADAS EH: " + contas.size());
            System.out.println("Memória usada (bytes): " + (runtime.totalMemory() - runtime.freeMemory()));
        }
    }

    static ArrayList<Conta> carregaDados(String path) throws IOException {
        ArrayList<Conta> contas = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader in = new BufferedReader(fr);
        String line;
        in.readLine();

        while ((line = in.readLine()) != null) {
            try {
                contas.add(criaConta(line));
            } catch (LinhaIncorreta e) {
                System.out.println(e);
            }

        }
        in.close();
        return contas;
    }

    static Conta criaConta(String line) throws LinhaIncorreta {
        try {
            String[] texts = line.trim().split(",", -1);
            return new Conta(texts);
        } catch (Exception e) {
            throw new LinhaIncorreta(line);
        }
    }
}