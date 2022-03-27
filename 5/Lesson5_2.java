import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Lesson5_2 {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder help = new StringBuilder();
        int count;
        while((count = reader.read()) != -1 )
            help.append((char)count);
        String str = help.toString();
        return str;
    }
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {48, 49, 50, 51});
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));

    }
}
