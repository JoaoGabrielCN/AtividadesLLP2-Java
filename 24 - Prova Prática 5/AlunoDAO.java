import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class AlunoDAO implements iAlunoDAO {
    private Connection con;
    private String nomeJDBC;
    private String nomeUser;
    private String password;
    private ArrayList<Aluno> lista;
    private ArrayList<Float> listaMedias;

    private static AlunoDAO instance;

    private AlunoDAO() {
        nomeJDBC = "jdbc:mysql://localhost/escola";
        nomeUser = "root";
        password = "";

        lista = new ArrayList<Aluno>();
        listaMedias = new ArrayList<Float>();

        carregaDados();
    }

    static public AlunoDAO getInstance(){
        if(instance == null){
            instance = new AlunoDAO();
        }

        return instance;
    }
    public void carregaDados() {

        try {
            con = DriverManager.getConnection(nomeJDBC, nomeUser, password);
            Statement st = con.createStatement();
            st.executeUpdate("USE " + "escola");
            ResultSet rs = st.executeQuery("select * From notas;");
            while (rs.next()) {
                Aluno pessoa = new Aluno(rs.getInt("id"), rs.getString("email"), rs.getFloat("nota1"),
                        rs.getFloat("nota2"), rs.getFloat("nota3"));
                lista.add(pessoa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        carregaMedias();

    }

    @Override
    public boolean atualizarDados(int id, float n1, float n2, float n3) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.get(i).setNota1(n1);
                lista.get(i).setNota2(n2);
                lista.get(i).setNota3(n3);

                carregaMedias();
                salvarDados(new Aluno(id, null, n1, n2, n3));

                return true;

            }
        }

        return false;

    }

    public void salvarDados(Aluno p) {

        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE `notas` SET `nota1`=" + p.getNota1() + ",`nota2`=" + p.getNota2() + ",`nota3`="
                    + p.getNota3() + "WHERE id = " + p.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void carregaMedias() {
        listaMedias.clear();
        for (Aluno aluno : lista) {
            listaMedias.add((aluno.getNota1() + aluno.getNota2() + aluno.getNota3()) / 3);
        }
    }

    @Override
    public void mostraDados() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i) + " MEDIA: " + listaMedias.get(i));
        }
    }
}
