import java.util.function.DoubleUnaryOperator;

public class Lesson3_3 {
        public static double integrate(DoubleUnaryOperator f, double a, double b) {
            double integr=0;
            for (double i = a; i < b; i+=10e-6) {
                integr+=f.applyAsDouble(i);
            }
            return integr*=10e-6;
        }
        public static class AsciiCharSequence implements CharSequence /* extends/implements */ {
            byte[] text;// implementation
            public AsciiCharSequence(byte[] text){
                this.text = new byte[text.length];
                System.arraycopy(text, 0, this.text, 0, text.length);
            }
            public AsciiCharSequence(int size){
                this.text = new byte[size];
            }
            @Override
            public int length(){
                return text.length;
            }
            @Override
            public char charAt(int index){
                return (char) text[index];
            }
            @Override
            public AsciiCharSequence subSequence(int begin, int end){
                AsciiCharSequence help = new AsciiCharSequence(end-begin);
                System.arraycopy(this.text, begin, help.text, 0, end-begin);
                return help;
            }
            @Override
            public String toString(){
                StringBuilder help = new StringBuilder();

                for (byte b : text) {
                    help.append((char) b);
                }
                return help.toString();
            }
        }

    public static void main(String[] args) {
        CharSequence cs =  new AsciiCharSequence(new byte[] {32, 32, 32});
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }

}

