import javax.swing.JFrame;

public class Main {


    
    public static void main(String[] args) { new Main();   }
    
    public Main() {        
        Janela janela;
        janela = new Janela();


        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true); 
        
    }   

    /**
     * Deve buscar dos dados de uma pessoa a partir da matrícula
     * na base de dados.
     * @param matricula Matrícula da pessoa a ser buscada.
     * @return Objeto Pessoal com os dados da pessoa.
     */
 
}