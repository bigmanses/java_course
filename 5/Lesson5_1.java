import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class Lesson5_1 {
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello");
        File test1 = new File("/home/imr/IdeaProjects/java_course/5");
        InputStream inputStream = new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01});
        //System.out.println(test1.isDirectory());
        System.out.println(checkSumOfStream(inputStream));
        Path p;
    }
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int a = 0, count;
        while((count = inputStream.read()) != -1 )
            a = (Integer.rotateLeft(a, 1) ^ count);

        return a;
    }

}
