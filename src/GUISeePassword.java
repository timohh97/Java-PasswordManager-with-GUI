import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class GUISeePassword extends JFrame {

    private JLabel label;
    private JComboBox<String> dropDownMenu;
    private JButton goBackButton;
    private JButton seePasswordButton;


    public GUISeePassword(String title) throws FileNotFoundException {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(4,1);
        mainLayout.setVgap(15);

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
        panel.add(dropDownMenu);
        panel.add(seePasswordButton);
        panel.add(goBackButton);





    }

    private void setColorOfButtons()
    {
        label.setForeground(Color.WHITE);
        dropDownMenu.setBackground(Color.WHITE);
        dropDownMenu.setForeground(Color.BLACK);
        seePasswordButton.setForeground(Color.WHITE);
        seePasswordButton.setBackground(Color.BLACK);
        goBackButton.setBackground(Color.BLACK);
        goBackButton.setForeground(Color.WHITE);
        label.setFont(label.getFont().deriveFont(32.0f));
        dropDownMenu.setFont(dropDownMenu.getFont().deriveFont(32.0f));
        seePasswordButton.setFont(seePasswordButton.getFont().deriveFont(32.0f));
        goBackButton.setFont(goBackButton.getFont().deriveFont(32.0f));



    }


    private void initComponents() throws FileNotFoundException {

        label = new JLabel("Which password do you need? Please choose:");
        List<PasswordWrapper> passwordWrapperList = PasswordReader.readAllPasswords();
        List<String> passwordTitlesList = new ArrayList<String>();
        for(PasswordWrapper wrap : passwordWrapperList) {

            passwordTitlesList.add(wrap.getTitleOfPassword());
        }

        String[] dropDownMenuArray = new String[passwordTitlesList.size()];

        for(int i=0;i<dropDownMenuArray.length;i++)
        {
            dropDownMenuArray[i]=passwordTitlesList.get(i);
        }

        dropDownMenu = new JComboBox<String>(dropDownMenuArray);
        goBackButton = new JButton("Go back");
        seePasswordButton = new JButton("See password");


        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  dispose();
                  SecondPage.buildSecondPageGUI();
            }
        });

        seePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedPasswordTitleIndex =dropDownMenu.getSelectedIndex();
                String password = passwordWrapperList.get(selectedPasswordTitleIndex).getPassword();
                JOptionPane.showMessageDialog(GUISeePassword.this,"<html><h1 style='font-family: Calibri; font-size: 36pt;'>The password is: "+password);
            }
        });


    }

    public JComboBox<String> getDropDownMenu() {
        return dropDownMenu;
    }

    public void setDropDownMenu(JComboBox<String> dropDownMenu) {
        this.dropDownMenu = dropDownMenu;
    }
}
