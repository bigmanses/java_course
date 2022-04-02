import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lesson6_4 {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
         Function<T, U> function = s -> condition.test(s) ? ifTrue.apply(s) : ifFalse.apply(s);
         return function;
    }
    public static void main(String[] args)
    {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        System.out.println();
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
    }


}
