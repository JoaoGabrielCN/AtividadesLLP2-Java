public class Software extends Gravacao {
    public int versao; 
    public String plataforma;
    
    public Software(int numeroCopias, int numeroCatalogo, String titulo, String midia, int versao, String plataforma) {
        
        super(numeroCopias, numeroCatalogo, titulo, midia);
        this.versao = versao;
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return super.toString() + ", versao: " + versao + ", plataforma: " + plataforma;
    }

    

    
}
