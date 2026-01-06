import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws Exception {
        GerenciadorDeContas g = new GerenciadorDeContas();

        g.carregaDados("assets/contas.csv");
        
        for (Conta conta : g.getContas()) {
            System.out.println(conta.toString());
        }
    }
}



