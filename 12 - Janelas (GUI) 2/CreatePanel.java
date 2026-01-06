import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePanel extends JPanel {
    JLabel numLabel;
    JTextField numInput;
    JLabel matriculaLabel;
    JTextField matriculaInput;
    JLabel nomeLabel;
    JTextField nomeInput;
    JButton insertButton;
    JButton cleanButton;
    JLabel resultText;

    public CreatePanel() {

        this.setLayout(new GridLayout(9, 2, 10, 10));

        numLabel = new JLabel("Num: ");
        numInput = new JTextField("", 10);

        matriculaLabel = new JLabel("Matricula: ");
        matriculaInput = new JTextField("", 10);

        nomeLabel = new JLabel("Nome: ");
        nomeInput = new JTextField("", 10);

        insertButton = new JButton("Inserir");
        cleanButton = new JButton("Limpar");

        resultText = new JLabel("");

        TextFieldHandler handler = new TextFieldHandler();

        insertButton.addActionListener(handler);
        cleanButton.addActionListener(handler);

        this.add(numLabel);
        this.add(numInput);
        this.add(matriculaLabel);
        this.add(matriculaInput);
        this.add(nomeLabel);
        this.add(nomeInput);
        this.add(insertButton);
        this.add(cleanButton);
        this.add(resultText);

    }

    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == insertButton) {
                FileWriter fw;
                try {
                    fw = new FileWriter("dados.csv", true);
                    PrintWriter out = new PrintWriter(fw);
                    out.println(numInput.getText() + "," + matriculaInput.getText() + "," + nomeInput.getText());
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            if (event.getSource() == cleanButton) {
                numInput.setText("");
                matriculaInput.setText("");
                nomeInput.setText("");

            }

        }
    }

}
