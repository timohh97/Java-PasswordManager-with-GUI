import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class GUISeePassword extends JFrame {

    private JLabel label;
    private JComboBox<String> dropDownMenu;


    public GUISeePassword(String titel) throws FileNotFoundException {
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

        System.out.println(PasswordReader.readAllPasswords());

    }


    private void addComponentsToPanel(JPanel panel)
    {
        panel.add(label);
        panel.add(dropDownMenu);



    }

    private void setColorOfButtons()
    {

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


    }
}
