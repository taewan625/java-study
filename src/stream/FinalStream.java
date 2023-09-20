package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class FinalStream {
    public static void main(String[] args) {
        /* reduce
         * 1. Optional<T> reduce(BinaryOperator<T> accumulator)
         * 2. T reduce(T identity, BinaryOperator<T> accumulator)
         * 3. U reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner)
         * */

        String[] strArr = {
                "Inheritance", "Java", "Lambda", "OptionalDouble", "IntStream", "count",
                "stream", "sum",    // 생략시, orElse 작동
                ""                  // 없으면 true
        };

        Stream.of(strArr).forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        System.out.println("noEmptyStr = " + noEmptyStr);

        Optional<String> first = Stream.of(strArr)
                .filter(s -> !s.isEmpty() && s.charAt(0) == 's') // "" 때문에 내부 예외처리
                .findFirst();
        System.out.println("first = " + first.orElse(""));


        Stream.of(strArr).mapToInt(String::length).forEach(System.out::println);

        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b) -> a + 1);
        int reduce = intStream2.reduce(0, (a, b) -> a + b); // Integer::sum
        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println("count = " + count);
        System.out.println("reduce = " + reduce);
        System.out.println("max = " + max.getAsInt());
        System.out.println("min = " + min.getAsInt());

        /* collect(Collector c)
         * collect(), Collector, Collectors
         * 컬렉션과 배열 변환
         * 통계
         * 리듀싱
         * 문자열결합
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
        for (Student s : stuArr) System.out.println(s);
        System.out.println();

        List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList());
        // List<String> names = Stream.of(stuArr).map(Student::getName).toList();
        System.out.println("names = " + names);
        System.out.println();

        Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);
        for (Student s : stuArr2) System.out.println(s);
        System.out.println();

        Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(Student::getName, s -> s));
        for (String name : stuMap.keySet())
            System.out.println(name + "-" + stuMap.get(name));
        System.out.println();

        Long stuCount = Stream.of(stuArr).collect(counting());
        Stream.of(stuArr).count();
        System.out.println("stuCount = " + stuCount);

        Integer stuTotalScore = Stream.of(stuArr).collect(summingInt(Student::getTotalScore));
        Stream.of(stuArr).mapToInt(Student::getTotalScore).sum();
        System.out.println("stuTotalScore = " + stuTotalScore);

        stuTotalScore = Stream.of(stuArr).collect(reducing(0, Student::getTotalScore, Integer::sum));
        System.out.println("stuTotalScore = " + stuTotalScore);

        Optional<Student> topStudent = Stream.of(stuArr).collect(maxBy(comparingInt(Student::getTotalScore)));
        Stream.of(stuArr).max(comparingInt(Student::getTotalScore));
        System.out.println("topStudent = " + topStudent);

        IntSummaryStatistics stat = Stream.of(stuArr).collect(summarizingInt(Student::getTotalScore));
        System.out.println("stat = " + stat);

        String studentName = Stream.of(stuArr)
                .map(Student::getName)
                .collect(joining(", ", "{", "}"));

        System.out.println("studentName = " + studentName);
        System.out.println();


        /* 그룹화와 분할
         * partitioningBy()
         * groupingBy()
         * */

        Student2[] stu1Arr = {
                new Student2("나자바", true, 1, 1, 300),
                new Student2("김지미", false, 1, 1, 250),
                new Student2("김자바", true, 1, 1, 200),
                new Student2("이지미", false, 1, 2, 150),
                new Student2("남자바", true, 1, 2, 100),
                new Student2("안지미", false, 1, 2, 50),
                new Student2("황지미", false, 1, 3, 100),
                new Student2("강지미", false, 1, 3, 150),
                new Student2("이자바", true, 1, 3, 200),

                new Student2("나자바", true, 2, 1, 300),
                new Student2("김지미", false, 2, 1, 250),
                new Student2("김자바", true, 2, 1, 200),
                new Student2("이지미", false, 2, 2, 150),
                new Student2("남자바", true, 2, 2, 100),
                new Student2("안지미", false, 2, 2, 50),
                new Student2("황지미", false, 2, 3, 100),
                new Student2("강지미", false, 2, 3, 150),
                new Student2("이자바", true, 2, 3, 200),
        };


        System.out.println("1. 단순분할 : 성별");

        Map<Boolean, List<Student2>> stu2BySex = Stream.of(stu1Arr).collect(partitioningBy(Student2::isMale));
        List<Student2> male = stu2BySex.get(true);
        List<Student2> female = stu2BySex.get(false);

        for (Student2 m : male) System.out.println(m);
        System.out.println();
        for (Student2 f : female) System.out.println(f);

        System.out.println("2. 단순분할 : 통계 성별 학생수");
        Map<Boolean, Long> stu2NumBySex = Stream.of(stu1Arr).collect(partitioningBy(Student2::isMale, counting()));
        System.out.println(stu2NumBySex.get(true));
        System.out.println(stu2NumBySex.get(false));

        System.out.println("3. 단순분할 : 통계 성별 1등");
        Map<Boolean, Optional<Student2>> topScoreMySex = Stream.of(stu1Arr)
                .collect(partitioningBy(Student2::isMale, maxBy(comparingInt(Student2::getScore))));
        System.out.println(topScoreMySex.get(true));
        System.out.println(topScoreMySex.get(false));

        Map<Boolean, Student2> topScoreMySex2 = Stream.of(stu1Arr)
                .collect(partitioningBy(Student2::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(Student2::getScore)), Optional::get))
                );

        System.out.println(topScoreMySex2.get(true));
        System.out.println(topScoreMySex2.get(false));

        System.out.println("4. 다중분할 성별 불합격자, 100점 이하 ");
        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex =
                Stream.of(stu1Arr).collect(partitioningBy(Student2::isMale,
                        partitioningBy(s -> s.getScore() <= 100)));
        List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

        for(Student2 m : failedMaleStu) System.out.println(m);
        for(Student2 f : failedFemaleStu) System.out.println(f);


        /* groupingBy()
        * */
        // TODO 실습은 거의 동일해서 나중에 ...

    }
}
