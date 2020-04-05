import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUICreatePassword extends JFrame {

    private JLabel label;
    private JTextField descriptionOfPassword;
    private JButton generatePassword;


    public GUICreatePassword(String titel){
    setTitle(titel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    GridLayout mainLayout = new GridLayout(5,1);
        mainLayout.setVgap(5);

    JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,60,60,60));
        panel.setLayout(mainLayout);
        panel.setBackground(Color.PINK);

    add(panel,BorderLayout.CENTER);

    initComponents();
    addComponentsToPanel(panel);

    setColorOfButtons();

    setLocationRelativeTo(null);
    setVisible(true);
    pack();
    setResizable(false);

}


    private void addComponentsToPanel(JPanel panel)
    {
        panel.add(label);
        panel.add(descriptionOfPassword);
        panel.add(generatePassword);


    }

    private void setColorOfButtons()
    {

    }


    private void initComponents() {

        generatePassword = new JButton("Generate a password");
        label = new JLabel("Type in a title for the new password:");
        descriptionOfPassword = new JTextField();

        generatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(descriptionOfPassword.getText().length()>15)
                {
                    JOptionPane.showMessageDialog(GUICreatePassword.this, "The title is too big!");
                }
                else {
                    String password = PasswordGenerator.generate(20);
                    try {
                        FileCreater.createTextFile(descriptionOfPassword.getText(),password);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    dispose();
                    JOptionPane.showMessageDialog(GUICreatePassword.this, "The password is: " + password);
                    SecondPage.constructCreateOrSeeGUI();
                }
            }
        });

    }
}
