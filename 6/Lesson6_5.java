import java.util.stream.IntStream;

public class Lesson6_5 {
    public static IntStream pseudoRandomStream(int seed) {

        return IntStream.iterate(seed, n -> { int a=0, shet = 1, i = 1, n1 = n*n;
            while(n1 != 0 && shet <= 4){
                   if(shet>1) {
                       a += n1 % 10 * i;
                       i *= 10;
                   }
                   shet++;
                   n1 = n1/10;
            }
            return a;
        });
    }
    public static void main(String[] args){
        pseudoRandomStream(13).limit(10).forEach(System.out::println);
        System.out.println(525/10%1000);
    }
}
