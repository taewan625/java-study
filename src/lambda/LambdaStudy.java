package lambda;

// 임의로 만든 함수형 interface
@FunctionalInterface
interface MyFunction{
    void run();
}
public class LambdaStudy {
    static void execute(MyFunction f){
        f.run();
    }

    static MyFunction getMyFunction() {
        return () -> System.out.println("f3.run()"); // 익명 객체 - 임의의 주소값을 가짐
    }

    public static void main(String[] args) {
        /* 함수형 interface 사용
        * 1. 변수
        * 2. 메서드 구현부
        * 3. 메서드 params 구현 class
        * */

        // f1 == f2
        MyFunction f1 = () -> System.out.println("f1.run()");

        // 익명 객체로 오버라이딩 직접 표현
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction myFunction = getMyFunction();

        execute(getMyFunction() );
        f1.run();
        f2.run();
        myFunction.run();
        getMyFunction().run();

    }
}