public class Movel {
    protected int numeroRodas, anoFabricacao;
    protected String fabricante;
    private int velocidade;

    @Override
    public String toString() {
        return "numeroRodas: " + numeroRodas + ", fabricante: " + fabricante + ", anoFabricacao: " + anoFabricacao  
                + ", velocidade: " + velocidade;
    }

    public Movel(int numeroRodas, String fabricante , int anoFabricacao, int velocidade) {
        this.numeroRodas = numeroRodas;
        this.anoFabricacao = anoFabricacao;
        this.fabricante = fabricante;
        this.velocidade = velocidade;
        
        if(this.numeroRodas <= 0){
            System.out.println("Numero de rodas invalido!");
            this.numeroRodas = 0;
        }   

        if(this.anoFabricacao <= 0){
            System.out.println("Ano de fabricaçao invalido!");
            this.anoFabricacao = 0;
        }   

        if(this.velocidade <= 0){
            System.out.println("Velcidade invalida!");
            this.velocidade = 0;
        }  
        
        if(this.fabricante.equals(null) || this.fabricante.equals(" ") || this.fabricante.equals("")){
            System.out.println("Fabricante invaido!");
            this.fabricante = " ";
        }
         
    }

    public Movel(String[] texts){
        this(Integer.parseInt(texts[0]), texts[1], Integer.parseInt(texts[2]), Integer.parseInt(texts[3]));
    }    

    public int getNumeroRodas() {
        return numeroRodas;
    }

    public void setNumeroRodas(int numeroRodas) {
        
        if(numeroRodas <= 0){
            System.out.println("Numero de rodas invalido!");
            
        }else{
            this.numeroRodas = numeroRodas;
        } 
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        if(anoFabricacao <= 0){
            System.out.println("Ano de fabricacao invalido!");
            
        }else{
            this.anoFabricacao = anoFabricacao;
        } 
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        if(fabricante.equals(null) || fabricante.equals(" ") || fabricante.equals("")){
            System.out.println("Fabricante invaido!");
            
        }else{
            this.fabricante = fabricante;
        }
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        if(velocidade <= 0){
            System.out.println("Velocidade invalida!");
            
        }else{
            this.velocidade = velocidade;
        } 
    }


}
