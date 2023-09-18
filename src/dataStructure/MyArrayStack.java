package dataStructure;

public class MyArrayStack {
    private int top; //top 원소 가리키는 변수
    private int size; // 배열의 크기
    private int increment; // 배열 확장 단위
    private Object[] itemStack; // 원소 저장하는 배열
    private Object itemEmpty = "empty";


    // 스택 멤버변수들 초기화
    public MyArrayStack() {
        top = -1;
        size = 50;
        increment = 10;
        itemStack = new Object[size];
    }

    public boolean isEmpty() {
        return top == -1; // 공백 스택
    }

    public void push(Object x){
        if (top == size - 1) {
            size += increment;
            Object[] tempArray = new Object[size];
            for (int i = 0; i < top; i++) tempArray[i] = itemStack[i];
            itemStack = tempArray;
        }
        itemStack[++top] = x; // 원소 삽입
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return itemEmpty;
        }
        return itemStack[top--];
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return itemEmpty;
        } else {
            return itemStack[top];
        }
    }

    public void print() {
        for (int i = 0; i < top; i++) System.out.print(itemStack[i] + ",");
        System.out.println(itemStack[top]);
        System.out.println();
    }
}
