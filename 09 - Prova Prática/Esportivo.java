public class Esportivo extends Movel {
    private int cilindradas, numPassageiros;

    public Esportivo(int numeroRodas,String fabricante, int anoFabricacao, int velocidade, int cilindradas, int numPassageiros) {
        super(numeroRodas, fabricante, anoFabricacao, velocidade);
        this.cilindradas = cilindradas;
        this.numPassageiros = numPassageiros;

        if(this.cilindradas <= 0){
            System.out.println("Clindradas invalidas!");
            this.cilindradas = 0;
        }   

        if(this.numPassageiros <= 0 || this.numPassageiros > 4){
            System.out.println("Numero de pasageiros invalido! (so eh permitido de 1 a 4 passageiros)");
            this.numPassageiros = 0;
        }   
    }

    public Esportivo(String[] texts){
        super(texts);
        this.cilindradas = Integer.parseInt(texts[4]);
        this.numPassageiros = Integer.parseInt(texts[5]);
    }

    @Override
    public String toString() {
        return super.toString() + ", cilindradas: " + cilindradas + ", numPassageiros: " + numPassageiros;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        if(cilindradas <= 0){
            System.out.println("Cilindradas invalidas!");
        }else{
            this.cilindradas = cilindradas;
        } 
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        if(numPassageiros <= 0 || numPassageiros > 4){
            System.out.println("Numero de passageiros invalido! (so eh permitido de 1 a 4 passageiros)");
        }else{
            this.numPassageiros = numPassageiros;
        } 
    }

    
    
}
