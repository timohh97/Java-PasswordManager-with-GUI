import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreater {




    public static void createTextFile(String title, String password) throws IOException {
        File file = new File("C:\\Users\\timos\\Desktop\\Passwords\\"+title+".txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(password);
        pw.close();
        fw.close();
    }

}
