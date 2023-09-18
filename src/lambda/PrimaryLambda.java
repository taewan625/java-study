package lambda;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class PrimaryLambda {
    public static void main(String[] args) {
        // Function의 합성
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = Integer::toBinaryString;

        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        System.out.println("h.apply(\"FF\") = " + h.apply("FF"));
        System.out.println("h2.apply(2) = " + h2.apply(2));

        // Predicate의 결합
        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100;

        Predicate<Integer> combine =  notP.and(q.or(r));

        System.out.println("all.test(150) = " + combine.test(201));

        // isEqual()
        PracticeObject str1 = new PracticeObject(1);
        PracticeObject str2 = new PracticeObject(1);

        Predicate<PracticeObject> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        System.out.println("result = " + result);
    }

    static class PracticeObject {
        int i ;

        public PracticeObject(int i) {
            this.i = i;
        }
    }
}