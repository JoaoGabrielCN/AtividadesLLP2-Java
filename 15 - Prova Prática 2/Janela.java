import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {
    JLabel matriculaLabel;
    JTextField matriculaField;
    JLabel nomeLabel;
    JTextField nomeField;
    JLabel emailLabel;
    JTextField emailField;
    JLabel senhaLabel;
    JTextField senhaField;
    JLabel cargoLabel;
    JTextField cargoField;
    JLabel turmaLabel;
    JTextField turmaField;
    JLabel setorLabel;
    JTextField setorField;

    JButton nextButton, backButton;

    DataBaseManager dbManager;

    int index, size;

    public Janela() throws Exception {
        

        dbManager = new DataBaseManager();
        dbManager.setConnection("root", "");
        dbManager.executeQuery("SELECT * from pessoal ");

        dbManager.saveData("data.txt");
        int size = dbManager.buscaDadosBD().size();

        this.setLayout(new GridLayout(14, 1, 5, 10));

        setComponentsTexts();

        TextFieldHandler handler = new TextFieldHandler();

        nextButton = new JButton("Proximo");
        backButton = new JButton("Voltar");

        nextButton.addActionListener(handler);
        backButton.addActionListener(handler);
        addTexts();
        addButtons();

        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setComponentsTexts() {
        matriculaLabel = new JLabel("Matricula");
        matriculaField = new JTextField("" + dbManager.buscaDadosBD().get(index).getMatricula());
        nomeLabel = new JLabel("Nome: ");
        nomeField = new JTextField(dbManager.buscaDadosBD().get(index).getNome());
        emailLabel = new JLabel("Email: ");
        emailField = new JTextField(dbManager.buscaDadosBD().get(index).getEmail());
        senhaLabel = new JLabel("Senha: ");
        senhaField = new JTextField(dbManager.buscaDadosBD().get(index).getSenha());
        cargoLabel = new JLabel("Cargo: ");
        cargoField = new JTextField(dbManager.buscaDadosBD().get(index).getCargo());
        turmaLabel = new JLabel("Turma: ");
        turmaField = new JTextField(dbManager.buscaDadosBD().get(index).getTurma());
        setorLabel = new JLabel("Setor: ");
        setorField = new JTextField(dbManager.buscaDadosBD().get(index).getSetor());
    }

    public void addTexts() {
        this.add(matriculaLabel);
        this.add(matriculaField);
        this.add(nomeLabel);
        this.add(nomeField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(senhaLabel);
        this.add(senhaField);
        this.add(cargoLabel);
        this.add(cargoField);
        this.add(turmaLabel);
        this.add(turmaField);
        this.add(setorLabel);
        this.add(setorField);

    }

    public void removeComponents() {
        this.remove(matriculaLabel);
        this.remove(matriculaField);
        this.remove(nomeLabel);
        this.remove(nomeField);
        this.remove(emailLabel);
        this.remove(emailField);
        this.remove(senhaLabel);
        this.remove(senhaField);
        this.remove(cargoLabel);
        this.remove(cargoField);
        this.remove(turmaLabel);
        this.remove(turmaField);
        this.remove(setorLabel);
        this.remove(setorField);
        this.remove(nextButton);
        this.remove(backButton);

    }

    public void addButtons() {
        if (index > 0)
            this.add(backButton);
        if (index < 98)
            this.add(nextButton);
    }

    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == nextButton) {
                removeComponents();
                index++;
                System.out.println(index);
                setComponentsTexts();
                addTexts();
                addButtons();
                revalidate();
                repaint();

            }

            if (event.getSource() == backButton) {
                removeComponents();
                index--;
                System.out.println(index);
                setComponentsTexts();
                addTexts();
                addButtons();
                revalidate();
                repaint();

            }
        }
    }
}
