import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUISecondPage extends JFrame {

    private final String masterPassword ="test";
    private JLabel label;
    private JButton buttonCreate;
    private JButton buttonSee;
    private JButton buttonDelete;


    public GUISecondPage(String titel) {

        setTitle(titel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(4,1);
        mainLayout.setVgap(5);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,60,60,60));
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
        panel.add(buttonCreate);
        panel.add(buttonSee);
        panel.add(buttonDelete);

    }

    private void setColorOfComponents()
    {
        label.setForeground(Color.WHITE);
        buttonCreate.setBackground(Color.BLACK);
        buttonSee.setBackground(Color.BLACK);
        buttonDelete.setBackground(Color.BLACK);
        buttonCreate.setForeground(Color.WHITE);
        buttonSee.setForeground(Color.WHITE);
        buttonDelete.setForeground(Color.WHITE);
        label.setFont(label.getFont().deriveFont(32.0f));
        buttonCreate.setFont(buttonCreate.getFont().deriveFont(32.0f));
        buttonSee.setFont(buttonSee.getFont().deriveFont(32.0f));
        buttonDelete.setFont(buttonDelete.getFont().deriveFont(32.0f));


    }


    private void initComponents() {

        label = new JLabel("Do you want to create or see a password?:");
        buttonCreate = new JButton("Create a password");
        buttonSee = new JButton("See a password");
        buttonDelete = new JButton("Delete a password");

        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CreatePassword.buildCreatePasswordGUI();
            }
        });

        buttonSee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(FileReader.readAllPasswords().size()==0)
                    {
                        JOptionPane.showMessageDialog(GUISecondPage.this,"<html><h1 style='font-family: Calibri; font-size: 36pt;'>There are no passwords!");
                    }
                    else {
                        dispose();
                        try {
                            SeePassword.buildSeePasswordGUI();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(FileReader.readAllPasswords().size()==0)
                    {
                        JOptionPane.showMessageDialog(GUISecondPage.this,"<html><h1 style='font-family: Calibri; font-size: 36pt;'>There are no passwords!");
                    }
                    else {
                        dispose();
                        try {
                            DeletePassword.buildDeletePasswordGUI();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
