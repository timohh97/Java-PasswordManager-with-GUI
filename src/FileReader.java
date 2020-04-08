import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {


    public static List<PasswordWrapper> readAllPasswords() throws FileNotFoundException {
        List<PasswordWrapper> passwordWrapperList = new ArrayList<PasswordWrapper>();
        String home = System.getProperty("user.home");
        File passwordDirectory = new File(home+"\\Desktop\\Passwords");
        passwordDirectory.mkdir();

        for(File textFile : passwordDirectory.listFiles())
        {
            String titleOfPassword = textFile.getName();
            Scanner scan = new Scanner(textFile);
            String password = scan.nextLine();

            PasswordWrapper passwordWrapper = new PasswordWrapper();
            passwordWrapper.setPassword(password);
            passwordWrapper.setTitleOfPassword(titleOfPassword);

            passwordWrapperList.add(passwordWrapper);
            scan.close();

        }

        return passwordWrapperList;
    }

}
