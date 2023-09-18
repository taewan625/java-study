package dataStructure;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    boolean LinkedListImpl(int a, int b) {
        LinkedList list = new LinkedList();

        // list 개수 추가
        for (int i = 0; i < a; i++) {
            list.add(i);
        }
        for (int i = 0; i < b; i++) {
            list.get(i);
        }
        // 내림차순 생성
        for (int i = b; i < 0; i--) {
            list.get(i);
        }

        return true;
    }

    @Test
    void addCorrect() {
        assertTrue(LinkedListImpl(8, 4));
        assertTrue(LinkedListImpl(8, 8));
        assertTrue(LinkedListImpl(8, 1));
        assertTrue(LinkedListImpl(1, 1));
        assertTrue(LinkedListImpl(7, 8));
    }
//    @Test
    void addOverNum(){
        assertThrows(NullPointerException.class, () -> LinkedListImpl(1, 8));
        assertThrows(NullPointerException.class, () -> LinkedListImpl(6, 8));
    }
    @Test
    // linked 끝이 처음과 연결되어서 a < b 여도 정상 작동
    void addOverNumCircle() {
        assertTrue(LinkedListImpl(1, 8));
        assertTrue(LinkedListImpl(6, 8));
    }
}