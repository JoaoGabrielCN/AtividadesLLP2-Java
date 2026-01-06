public class Carga  extends Movel{
    private int volumeMaximo, pesoMaximo;

    public Carga(int numeroRodas, String fabricante, int anoFabricacao,  int velocidade, int volumeMaximo,
            int pesoMaximo) {
        super(numeroRodas, fabricante, anoFabricacao, velocidade);
        this.volumeMaximo = volumeMaximo;
        this.pesoMaximo = pesoMaximo;

        if(this.volumeMaximo <= 0){
            System.out.println("Volume maximo invalido!");
            this.volumeMaximo = 0;
        }   

        if(this.pesoMaximo <= 0){
            System.out.println("Peso maximo invalido!");
            this.pesoMaximo = 0;
        }   
    }

    public Carga(String[] texts){
        super(texts);
        this.volumeMaximo = Integer.parseInt(texts[6]);
        this.pesoMaximo = Integer.parseInt(texts[7]);
    }

    @Override
    public String toString() {
        return super.toString() +", volumeMaximo: " + volumeMaximo + ", pesoMaximo: " + pesoMaximo;
    }

    public int getVolumeMaximo() {
        return volumeMaximo;
    }

    public void setVolumeMaximo(int volumeMaximo) {
        if(volumeMaximo <= 0){
            System.out.println("Volumo maximo invalido!");
            
        }else{
            this.volumeMaximo = volumeMaximo;
        } 
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        if(pesoMaximo <= 0){
            System.out.println("Peso maximo invalido!");
            
        }else{
            this.pesoMaximo = pesoMaximo;
        } 
    }
    
    
}
