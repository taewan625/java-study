package dataStructure;

class MyArrayStackTest {
    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack();
        stack.push("1");
        stack.push("10");
        stack.push("100");
        stack.push("1000");
        stack.print();
        System.out.println();

        System.out.println("stack.peek() = " + stack.peek());
        stack.pop();
        stack.print();

        stack.pop();
        stack.print();


    }
}