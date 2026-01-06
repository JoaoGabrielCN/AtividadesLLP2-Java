import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao1 {

    public static void main(String[] args) throws Exception{
      String word;
            int cont = 1;
            ArrayList<Integer> pos = new ArrayList<>();
            File file = new File(args[0]);

            Scanner scanner = new Scanner(file);
            System.out.println("Insira a palavra a ser procurada: ");
            Scanner input = new Scanner(System.in);

            word = input.nextLine();

            while (scanner.hasNext()) {
                Scanner linha = new Scanner(scanner.nextLine());

                while (linha.hasNext()) {
                    if (linha.next().equals(word)) {
                        pos.add(cont);
 
                    }
                }

                linha.close();

                cont++;

            }

            scanner.close();

            System.out.println("A palavra " + word + " aparece nas linhas " + pos.toString());
    }
}