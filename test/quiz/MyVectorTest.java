package quiz;

import dataStructure.MyVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyVectorTest {
    MyVector myVector = new MyVector();

    int capacity() {
        return myVector.capacity;
    }

    boolean isEmpty() {
        return myVector.isEmpty();
    }

    int capacityObj(int capacity) {
        MyVector myVector = new MyVector(capacity);

        return myVector.capacity();
    }


    int size(int num) {
        MyVector myVector = new MyVector();
        for (int i = 0; i < num; i++) {
            myVector.add(i);
        }
        return myVector.size();
    }

    boolean get(int size){
        for (int i = 0; i < 10; i++) {
            myVector.add(i);
        }
        Object obj = myVector.objArr[size];
        Object getObj = myVector.get(size);
        return obj.equals(getObj);
    }
    Object getNull(int size){
        for (int i = 0; i < 10; i++) {
            myVector.add(i);
        }
        return myVector.get(size);
    }

    int indexOf(int num, int objIndex) {
        MyVector mv = new MyVector();
        for (int i = 0; i < num; i++) {
            mv.add(i);
        }
        Object o = mv.get(objIndex);
        return mv.indexOf(o);
    }


    int remove(int num, int index) {
        MyVector mv = new MyVector();
        for (int i = 0; i < num; i++) {
            mv.add(i);
        }
        mv.remove(mv.get(index));
        return mv.size;
    }

    @Test
    void capacityTest() {
        assertEquals(16, capacity());
    }

    @Test
    void isEmptyTest() {
        assertTrue(isEmpty());
    }

    @Test
    void objCapacityTest() {
        assertEquals(14,capacityObj(14));
        assertEquals(1,capacityObj(1));
        assertEquals(0,capacityObj(0));
        assertThrows(IllegalArgumentException.class, ()->capacityObj(-3));
    }


    @Test
    void sizeTest() {
        assertEquals(1,size(1));
        assertEquals(16,size(16));
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->size(17));
    }

    @Test
    void getTest() {
        assertTrue(get(4));
    }

    @Test
    void getNullTest() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getNull(-1));
    }

    @Test
    void indexOfTest() {
        assertEquals(3, indexOf(5,3));
    }


    @Test
    void removeTest(){
        assertEquals(9, remove(10,3));
        assertEquals(6, remove(7,6));
        assertEquals(2, remove(3,1));
        assertThrows(IndexOutOfBoundsException.class, () -> remove(7, 7));
    }
}