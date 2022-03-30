import java.util.*;

public class Lesson6_2 {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set_help = new HashSet<>();
        boolean flag = true;
        Iterator<T> iterator1 = (Iterator<T>) set1.iterator();
        while (iterator1.hasNext()) {
            T help = iterator1.next();
            //System.out.println("set1 " + help);
            Iterator<T> iterator2 = (Iterator<T>) set2.iterator();
            while (iterator2.hasNext()) {
                T help2 = iterator2.next();
                //System.out.println("set2 " + help2);
                if (help == help2)
                    flag = false;
            }
            if (flag)
                set_help.add(help);
            flag = true;
        }
        Iterator<T> iterator2 = (Iterator<T>) set2.iterator();
        while (iterator2.hasNext()) {
            T help = iterator2.next();
            System.out.println("set2 " + help);
            Iterator<T> iterator11 = (Iterator<T>) set1.iterator();
            while (iterator11.hasNext()) {
                T help2 = iterator11.next();
                System.out.println("set1 " + help2);
                if (help == help2)
                    flag = false;
            }
            if (flag)
                set_help.add(help);
            flag = true;
        }


        return set_help;
    }

    public static void main(String args[]) {
        Set<String> set1 = new HashSet<>();
        set1.add("6");
        set1.add("4");
        set1.add("5");
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
