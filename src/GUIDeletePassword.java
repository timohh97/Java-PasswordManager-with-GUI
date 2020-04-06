import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIDeletePassword extends JFrame {

    private JLabel label;
    private JComboBox<String> dropDownMenu;
    private JButton deleteButton;


    public GUIDeletePassword(String title) throws FileNotFoundException {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(3,1);
        mainLayout.setVgap(15);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,60,60,60));
        panel.setLayout(mainLayout);
        panel.setBackground(Color.PINK);

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
        panel.add(deleteButton);




    }

    private void setColorOfButtons()
    {

    }


    private void initComponents() throws FileNotFoundException {

        label = new JLabel("Which password do you want to delete? Please choose:");
        java.util.List<PasswordWrapper> passwordWrapperList = PasswordReader.readAllPasswords();
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
        deleteButton = new JButton("Delete");


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int selectedPasswordTitleIndex =dropDownMenu.getSelectedIndex();
                String selectedPasswordTitle = passwordWrapperList.get(selectedPasswordTitleIndex).getTitleOfPassword();
                dropDownMenu.removeItemAt(selectedPasswordTitleIndex);
                FileDeleter.deleteTextFile(selectedPasswordTitle);
                dispose();
                JOptionPane.showMessageDialog(GUIDeletePassword.this,"Password removed successfully!");
                SecondPage.buildSecondPageGUI();


            }
        });




    }

}
