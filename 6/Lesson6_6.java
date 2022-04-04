import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson6_6 {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = new ArrayList<T>((Collection<? extends T>) stream);
        list.sort(order);
        if(list == null)
            minMaxConsumer(null, null);
        else
            minMaxConsumer(list.get(0), list.get(list.size()-1));
        // your implementation here
    }

    private static void minMaxConsumer(Object o, Object o1) {
    }

    public static void main(String[] args){
        Comparator<Integer> comp = (x, y) ->  (x.intValue() < y.intValue()) ? -1 : ((x.intValue() == y.intValue()) ? 0 : 1);
        Consumer<Integer> cons = (x) -> System.out.println("max" + x);
        findMinMax(IntStream.iterate(1, x -> x+1), comp , cons);
        }
}
