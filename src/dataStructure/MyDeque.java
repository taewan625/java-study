package dataStructure;

public class MyDeque {
    private int front;
    private int rear;
    private int count;
    int size;
    private int increment;
    private Object[] itemDeque;
    private final Object itemEmpty = "empty";

    public MyDeque() {
        front = 0; // 처음 큐
        rear = 0; // 큐 저장 위치
        count = 0; // 큐 개수
        size = 5; // 큐 처음 크기
        increment = 10; // 배열 확장 단위
        itemDeque = new Object[size]; // 큐원소 저장 배열
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void increaseArray() {
        size += increment;
        Object[] tempArray = new Object[size];
        for (int i = 0; i < rear; i++) {
            tempArray[i] = itemDeque[i];
        }
        itemDeque = tempArray;
    }

    public void insertLast(Object x) {
        itemDeque[rear] = x; // 값 넣기
        rear++;             // rear 값 증가
        if (rear == size) { // size 초과시 array 확장
            increaseArray();
            count++;
        }
    }

    public void insertFirst(Object x) {
        if (count != 0) {
            for (int i = count; i > 0; i--) {
                itemDeque[i] = itemDeque[i - 1];
                itemDeque[0] = x;
                count++;
                rear = count;
                if (rear == size) {
                    increaseArray();
                }
            }
        }
    }

    public Object deleteFirst() {
        if (isEmpty()) {
            System.out.println("null");
            return itemEmpty;
        }
        Object tempItem = itemDeque[0];
        for (int i = 0; i < count; i++) {
            itemDeque[i] = itemDeque[i + 1];
        }
        count--;
        rear--;
        return tempItem;
    }

    public Object deleteLast() {
        if (isEmpty()) {
            System.out.println("null");
            return itemEmpty;
        }
        Object tempItem = itemDeque[rear - 1];
        rear--;
        count--;
        return tempItem;
    }

    public Object First() {
        if (isEmpty()) {
            return itemEmpty;
        } else return itemDeque[front];
    }

    public Object Last() {
        if (isEmpty()) {
            return itemEmpty;
        } else return itemDeque[rear - 1];
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("null");
        } else
            for (int i = 0; i < rear; i++)
                System.out.println(itemDeque[i]);
    }

}
