import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreater {




    public static void createTextFile(String title, String password) throws IOException {
        File passwordDirectory =new File("..\\..\\Desktop\\Passwords");
        passwordDirectory.createNewFile();
        File text = new File("..\\..\\Desktop\\Passwords\\"+title+".txt");
        text.createNewFile();
        FileWriter fw = new FileWriter(text);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(password);
        pw.close();
        fw.close();
    }

}
