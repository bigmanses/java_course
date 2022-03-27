import javax.crypto.CipherOutputStream;
import java.io.*;

public class Lesson5_1b {
    public static void main(String[] args) throws IOException {

        int pred = System.in.read();
        int next;
        while (pred != -1)
        {
            next = System.in.read();
            if(pred != 13 || next != 10)
                System.out.write(pred);
            pred = next;

        }

    }
}
