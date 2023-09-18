package onecard.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void method() {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            myLinkedList.add(i);
        }
        for (int i = 0; i < 20; i++) {
            myLinkedList.next();
            Node current = myLinkedList.getCurrent();
            System.out.println("current = " + current);
        }

    }
    @Test
    void method1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 0; i < 5; i++) {
            myLinkedList.add(i);
        }
        for (int i = 0; i < 20; i++) {
            myLinkedList.prev();
            Node current = myLinkedList.getCurrent();
            System.out.println("current = " + current);
        }
    }
}