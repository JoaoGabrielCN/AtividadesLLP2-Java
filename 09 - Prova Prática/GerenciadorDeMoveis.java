import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GerenciadorDeMoveis {
    private ArrayList<Movel> moveis;

    GerenciadorDeMoveis(){
        moveis = new ArrayList<>();
    }

    public void carregaDados(String path) throws Exception{
        FileReader fr = new FileReader(path);
        BufferedReader in = new BufferedReader(fr);
        String line;
        in.readLine();
        while((line = in.readLine()) != null){
            String[] texts = line.trim().split(";", -1);
         
            
            if(!texts[0].equals("numRodas")){
               if(!texts[4].equals("") && !texts[5].equals("")){
                   moveis.add(new Esportivo(texts));
               }

               if(!texts[6].equals("") && !texts[7].equals("")){
                   moveis.add(new Carga(texts));
               }

               if(texts[4].equals("") && texts[5].equals("") && texts[6].equals("") && texts[7].equals("")){
                moveis.add(new Movel(texts));
               }
            }
        }

        in.close();
    }

    public void mostraDados(){
        for (Movel movel : moveis) {
            System.out.println(movel);
        }
    }

    public ArrayList<Movel> fabricadosPos2021(){
        ArrayList<Movel> pos2021 = new ArrayList<>();

        for (Movel movel : moveis) {
            if(movel.getAnoFabricacao() > 2021){
                pos2021.add(movel);
            }
            
        }

        return pos2021;
    }

  
}
