package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MakeStream {
    public static void main(String[] args) {
        /* Collection
         * list, set
         * Stream<T> Collection.stream()
         * */
        System.out.println("[collection]");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::print);
        System.out.println();

        /* Array
        * Stream.of(T... values)
        * Stream.of(T[])
        * Arrays.stream(T[])
        * Arrays.stream(T[] array, int startInclusive, int endExclusive)
        * TODO
        *  IntStream.of()
        *  IntStream Arrays.stream()
        * */
        System.out.println("[배열]");
        String[] stringArr = {"a", "b", "c"};
        Stream<String> strStream1 = Stream.of("a", "b", "c");
        Stream<String> strStream2 = Stream.of(stringArr);
        Stream<String> strStream3 = Arrays.stream(stringArr);
        Stream<String> strStream4 = Arrays.stream(stringArr, 0, 2);
        strStream4.forEach(System.out::print);
        System.out.println();

        /* 특정 범위의 정수
        * IntStream.range(int begin, int end)
        * IntStream.rangeClosed(int begin, int end)
        * */
        System.out.println("[특정 범위의 정수]");
        IntStream range = IntStream.range(1, 5);
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        range.forEach(System.out::print);
        System.out.println();
        rangeClosed.forEach(System.out::print);
        System.out.println();


        /* 임의의 수
        * 무한 스트림, 중간 연산자 limit() 과 함께 사용
        * IntStream ints()
        * LongStream longs()
        * DoubleStream doubles()
        * */
        System.out.println("[임의의 수]");
        IntStream ints = new Random().ints();
        DoubleStream doubles = new Random().doubles();
        LongStream longs = new Random().longs();
        ints.limit(5).forEach(System.out::println);
        System.out.println();
        doubles.limit(5).forEach(System.out::println);
        System.out.println();
        longs.limit(5).forEach(System.out::println);

        /* 람다식
        * 무한 스트림
        * iterate(T seed, UnaryOperator<T> f)
        * generate(Supplier<T> s)
        * */
        System.out.println("[람다식]");
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.limit(5).forEach(System.out::print);
        System.out.println();
        Stream<Double> generate = Stream.generate(Math::random);
        Stream<Integer> generate1 = Stream.generate(() -> 1);
        generate.limit(5).forEach(System.out::print);
        System.out.println();
        generate1.limit(5).forEach(System.out::print);
        System.out.println();

        /* 파일 todo. 15장 하고나서
        * Files.list(Path dir)
        * Files.lines(Path path)
        * */
        System.out.println("[파일]");

        System.out.println();

        /* 빈 스트림
        * Stream.empty()
        * */
        System.out.println("[빈 스트림]");
        Stream<Object> empty = Stream.empty();
        Stream<Object> emptyCnt = Stream.empty();
        empty.forEach(System.out::println);
        long count = emptyCnt.count();
        System.out.println("count = " + count);
        System.out.println();

        /* 두 스트림 연결
        * Stream.concat()
        * 동일 type 2개
        * */
        System.out.println("[두 스트림 연결]");
        String[] str1 = {"a", "b", "c"};
        String[] str2 = {"1", "2", "3"};

        Stream<String> strs1 = Stream.of(str1);
        Stream<String> strs2 = Stream.of(str2);
        Stream<String> concat = Stream.concat(strs1, strs2);
        concat.forEach(System.out::print);

        System.out.println();

    }
}
