import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdatePanel extends JPanel {
    JLabel numLabel;
    JTextField numInput;
    JLabel matriculaLabel;
    JTextField matriculaInput;
    JLabel nomeLabel;
    JTextField nomeInput;
    JButton insertButton;
    JButton cleanButton;
    JLabel result;
    JButton editButton;

    public UpdatePanel() {

        this.setLayout(new GridLayout(9, 2, 10, 10));

        matriculaLabel = new JLabel("Insira matricula do registro que deseja editar: ");
        matriculaInput = new JTextField("", 10);

        insertButton = new JButton("Inserir");
        cleanButton = new JButton("Limpar");

        numLabel = new JLabel("Editar Numero: ");
        numInput = new JTextField("", 10);

        nomeLabel = new JLabel("Editar Nome: ");
        nomeInput = new JTextField("", 10);

        editButton = new JButton("Editar registro");

        TextFieldHandler handler = new TextFieldHandler();

        insertButton.addActionListener(handler);
        editButton.addActionListener(handler);

        this.add(matriculaLabel);
        this.add(matriculaInput);
        this.add(insertButton);
        this.add(cleanButton);

    }

    void addButtons() {
        this.add(numLabel);
        this.add(numInput);
        this.add(nomeLabel);
        this.add(nomeInput);
        this.add(editButton);
    }

    void addResult() {
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

                        if (texts[1].equals(matriculaInput.getText())) {
                            addButtons();
                            revalidate();
                            repaint();

                        } 
                    }

                    fr.close();

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                

            }

            if (event.getSource() == editButton) {
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
                        if (texts[1].equals(matriculaInput.getText())) {
                            out.println(numInput.getText() + "," + texts[1] + "," + nomeInput.getText());

                        } else {
                            out.println(line);
                        }

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