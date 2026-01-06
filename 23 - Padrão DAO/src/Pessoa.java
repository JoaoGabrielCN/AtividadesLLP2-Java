public class Pessoa {

    private int matricula;
    private String cargo, nome, senha, email, turma, setor;
    public int getMatricula() {
        return matricula;
    }
    public Pessoa(int matricula,  String nome, String email, String senha, String cargo, String turma, String setor ) {
        this.matricula = matricula;
        this.cargo = cargo;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.turma = turma;
        this.setor = setor;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    
   public String toString(){
     return matricula + ";" + nome + ";" + email + ";" + senha + ";" + cargo + ";" + turma + ";" + setor;

   }

   public void setDados(Pessoa p){
        this.matricula = p.getMatricula();
        this.cargo = p.getCargo();
        this.nome = p.getNome();
        this.senha = p.getSenha();
        this.email = p.getEmail();
        this.turma = p.getTurma();
        this.setor = p.getSetor();
   }
 
    
}
