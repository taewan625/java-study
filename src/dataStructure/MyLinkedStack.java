package dataStructure;

public class MyLinkedStack {
    StackNode top;
    String itemEmpty = "StackEmpty";

    // 추가
    void push(String x) {
        StackNode temp;
        // stack이 공백인 경우
        if (top == null) {
            top = new StackNode();
            top.data = x;
            top.link = null;
        } else {
            temp = new StackNode();
            temp.data = x;
            temp.link = top;
            top = temp;
        }
    }

    void print() {
        StackNode temp;
        temp = top;
        while (temp != null) {
            System.out.println(temp.data + ",");
            temp = temp.link;
        }
        System.out.println("null");
    }

    // 제일 top stackNode 출력
    Object peek() {
        if (top == null) {
            System.out.println("null");
            return itemEmpty;
        }
        return top.data;
    }


    // 제거
    void pop() {
        if (top == null) System.out.println("null");
        else top = top.link;
    }
}

class StackNode {
    Object data;
    StackNode link;
}
