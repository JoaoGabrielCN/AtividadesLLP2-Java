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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class DeletePanel extends JPanel {
    JLabel numLabel;
    JTextField numInput;
    JLabel matriculaLabel;
    JTextField matriculaInput;
    JLabel nomeLabel;
    JTextField nomeInput;
    JButton deleteButton;
    JButton cleanButton;
    JLabel result;

    public DeletePanel() {

        this.setLayout(new GridLayout(5, 2, 10, 10));

        nomeLabel = new JLabel("Nome: ");
        nomeInput = new JTextField("", 10);

        deleteButton = new JButton("Deletar");
        cleanButton = new JButton("Limpar");
        result = new JLabel("");

        TextFieldHandler handler = new TextFieldHandler();

        deleteButton.addActionListener(handler);

        this.add(nomeLabel);
        this.add(nomeInput);
        this.add(deleteButton);
        this.add(cleanButton);
        this.add(result);

    }

    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            boolean found = false;
            if (event.getSource() == deleteButton) {

                FileReader fr;
                File file = new File("dados.csv");
                File newFile = new File("tempDados.csv");

                try {
                    fr = new FileReader(file);
                    BufferedReader in = new BufferedReader(fr);
                    PrintWriter out = new PrintWriter(new FileWriter(newFile));
                    String line;
                    in.readLine();
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                        String[] texts = line.trim().split(",");
                        if (!texts[2].equals(nomeInput.getText())) {
                            out.println(line);

                        } else {
                            found = true;
                        }

                    }

                    if (found) {
                        result.setText("REGISTRO FOI DELETADO");
                    } else {
                        result.setText("REGISTRO NAO FOI ECNONTRADO");
                    }
                    out.close();
                    in.close();

                    file.delete();
                    newFile.renameTo(file);

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
