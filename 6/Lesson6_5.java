import java.util.stream.IntStream;

public class Lesson6_5 {
    public static IntStream pseudoRandomStream(int seed) {

        return IntStream.iterate(seed, n -> (n*n)/10%1000);
    }
    public static void main(String[] args){
        pseudoRandomStream(13).limit(10).forEach(System.out::println);
        System.out.println(525/10%1000);
    }
}
