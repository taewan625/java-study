package stream;

import java.util.Optional;

public class OptionalStudy {
    public static void main(String[] args) {
        /* Optional 객체 & 참조변수 초기화
         * 객체 생성     : Optional.of()         Optional.ofNullable()
         * 참조변수 초기화 : Optional<T>.empty()   null
         * */
        String str = "abc";
        Optional<String> optVal1 = Optional.of(str);
        Optional<String> optVal2 = Optional.of("abc");
        Optional<String> optVal3 = Optional.of(new String("abc"));

        // Optional<Object> optVal4 = Optional.of(null); // npe 발생
        Optional<String> optVal5 = Optional.ofNullable(null);

        Optional<String> optRef1 = null;
        Optional<String> optRef2 = Optional.empty();

        /* Optional 객체 값 가져오기
         * get()         : null 일 때 npe
         * orElse(V)     : null 일 경우 반환 하는 V
         * orElseGet()   : Supplier 제공
         * orElseThrow() : Supplier 제공
         * */

        String s = optVal1.get();
        System.out.println("s = " + s);

        s = optVal1.orElse("");
        System.out.println("s = " + s);

        s = optVal5.orElse("123");
        System.out.println("s = " + s);

        s = optVal5.orElseGet(() -> "321");
        System.out.println("s = " + s);

        // String s1 = optVal5.orElseThrow(NullPointerException::new);
        // System.out.println("s1 = " + s1);

        /* isPresent() */
        if (Optional.ofNullable(null).isPresent())
            System.out.println("optional 값이 true");
        else
            System.out.println("optional 값이 false");

        /* ifPresent() */
        Optional.of("abc").ifPresent(System.out::println);
        Optional.empty().ifPresent(System.out::println);



    }
}
