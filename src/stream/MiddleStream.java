package stream;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MiddleStream {
    public static void main(String[] args) {
        /*스트림 자르기
         * skip(long n)
         * limit(long maxSize)
         * */
        IntStream skipLimitIntStream = IntStream.rangeClosed(1, 10);
        skipLimitIntStream.skip(3).limit(5).forEach(System.out::print);
        System.out.println();

        /* 스트림 요소 걸러내기
         * filter(Predicated<? super T> predicate)
         * distinct()
         * */
        IntStream distinctIntStream = IntStream.of(1, 2, 2, 4, 4, 4, 5, 5, 6);
        distinctIntStream.distinct().forEach(System.out::print);

        IntStream rangeClosedIntStream = IntStream.rangeClosed(1, 10);
        rangeClosedIntStream.filter(i -> i % 2 == 0).forEach(System.out::print);

        /* 정렬
         * sorted()
         * sorted(Comparator<? super T> comparator)
         * todo - comparator 기본 제공 메서드 정리 필요
         * */

        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        studentStream.sorted(Comparator
                        .comparing(Student::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);


        /* map()
         * 1. 원하는 field 뽑기
         * 2. 특정 형태로 변환
         * */

        /* peek()
         * */

        File file = new File("Ex1.java");
        System.out.println(file.getName());

        Stream<File> fileStream = Stream.of(new File("Ex1.java"),
                new File("Ex1"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1.txt")
        );

        // fileStream.map(File::getName).forEach(System.out::print);
        System.out.println();

        fileStream.map(File::getName)
                .filter(s -> s.indexOf('.') != -1)
                .peek(s -> System.out.printf("filename=%s%n", s))
                .map(s -> s.substring(s.indexOf('.') + 1))
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .distinct()
                .forEach(System.out::print);
        System.out.println();

        /* mapToInt(), mapToLong(), mapToDouble()
         * sum(), average(), max(), min()
         * summaryStatistics()
         * -> Stream<T>       : mapToObj()
         * -> Stream<Integer> : boxed()
         * */
        Student[] stuArr = {
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        };

        Stream<Student> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        System.out.println();
        stuStream = Stream.of(stuArr);
        IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);
        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("stat.getCount() = " + stat.getCount());
        System.out.println("stat.getSum() = " + stat.getSum());
        System.out.println("stat.getAverage() = " + stat.getAverage());
        System.out.println("stat.getMax() = " + stat.getMax());
        System.out.println("stat.getMin() = " + stat.getMin());
        System.out.println();

        /* flatMap()
         * 1. 이미 stream으로 나뉘어진 배열 작업
         * 2. 긴 문자열 배열 나누는 작업
         * 3. stream까리 결합
         * */
        Stream<String[]> stream = Stream.of(new String[]{"abc", "def"}, new String[]{"ABC", "DEF"});
        stream.forEach(System.out::println);
        stream = Stream.of(new String[]{"abc", "def"}, new String[]{"ABC", "DEF"});
        stream.map(Arrays::stream).forEach(System.out::println);
        stream = Stream.of(new String[]{"abc", "def"}, new String[]{"ABC", "DEF"});
        stream.flatMap(Arrays::stream).forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

        System.out.println();
        Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
        // Stream<String[]> stream1 = strStrmStrm.map(s -> s.toArray(String[]::new)); // 내부 stream을 배열로 변경
        // Stream<String> stringStream = stream1.flatMap(Arrays::stream);

        // 더 좋은 방법 -  java.util.function.Function 인터페이스의 static method 사용
        Stream<String> stringStream = strStrmStrm.flatMap(Function.identity());
        stringStream.forEach(System.out::println);
    } // main 끝

}

