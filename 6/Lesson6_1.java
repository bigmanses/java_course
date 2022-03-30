import java.util.Objects;
import java.util.Optional;

public class Lesson6_1 {
    public static class Pair<T, Y> {
       public T first;
       public Y second;
       private Pair(T first, Y second){
            this.first = first;
            this.second = second;
        }
       public static <T, Y> Pair <T,Y> of(T first, Y second){
            return new Pair<>(first, second);
       }
       public T getFirst(){
           return first;
       }
        public Y getSecond(){
            return second;
        }
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (!(obj instanceof Pair)) {
                return false;
            } else {
                Pair obj1 = (Pair)obj;
                return ((Objects.equals(this.first, obj1.first)) && (Objects.equals(this.second, obj1.second)));
            }
        }
        public int hashCode(){
           return Objects.hashCode(this.first);
        }
    }
    public static void main(String[] args){
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        System.out.println(i);
        String s = pair.getSecond(); // "hello"
        System.out.println(s);
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println(mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustAlsoBeTrue);
    }
}
