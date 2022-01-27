public class Lesson2_2 {
    public static char charExpression(int a) {
        char simvol = '\\';
        return (char) ( (int) simvol + a);
    }
    public static void main(String[] args) {
        System.out.println(charExpression(29)); //1


    }
}
