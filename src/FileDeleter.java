import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileDeleter {

    public static void deleteTextFile(String titleOfPassword){

        String home = System.getProperty("user.home");
        File file = new File(home+"\\Desktop\\Passwords\\"+titleOfPassword);
        System.out.println(file.delete());

    }
}
