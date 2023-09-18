package lambda;

@FunctionalInterface
interface MyFunction{
    void run();
}
public class Practice {
    static void execute(MyFunction f){
        f.run();
    }

    static MyFunction getMyFunctino() {
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };
    }
}