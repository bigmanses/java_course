public class Lesson3_3 {
       /* public static double integrate(DoubleUnaryOperator f, double a, double b) {
            double integr=0;
            for (double i = a; i < b; i+=10e-6) {
                integr+=f.applyAsDouble(i);
            }
            return integr*=10e-6;
        }
        public static class AsciiCharSequence implements CharSequence {
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
        }*/

     interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
    abstract static class KeywordAnalyzer implements TextAnalyzer{


        public Label processText(String text){
            for (String keyword : getKeywords()) {
                if(text.contains(keyword)){
                    return getLabel();
                }
            }
            return Label.OK;
        }

        /**
         * Возвращение набора ключевых слов
         * @return
         */
        protected abstract String[] getKeywords();

        /**
         * Метка, положительная срабатывания
         * @return
         */
        protected abstract Label getLabel();
    }

    public static class TooLongTextAnalyzer implements TextAnalyzer{
        private int maxLength;
        @Override
        public Label processText(String text){
            return text.length() <= maxLength ? Label.OK:Label.TOO_LONG;
        }
        public TooLongTextAnalyzer(int maxLength){
            this.maxLength = maxLength;
        }
    }
    public static class SpamAnalyzer extends KeywordAnalyzer{
        String[] keywords;
        SpamAnalyzer(String[] keywords){
            this.keywords = keywords;
        }
        protected String[] getKeywords(){
            return keywords;
        }
        protected Label getLabel(){
            return Label.SPAM;
        }

    }
    public static class NegativeTextAnalyzer extends KeywordAnalyzer{
        String[] keywords = new String[] { ":(",  "=(",  ":|"};

        protected String[] getKeywords(){
            return keywords;
        }
        protected Label getLabel(){
            return Label.NEGATIVE_TEXT;
        }

    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (int i = 0; i < analyzers.length; i++) {
            if(analyzers[i].processText(text) == Label.OK) {
                //System.out.println(analyzers[i].processText(text));
                continue;
            }
            else
                return analyzers[i].processText(text);
        }
         return Label.OK;
    }
    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        System.out.println(checkLabels(textAnalyzers1, tests[0]));
    }
        /*CharSequence cs =  new AsciiCharSequence(new byte[] {32, 32, 32});
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!*/

}

