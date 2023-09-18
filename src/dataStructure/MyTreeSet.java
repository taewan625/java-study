package dataStructure;

public class MyTreeSet {
    // 순서를 가지고 정렬된 링크드 리스트

        private TreeNode root;
        private int size;

    public int getSize() {
        return size;
    }

    public TreeNode getRoot() {
        return root;
    }

    public MyTreeSet() {
        root = null;
    }

    public void add(int element) {
        root = add(root, element); // 새로 update 될 때마다 renewal
    }

    private TreeNode add(TreeNode node, int element) { // node params는 root 이다.
        TreeNode newTreeNode;

        if (node == null) {
            newTreeNode = new TreeNode(element);// 해당 TreeNode가 비어있을 때 까지
            size++;
            return newTreeNode;
        }
        if (element < node.element) {
            node.left = add(node.left, element); // 재귀함수 이용 -> left가 null이 나올 때 까지

        } else if (element > node.element) {
            node.right = add(node.right, element); // 재귀함수 이용 -> right가 null이 나올 때까지
        }
        return node; // 중복되는 것은 추가되는 기능 없이 그대로 반환 됨, 크거나 작은 것도 그대로 반
    }


//    public void remove(int element) {
//        root = remove(root, element);
//    }

//    private TreeNode remove(TreeNode node, int element) {
////        if ()
//
//    }

    public boolean remove(int element){
        if (root == null) {
            return false;
        }

        int compareResult = root.element - element; // root가 크면 양수, 작으면 음수, 동일하면 0

        if (compareResult < 0) {
            // 지울값이 왼쪽 노드에 존재
        } else if (compareResult > 0) {
            // 지울 값이 오른쪽 노드에 존재
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }else {
                // root를 제거하는데 양쪽으로 값이 존재할 때
                // 1. root를 root.right로 변경
                // 2. root.left 주소를 root.right의 완전 왼쪽의 빈 tree node 나올 때 까지 내림 -> 재귀 순회 사용

                TreeNode tmp = root.left;
                int tmpNum = root.left.element;
                root = root.right;

                // 이거 사용 해야함

    /*            if (element < node.element) {
                    node.left = add(node.left, element); // 재귀함수 이용 -> left가 null이 나올 때 까지*/


            }
            size--;
            return true;
        }
        return false;
    }




    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString();
    }

    // 중위 순회 -> tree 형태의 노드들이 어떻게 연결되었는지 그림을 그려보면 재귀호출이 무한 루프에 빠지지 않는다는 것을 알 수 있다.
    private void inOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, sb);
        // 왼쪽부터 값넣기 -> 그림을 그려보면 root를 기준으로 오른쪽으로 갈 때 각각의 TreeNode의 left는 null인 것을 알 수 있다.
        sb.append(node.element).append(" ");
        inOrderTraversal(node.right, sb);
        // 오른쪽으로 넘어가기 -> 그림을 그려보면 root를 기준으로 왼쪽으로 가는 각각의 TreeNode의 right는 null인 것을 알 수 있다.
    }
}


class TreeNode{
    TreeNode left;
    int element;
    TreeNode right;

    public TreeNode(int element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}

