public class Lesson2_1 {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a & b & !c & !d) || (a & c & !b & !d) || (a & d & !b & !c) || (b & c & !a & !d) || (b & d & !a & !c) || (c & d & !a & !b);
    }
    public static int leapYearCount(int year) {
        int a = 0;
        a = year/4 - year/100 + year/400;
        return a;
    }
    public static boolean doubleExpression(double a, double b, double c) {
        double E = 0.0001;
        return Math.abs(c-(a+b)) < E;
    }
    public static int flipBit(int value, int bitIndex) {
        int a = 2;
        a = (int) Math.pow(a, (bitIndex-1));
        return value^a ;// put your implementation here
    }
    public static void main(String[] args) {
        System.out.println(booleanExpression(true, true, false, false)); //1
        System.out.println(leapYearCount(400));  //2
        System.out.println(doubleExpression(0.1,0.2, 0.3));  //3
        System.out.println(flipBit(0,1));  //4

    }
}
