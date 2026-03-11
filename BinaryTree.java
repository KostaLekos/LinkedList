public class BinaryTree<T> {
    private Node<T> head;

    public BinaryTree(T head) {
        this.head = new Node<>(head);
    }

    public BinaryTree() {
        this.head = null;
    }

    public Node<T> get(T data) {
        Node<T> current = head;

        while (current != null) {
            int cmp = ((Comparable<T>) data).compareTo(current.data);
            if (cmp == 0) return current;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return null; // not found
    }

    public Node<T> getByPath(String binPath) { // Not recommended
        Node<T> currNode = head;
        for (int i = 0; i < binPath.length(); i++) {
            char c = binPath.charAt(i);

            if (currNode == null) {
                return currNode;
            } else if (c == '0') {
                currNode = currNode.left;
            } else if (c == '1') {
                currNode = currNode.right;
            } else {
                throw new IllegalArgumentException(
                    "Path must contain only a binary String. Invalid char: " + c
                );
            }
        }
        return currNode;
    }

    public void insert() {
        
    }
}