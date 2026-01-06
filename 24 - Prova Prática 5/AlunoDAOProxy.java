public class AlunoDAOProxy implements iAlunoDAO {


    @Override
    public boolean atualizarDados(int id, float n1, float n2, float n3) {
        if(AlunoDAO.getInstance().atualizarDados(id, n1, n2, n3)){
            return true;
        }
        return false;
    }


    @Override
    public void mostraDados() {
       AlunoDAO.getInstance().mostraDados();
    }
    
}
