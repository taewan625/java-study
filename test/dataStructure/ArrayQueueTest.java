package dataStructure;

class ArrayQueueTest {


    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.print();
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.insert(7);
        q.print();

        q.delete();
        q.delete();
        q.delete();
        q.delete();
        q.delete();
        q.print();


        System.out.println("size: " + q.size);
    }

}