import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class PessoaDAOImpl implements iPessoaDAO {

    ArrayList<Pessoa> pessoas;
    String path;

    public PessoaDAOImpl(){
        pessoas = new ArrayList<>();
        path = "tabela.csv";
        
        carregaDados();
    }

    private void carregaDados(){
        
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
			String linha;
			br.readLine(); 
			while ((linha = br.readLine()) != null) {
				String[] texts = linha.split(";", -1);
                pessoas.add(new Pessoa(Integer.parseInt(texts[0]) , texts[1] , texts[2] , texts[3], texts[4], texts[5], texts[6]));
                
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    @Override
    public Pessoa getPessoa(int i) {
       return pessoas.get(i);
    }

    @Override
    public ArrayList<Pessoa> getAllPessoas() {
        return pessoas;
    }

    @Override
    public void atualizaPessoas(Pessoa p) {
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getMatricula() == p.getMatricula()){
                pessoa.setDados(p);
                break;
            }
        }
    }

    @Override
    public void deletaPessoa(Pessoa p) {
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getMatricula() == p.getMatricula()){
                pessoas.remove(pessoa);
                break;
            }
        }
    }

    @Override
    public void salvarPessoas() {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
			bw.write("matr�cula;nome;email;senha;cargo;turma;setor\n");
			for (Pessoa pessoa :  pessoas) {
				bw.write(pessoa.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
