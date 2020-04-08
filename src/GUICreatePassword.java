import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUICreatePassword extends JFrame {

    private JLabel label;
    private JTextField descriptionOfPassword;
    private JButton generatePassword;
    private JButton goBackButton;


    public GUICreatePassword(String titel){
    setTitle(titel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    GridLayout mainLayout = new GridLayout(5,1);
        mainLayout.setVgap(5);

    JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,60,60,60));
        panel.setLayout(mainLayout);
        panel.setBackground(Color.BLACK);

    add(panel,BorderLayout.CENTER);

    initComponents();
    addComponentsToPanel(panel);

    setColorOfButtons();

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);

}


    private void addComponentsToPanel(JPanel panel)
    {
        panel.add(label);
        panel.add(descriptionOfPassword);
        panel.add(generatePassword);
        panel.add(goBackButton);


    }

    private void setColorOfButtons()
    {
        label.setForeground(Color.WHITE);
        generatePassword.setForeground(Color.WHITE);
        generatePassword.setBackground(Color.BLACK);
        goBackButton.setBackground(Color.BLACK);
        goBackButton.setForeground(Color.WHITE);
        descriptionOfPassword.setBackground(Color.BLACK);
        descriptionOfPassword.setForeground(Color.WHITE);
        descriptionOfPassword.setCaretColor(Color.WHITE);
        label.setFont(label.getFont().deriveFont(32.0f));
        goBackButton.setFont(goBackButton.getFont().deriveFont(32.0f));
        generatePassword.setFont(generatePassword.getFont().deriveFont(32.0f));
        descriptionOfPassword.setFont(descriptionOfPassword.getFont().deriveFont(32.0f));


    }


    private void initComponents() {

        generatePassword = new JButton("Generate a password");
        label = new JLabel("Type in a title for the new password:");
        descriptionOfPassword = new JTextField();
        goBackButton = new JButton("Go back");

        generatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int overwritePassword = 0;

                if(descriptionOfPassword.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(GUICreatePassword.this, "<html><h1 style='font-family: Calibri; " +
                            "font-size: 36pt;'>Type in at least one character!");
                }
                else if(descriptionOfPassword.getText().length()>15)
                {
                    JOptionPane.showMessageDialog(GUICreatePassword.this, "<html><h1 style='font-family: Calibri; font-size: 36pt;'>The title is too big!");
                }
                else {
                    try {

                        String titleOfNewPassword = descriptionOfPassword.getText();

                        for(PasswordWrapper pw : FileReader.readAllPasswords())
                        {
                            if(pw.getTitleOfPassword().equals(titleOfNewPassword+".txt"))
                            {
                                overwritePassword =JOptionPane.showConfirmDialog(GUICreatePassword.this
                                        , "<html><h1 style='font-family: Calibri; font-size: 36pt;'>A password for this title already exists" +
                                                ",<br>do you want to overwrite it?");

                                if(overwritePassword==1)
                                {
                                    descriptionOfPassword.setText("");
                                }

                            }

                        }


                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    if(overwritePassword==0){
                    String password = PasswordGenerator.generate(20);
                    try {
                        FileCreater.createTextFile(descriptionOfPassword.getText(),password);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(GUICreatePassword.this, "<html><h1 style='font-family: Calibri; font-size: 36pt;'>The password is: " + password);
                    descriptionOfPassword.setText("");}
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SecondPage.buildSecondPageGUI();
            }
        });

    }
}
