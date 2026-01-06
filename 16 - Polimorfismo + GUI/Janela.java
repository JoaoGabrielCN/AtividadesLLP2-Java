import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Janela extends JFrame {
    JTextField tituloInput, midiaInput, diretorInput, dataDeLancamentoInput, distribuidorInput, versaoInput,
            plataformaInput;
    JLabel tituloLabel, midiaLabel, diretorLabel, dataDeLancamentoLabel, distribuidorLabel, versaoLabel,
            plataformaLabel;
    JButton addButton, cleanButton;
    JRadioButton filmeRadioButton, softwareRadioButton;
    ButtonGroup tipoGroup;

    ArrayList <Gravacao> lista;

    JPanel mainPanel;

    public Janela() {
        mainPanel = new JPanel(new GridLayout(18, 2, 10, 10));

        RadioButtonHandler buttonHandler = new RadioButtonHandler();
        TextFieldHandler textHandler = new TextFieldHandler();

        lista = new ArrayList<>();

        tituloLabel = new JLabel("titulo: ");
        midiaLabel = new JLabel("midia: ");
        diretorLabel = new JLabel("diretor: ");
        dataDeLancamentoLabel = new JLabel("data de lancamento: ");
        distribuidorLabel = new JLabel("distribuidor: ");
        versaoLabel = new JLabel("versao: ");
        plataformaLabel = new JLabel("plataforma: ");

        tituloInput = new JTextField();
        midiaInput = new JTextField();
        diretorInput = new JTextField();
        dataDeLancamentoInput = new JTextField();
        distribuidorInput = new JTextField();
        versaoInput = new JTextField();
        plataformaInput = new JTextField();

        filmeRadioButton = new JRadioButton("Filme");
        softwareRadioButton = new JRadioButton("Software");

        filmeRadioButton.addItemListener(buttonHandler);
        softwareRadioButton.addItemListener(buttonHandler);

        

        tipoGroup = new ButtonGroup();
        tipoGroup.add(filmeRadioButton);
        tipoGroup.add(softwareRadioButton);

        addButton = new JButton("adicionar");
        cleanButton = new JButton("limpar");

        cleanButton.addActionListener(textHandler);
        addButton.addActionListener(textHandler);
        
        
        addMainComponents();
        addFilmeComponents();
        filmeRadioButton.setSelected(true);
        addMainButtons(); 

        this.add(mainPanel); 
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void addFilmeComponents() {
        mainPanel.add(diretorLabel);
        mainPanel.add(diretorInput);
        mainPanel.add(dataDeLancamentoLabel);
        mainPanel.add(dataDeLancamentoInput);
        mainPanel.add(distribuidorLabel);
        mainPanel.add(distribuidorInput);
    }

    void addSoftwareComponents() {
        mainPanel.add(versaoLabel);
        mainPanel.add(versaoInput);
        mainPanel.add(plataformaLabel);
        mainPanel.add(plataformaInput);
    }

    void addMainComponents() {
        mainPanel.removeAll();

        mainPanel.add(tituloLabel);
        mainPanel.add(tituloInput);
        mainPanel.add(midiaLabel);
        mainPanel.add(midiaInput);
        mainPanel.add(filmeRadioButton);
        mainPanel.add(softwareRadioButton);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    void addMainButtons(){
        
        mainPanel.add(addButton);
        mainPanel.add(cleanButton);
    }

    private class RadioButtonHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent event) {
         if(filmeRadioButton.isSelected()){
             addMainComponents();
             addFilmeComponents();
             addMainButtons();
             revalidate();
             repaint();
         }
         if(softwareRadioButton.isSelected()){
             addMainComponents();
             addSoftwareComponents();
             addMainButtons();
             revalidate();
             repaint();
         }

         
        }
        
       }

       private class TextFieldHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == cleanButton){
               
        tituloInput.setText("");
        midiaInput.setText("");
        diretorInput.setText("");
        dataDeLancamentoInput.setText("");
        distribuidorInput.setText("");
        versaoInput.setText("");
        plataformaInput.setText("");
            }

            if(e.getSource() == addButton){
                if(filmeRadioButton.isSelected()){

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date date;
                    try {
                        date = sdf.parse(dataDeLancamentoInput.getText());
                        lista.add(new Filme(0, 0, tituloInput.getText(), midiaInput.getText(), diretorInput.getText(), distribuidorInput.getText(), date));
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    
                }
                if(softwareRadioButton.isSelected()){
                    lista.add(new Software(0, 0, tituloInput.getText(), midiaInput.getText(), Integer.parseInt(versaoInput.getText()), plataformaInput.getText()));
                }
                for (Gravacao gravacao : lista) {
                    System.out.println(gravacao);
                }
            }
        }

       }
}
