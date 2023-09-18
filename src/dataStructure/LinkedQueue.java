package dataStructure;

public class LinkedQueue {
    QueueNode front, rear;

    void insert(Object x) {
        QueueNode temp;
        if (rear == null) {
            rear = new QueueNode();
            rear.data = x;
            front = rear;
        } else {
            temp = new QueueNode();
            temp.data = x;
            rear.link = temp;
            rear = temp;
            rear.link = null;
        }
    }

    void delete() {
        if (front == null) {
            System.out.println("null");
        } else {
            front = front.link; // 삭제 전 front 참조변수를 변경
            if (front == null) {
                rear = null;
            }
        }
    }

    void print() {
        QueueNode temp;
        temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println("null");
    }
}

class QueueNode {
    Object data;
    QueueNode link;
}

