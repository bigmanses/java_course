import java.math.BigInteger;

public class Lesson2_4 {
    public static BigInteger factorial(int value) {
        BigInteger factorial = BigInteger.valueOf(1);
        for(int i = 1; i <= value; i++){
            BigInteger help = BigInteger.valueOf(i);
            factorial = factorial.multiply(help);
        }
        return factorial; // your implementation here
    }
    public static void main(String[] args) {
        System.out.println(factorial(999)); //1
    }
}