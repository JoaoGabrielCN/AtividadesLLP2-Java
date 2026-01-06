import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class ConvertorDeTemperatura {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setVisible(true);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Frame extends JFrame {
    private JLabel label, result;
    private JTextField input;
    private JButton button;

    public Frame() {
        super("Convertor de Temperatura");
        setLayout(new FlowLayout());

        label = new JLabel("Celsius");
        input = new JTextField("0", 10);
        result = new JLabel(fahreinheit(0.0) + " Fahreinheit");
        button = new JButton("Convert");

        TextFieldHandler handler = new TextFieldHandler();

        button.addActionListener(handler);
        input.addActionListener(handler);
        add(input);
        add(label);
        add(button);
        add(result);

    }

    Double fahreinheit(Double f) {
        return (f * 1.8) + 32;
    }

    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == button) {
                result.setText(fahreinheit(Double.parseDouble(input.getText())) + " Fahreinheit");
            }
        }
    }

}