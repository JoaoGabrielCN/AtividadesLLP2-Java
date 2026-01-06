import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrudMenu extends JFrame {
    JButton createButton;
    JButton readButton;
    JButton updateButton;
    JButton deleteButton;

    public CrudMenu() {

        this.setLayout(new FlowLayout());

        createButton = new JButton("CREATE");
        readButton = new JButton("READ");
        updateButton = new JButton("UPDATE");
        deleteButton = new JButton("DELETE");

        TextFieldHandler handler = new TextFieldHandler();
        createButton.addActionListener(handler);
        readButton.addActionListener(handler);
        deleteButton.addActionListener(handler);
        updateButton.addActionListener(handler);
        this.add(createButton);
        this.add(readButton);
        this.add(updateButton);
        this.add(deleteButton);

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CrudMenu();
    }

    class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == createButton) {

                getContentPane().removeAll();

                CreatePanel createPanel = new CreatePanel();
                add(createPanel);
                revalidate();
                repaint();
            }
            if (event.getSource() == readButton) {

                getContentPane().removeAll();

                ReadPanel readPanel = new ReadPanel();
                add(readPanel);
                revalidate();
                repaint();
            }
            if (event.getSource() == deleteButton) {
                getContentPane().removeAll();

                DeletePanel deletePanel = new DeletePanel();
                add(deletePanel);
                revalidate();
                repaint();
            }
            if(event.getSource() == updateButton){
                getContentPane().removeAll();

                UpdatePanel updatePanel = new UpdatePanel();
                add(updatePanel);
                revalidate();
                repaint();
            }
        }
    }
}
