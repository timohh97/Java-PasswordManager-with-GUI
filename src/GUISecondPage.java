import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        panel.setBackground(Color.PINK);

        add(panel,BorderLayout.CENTER);

        initComponents();
        addComponentsToPanel(panel);

        setColorOfComponents();

        setLocationRelativeTo(null);
        setVisible(true);
        pack();
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

    }


    private void initComponents() {

        label = new JLabel("Do you want to create or see a password?:");
        buttonCreate = new JButton("Create password");
        buttonSee = new JButton("See password");

        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CreatePassword.buildCreatePasswordGUI();
            }
        });

    }
}
