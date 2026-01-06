    import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
    import java.util.Scanner;

    public class Questao2 {

        public static void main(String[] args) throws Exception {
            String  linha;
            File file = new File(args[0]);  
            Scanner input = new Scanner(System.in);
            File newFile = new File("temp" + file.getName());
            PrintWriter out = new PrintWriter(new FileWriter(newFile));

            BufferedReader buffer = new BufferedReader(new FileReader(file));

            System.out.println("Insira uma palavra a ser pesquisada: ");
            String search = input.nextLine();
            System.out.println("Inspsira uma palavra a ser substituida: ");
            String changed = input.nextLine();

            while ((linha = buffer.readLine()) != null) {
                Scanner line = new Scanner(linha);
                
                while (line.hasNext()) {
                    String tempWord = line.next();
                    if(tempWord.equals(search)){
                        out.write(changed+ " ");
                    }else{
                    out.write(tempWord + " ");
                    }
                    
                }
               
                out.write("\n");
                
                line.close();
            }

            buffer.close();
            out.close();
            file.delete();
            newFile.renameTo(file);

            
        }
        }

       

    
           
    