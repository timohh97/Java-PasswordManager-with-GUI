import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileDeleter {

    public static void deleteTextFile(String titleOfPassword){


        File file = new File("C:\\Users\\timos\\Desktop\\Passwords\\"+titleOfPassword);
        System.out.println(file.delete());

    }
}
