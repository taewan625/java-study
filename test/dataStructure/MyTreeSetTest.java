package dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeSetTest {
    int root() {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.add(4);
        myTreeSet.add(2);
        myTreeSet.add(5);
        myTreeSet.add(1);
        myTreeSet.add(3);
        TreeNode root = myTreeSet.getRoot();
        return root.element;
    }

    int right() {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.add(4);
        myTreeSet.add(2);
        myTreeSet.add(5);
        myTreeSet.add(6);
        myTreeSet.add(1);
        myTreeSet.add(3);
        TreeNode root = myTreeSet.getRoot();
        TreeNode right = root.right.right;
        return right.element;
    }

    int left() {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.add(5);
        myTreeSet.add(3);
        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(4);
        TreeNode root = myTreeSet.getRoot(); //4
        TreeNode left = root.left.left; //5 -> 4 -> 3

        System.out.println("myTreeSet.toString() = " + myTreeSet.toString());

        return left.element;
    }

    @Test
    int size() {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.add(5);
        myTreeSet.add(3);
        myTreeSet.add(1);
        myTreeSet.add(2);
        myTreeSet.add(4);
        return myTreeSet.getSize();
    }

    @Test
    void rootTest() {
        assertEquals(4, root());
    }

    @Test
    void leftTest() {
        assertEquals(1, left());
    }

    @Test
    void rightTest() {
        assertEquals(6,right());
    }


    @Test
    void sizeTest() {
        assertEquals(5,size());
    }

}