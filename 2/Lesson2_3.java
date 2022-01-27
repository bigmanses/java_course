import com.sun.org.apache.xpath.internal.objects.XString;

public class Lesson2_3 {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        text = text.toUpperCase();
        char[] clone = text.toCharArray();
        System.out.println(text);
        boolean palindrom = true;
        int length = clone.length;
        for (int i = 0; i < length/2; i++)
        {
            if(clone[i] != clone[length-i-1]) {
                palindrom = false;
                break;
            }
        }
        return palindrom;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!")); //
    }
}
