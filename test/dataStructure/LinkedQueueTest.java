package dataStructure;

class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        QueueNode temp;

        q.front = q.rear = null;

        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.print();
        q.delete();
        q.print();
    }

}