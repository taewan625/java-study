package dataStructure;

public class ArrayQueue {
    private int front;
    private int rear;
    private int count;
     int size;
    private final int increment;
    private Object[] itemQueue;
    private final Object itemEmpty = "empty";

    public ArrayQueue() {
        front = 0; // 처음 큐
        rear = 0; // 큐 저장 위치
        count = 0; // 큐 개수
        size = 5; // 큐 처음 크기
        increment = 10; // 배열 확장 단위
        itemQueue = new Object[size]; // 큐원소 저장 배열
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void insert(Object x) {
        if (count == size) {
            int oldSize = size;
            size += increment;
            Object[] tempArray = new Object[size];
            System.out.println("front = " + front);
            for (int i = 0; i < count; i++, front = (front + 1) % oldSize) { // i++과 front 계산은 제일 마지막에 수행
//                System.out.println("f: " + front); // 0부터 채워 넣음
                tempArray[i] = itemQueue[front];
            }
            itemQueue = tempArray;
            front = 0;
            rear = count;
        }
        itemQueue[rear] = x;
        rear = (rear + 1) % size;
        count++;
    }

    public Object delete() {
        if (isEmpty()) {
            System.out.println("empty");
        }
        Object tempItem = itemQueue[front];
        front = (front + 1) % size;
        count--;
        return tempItem;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("empty");
            return itemEmpty;
        } else {
            return itemQueue[front];
        }
    }

    public void print() {
        for (int i = front; i < rear; i++) {
            System.out.println(itemQueue[i]);
        }
        System.out.println();
    }
}
