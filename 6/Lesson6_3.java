import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lesson6_3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        if (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            for (int i = s.length - 1; i > 0; i--) {
                if ((i + 1) % 2 == 0) {
                    list.add(Integer.valueOf(s[i]));
                }
            }
        }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
}

