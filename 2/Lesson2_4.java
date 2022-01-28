import java.math.BigInteger;
import java.util.Arrays;

public class Lesson2_4 {
    public static BigInteger factorial(int value) {
        BigInteger factorial = BigInteger.valueOf(1);
        for(int i = 1; i <= value; i++){
            BigInteger help = BigInteger.valueOf(i);
            factorial = factorial.multiply(help);
        }
        return factorial;
    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int length = a1.length + a2.length;
        int[] a3 = new int[a1.length + a2.length];
        for(int k=0, i=0, j=0; k < length; k++) {
            if(i > a1.length-1){
                int help = a2[j];
                a3[k] = help;
                j++;
            }
            else if(j>a2.length-1){
                int help = a1[i];
                a3[k] = help;
                i++;
            }
            else if(a1[i] < a2[j]){
                int help = a1[i];
                a3[k] = help;
                i++;
            }
            else{
                int help = a2[j];
                a3[k] = help;
                j++;
            }

        }
        return a3; // your implementation here
    }
    public static String printTextPerRole(String[] roles, String[] textLines) {
        int length_roles = roles.length, lenghth_textLines = textLines.length;
        StringBuilder new_text = new StringBuilder();
        for (int i = 0; i < length_roles; i++) {
            new_text.append(roles[i]);
            new_text.append(":\n");
            for (int j = 0; j < lenghth_textLines; j++) {
                if(textLines[j].startsWith(roles[i]) && textLines[j].charAt(roles[i].length()) ==':'){
                    new_text.append(j+1);
                    new_text.append(")");
                    new_text.append(textLines[j].substring(roles[i].length() + 1));
                    new_text.append("\n");
                }
            }
            new_text.append("\n");
        }
        String final_text = new_text.toString();
        return final_text;
    }
    public static void main(String[] args) {
        String[] a1 = {"Соня", "Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич", "Лука"};
        String[] a2 = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?",
        "Артемий Филиппович: Как ревизор?",
        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printTextPerRole(a1, a2)); //1
    }
}