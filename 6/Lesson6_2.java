import java.util.*;

public class Lesson6_2 {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();
        Set<T> help = new HashSet<>(set1);
        help.addAll(set2);
        for (T element : help){
            if(set1.contains(element) ^ set2.contains(element))
                result.add(element);
        }
        return result;
    }

    public static void main(String args[]) {
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        Set<String> set2 = new HashSet<>();
        set2.add("0");
        set2.add("1");
        set2.add("2");
        Set<String> set3 = symmetricDifference(set1, set2);
        Iterator<String> iterator = set3.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

// add some elements to the set
    }
}
