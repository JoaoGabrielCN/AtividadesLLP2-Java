import java.util.ArrayList;

public interface iPessoaDAO{
    public Pessoa getPessoa(int i);
    public ArrayList<Pessoa> getAllPessoas();
    public void atualizaPessoas(Pessoa p);
    public void deletaPessoa(Pessoa p);
    public void salvarPessoas();


}