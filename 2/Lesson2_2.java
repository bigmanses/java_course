public class Lesson2_2 {
    public static char charExpression(int a) {
        char symbol = '\\';
        return (char) ( (int) symbol + a);
    }
    public static boolean isPowerOfTwo(int value) {
        return (Integer.bitCount(Math.abs(value)) == 1);
    }
    public static void main(String[] args) {
        System.out.println(charExpression(29)); //1
        System.out.println(isPowerOfTwo(-2));//2
    }
}
