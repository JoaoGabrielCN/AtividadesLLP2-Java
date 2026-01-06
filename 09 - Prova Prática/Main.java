public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("QUESTAO 1:");
        Movel movel = new Movel(2,"Yamaha", 2008, 145);
        System.out.println(movel);
 
        System.out.println("\nQUESTAO 2:");

        GerenciadorDeMoveis gMoveis = new GerenciadorDeMoveis();
        gMoveis.carregaDados("moveis.txt");
        
        for (Movel movel2021 : gMoveis.fabricadosPos2021()) {
            System.out.println(movel2021);
        }
     }
}
