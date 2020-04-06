import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        File f = new File("C:\\Users\\timos\\Desktop\\Passwords\\bla.txt");
        f.createNewFile();

        File f1 = new File("C:\\Users\\timos\\Desktop\\Passwords\\bla.txt");
        f1.delete();
    }
}
