import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TabelaGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private int index = 0;

	private JTextField matriculaField;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField senhaField;
	private JTextField cargoField;
	private JTextField turmaField;
	private JTextField setorField;

	private iPessoaDAO dados;

	public TabelaGUI() {
		// Configura��o inicial da janela
		setTitle("Tabela");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Carregar dados do arquivo
		dados = new PessoaDAOImpl();

		

		// Configurar layout
		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(new JLabel("Matr�cula:"));
		matriculaField = new JTextField(50);
		add(matriculaField);

		add(new JLabel("Nome:"));
		nomeField = new JTextField(50);
		add(nomeField);

		add(new JLabel("Email:"));
		emailField = new JTextField(50);
		add(emailField);

		add(new JLabel("Senha:"));
		senhaField = new JTextField(50);
		add(senhaField);

		add(new JLabel("Cargo:"));
		cargoField = new JTextField(50);
		add(cargoField);

		add(new JLabel("Turma:"));
		turmaField = new JTextField(50);
		add(turmaField);

		add(new JLabel("Setor:"));
		setorField = new JTextField(50);
		add(setorField);

		JButton prevButton = new JButton("Anterior");
		prevButton.addActionListener(e -> mostrarAnterior());
		add(prevButton);

		JButton nextButton = new JButton("Pr�ximo");
		nextButton.addActionListener(e -> mostrarProximo());
		add(nextButton);

		JButton updateButton = new JButton("Atualizar");
		updateButton.addActionListener(e -> dados.atualizaPessoas(new Pessoa(Integer.parseInt(matriculaField.getText()),  nomeField.getText(),  emailField.getText(),  senhaField.getText(),  cargoField.getText(),  turmaField.getText(),  setorField.getText())));
		add(updateButton);

		JButton deleteButton = new JButton("Deletar");
		deleteButton.addActionListener(e -> dados.deletaPessoa(dados.getPessoa(index)));
		add(deleteButton);

		JButton saveButton = new JButton("Salvar");
		saveButton.addActionListener(e -> dados.salvarPessoas());
		add(saveButton);

		mostrarDado();
	}



	private void mostrarDado() {
		if (!dados.getAllPessoas().isEmpty() && index < dados.getAllPessoas().size() && index >= 0) {
			Pessoa dado = dados.getPessoa(index);
			matriculaField.setText(dado.getMatricula() + "");
			nomeField.setText(dado.getNome());
			emailField.setText(dado.getEmail());
			senhaField.setText(dado.getSenha());
			cargoField.setText(dado.getCargo());
			turmaField.setText(dado.getTurma());
			setorField.setText(dado.getSetor());
		}
	}

	private void mostrarAnterior() {
		if (index > 0) {
			index--;
			mostrarDado();
		}
	}

	private void mostrarProximo() {
		if (index < dados.getAllPessoas().size() - 1) {
			index++;
			mostrarDado();
		}
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new TabelaGUI().setVisible(true);
		});
	}
}
