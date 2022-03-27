import javax.crypto.CipherOutputStream;
import java.io.*;
import java.nio.file.Path;

public class Lesson5_1 {
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello");
        File test1 = new File("/home/imr/IdeaProjects/java_course/5/test.txt");
        boolean delete = test1.delete();
        InputStream inputStream = new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01});
        //System.out.println(test1.isDirectory());
        byte[] buf = new byte[1024];
        int bytesRead;

        System.out.println(checkSumOfStream(inputStream));
    }
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int a = 0, count;
        while((count = inputStream.read()) != -1 )
            a = (Integer.rotateLeft(a, 1) ^ count);

        return a;
    }

}
