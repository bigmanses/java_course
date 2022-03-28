import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Lesson5_2b {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.forLanguageTag("en"));
        double help = 0;
        while (scanner.hasNext())
        {
                if(scanner.hasNextDouble())
                    help+= scanner.nextDouble();
                else
                    scanner.next();
        }
        String str = String.format("%f", help);
        System.out.println(str);
        scanner.close();
    }
}
