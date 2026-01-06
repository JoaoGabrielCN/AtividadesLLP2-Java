import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ReadPanel extends JPanel {
    JLabel numLabel;
    JTextField numInput;
    JLabel matriculaLabel;
    JTextField matriculaInput;
    JLabel nomeLabel;
    JTextField nomeInput;
    JButton insertButton;
    JButton cleanButton;
    JLabel result;

    public ReadPanel() {

        this.setLayout(new GridLayout(5, 2, 10, 10));

        nomeLabel = new JLabel("Nome: ");
        nomeInput = new JTextField("", 10);

        insertButton = new JButton("Inserir");
        cleanButton = new JButton("Limpar");

        result = new JLabel("Nome: \n Matricula: \n Id: ");

        TextFieldHandler handler = new TextFieldHandler();

        insertButton.addActionListener(handler);

        this.add(nomeLabel);
        this.add(nomeInput);
        this.add(insertButton);
        this.add(cleanButton);
        this.add(result);

    }

    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            boolean found = false;
            if (event.getSource() == insertButton) {

                FileReader fr;
                try {
                    fr = new FileReader("dados.csv");
                    BufferedReader in = new BufferedReader(fr);

                    String line;
                    while ((line = in.readLine()) != null) {
                        String[] texts = line.split(",");

                        if (texts[2].equals(nomeInput.getText())) {
                            result.setText("Id: " + texts[0] + " Matricula: " + texts[1] + " Nome: " + texts[2]);
                            found = true;
                        }
                    }

                    if (!found) {
                        result.setText("REGISTRO NAO ENCONTRADO");
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }
}
