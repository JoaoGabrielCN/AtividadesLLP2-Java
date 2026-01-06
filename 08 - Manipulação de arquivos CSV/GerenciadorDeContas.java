import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class GerenciadorDeContas {
    private ArrayList<Conta> contas = new ArrayList<>();
    public void carregaDados(String path) throws Exception {

        FileReader fr = new FileReader(path);
        BufferedReader in = new BufferedReader(fr);
        String linha;
        while ((linha = in.readLine()) != null) {
            String[] texts = linha.split(",", -1);

            if (!texts[0].equals("id")) {
                if (texts[3].equals("") && texts[4].equals("")) {
                    contas.add(new Conta(texts));
                } else if (texts[4].equals("")) {
                    contas.add(new ContaEspecial(texts));
                } else if (texts[3].equals("")) {
                    contas.add(new ContaPoupanca(texts));

                }

            }

            

        }
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    
}