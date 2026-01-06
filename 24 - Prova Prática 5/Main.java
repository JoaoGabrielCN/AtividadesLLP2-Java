import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        iAlunoDAO dao = new AlunoDAOProxy();

        dao.mostraDados();

        
        String idString = JOptionPane.showInputDialog(null, "Insira o id do aluno que deseja atualizar:", "Inserção de id", JOptionPane.QUESTION_MESSAGE);
        int id = Integer.parseInt(idString);

        String n1String = JOptionPane.showInputDialog(null, "Insira o n1 do aluno que deseja atualizar:", "Inserção de n1", JOptionPane.QUESTION_MESSAGE);
        Float n1 = Float.parseFloat(n1String);

        String n2String = JOptionPane.showInputDialog(null, "Insira o n2 do aluno que deseja atualizar:", "Inserção de n2", JOptionPane.QUESTION_MESSAGE);
        Float n2 = Float.parseFloat(n2String);

        String n3String = JOptionPane.showInputDialog(null, "Insira o n3 do aluno que deseja atualizar:", "Inserção de n3", JOptionPane.QUESTION_MESSAGE);
        Float n3 = Float.parseFloat(n3String);


        if (dao.atualizarDados(id, n1, n2, n3)) {
            System.out.println("Aluno atualizado com sucess2o!\n\n");
        } else {
            System.out.println("NÃO FOI POSSIVEL ATUALIZAR COM SUCESSO\n");
        }

        dao.mostraDados();

    }
}