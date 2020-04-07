import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIStartPage extends JFrame {

    private final String masterPassword ="test";
    private JLabel label;
    private JTextField eingabe;
    private JButton button;


    public GUIStartPage(String titel) {

        setTitle(titel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(3,1);
        mainLayout.setVgap(10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,100,60,100));
        panel.setLayout(mainLayout);
        panel.setBackground(Color.BLACK);

        add(panel,BorderLayout.CENTER);

        initComponents();
        addComponentsToPanel(panel);

        setColorOfComponents();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }


    private void addComponentsToPanel(JPanel panel)
    {
        panel.add(label);
        panel.add(eingabe);
        panel.add(button);

    }

    private void setColorOfComponents()
    {
        label.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        eingabe.setBackground(Color.BLACK);
        eingabe.setForeground(Color.WHITE);
        eingabe.setCaretColor(Color.WHITE);
        label.setFont(label.getFont().deriveFont(32.0f));
        button.setFont(button.getFont().deriveFont(32.0f));
        eingabe.setFont(eingabe.getFont().deriveFont(32.0f));
    }


    private void initComponents() {

        eingabe = new JTextField(20);
        label = new JLabel("Enter the master password:");
        button = new JButton("Enter");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nutzerEingabe = eingabe.getText();
                if(nutzerEingabe.equals(masterPassword))
                {
                    SecondPage.buildSecondPageGUI();
                    dispose();
                }
                else
                { JOptionPane.showMessageDialog(GUIStartPage.this,"Wrong master password!");
                }
            }
        });

}
}