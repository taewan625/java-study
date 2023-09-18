package dataStructure;

public class LinkedListImpl {
    public static void main(String[] args) {}
}
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    @Override
    public String toString() {
        return data + "";
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        // 처음 노드가 없을 때 setting
        if (head == null) {
            head = newNode;       //  동일 Node 객체 주소가짐
            tail = newNode;       //  동일 Node 객체 주소가짐
        }else {
            newNode.prev = tail;
            tail.next = newNode; // tail.next에 새로운 Node 객체 주소로 변경 -> tail과 head는 같은 주소를 가지므로 head.next값도 변경됨
            tail = newNode;      // tail과 연결된 객체 주소를 최신 것으로 변경
        }
        tail.next = head; // tail의 Node주소는 계속 newNode로 변경되고 next를 head 주소로 연결하므로 마지막 칸에서 다시 처음으로 돌아옴
        head.prev = tail; // 반대로 head의 이전Node 주소를 newNode로 연결하면 첫칸에서 마지막으로 잘 넘어감
    }

    Node get(int index) {
        Node curr = head;
        if (index == 0) {
//            System.out.println("curr = " + curr);
            return curr;
        }
        for (int i = 1; i <= index; i++) {
            curr = curr.next;
        }
//        System.out.println("curr = " + curr);
        return curr;
    }

}
