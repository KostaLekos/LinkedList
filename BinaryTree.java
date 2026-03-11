public class BinaryTree<T extends Comparable<T>> {
    private Node<T> head;

    public BinaryTree(T head) {
        this.head = new Node<>(head);
    }

    public BinaryTree() {
        this.head = null;
    }

    public Node<T> get(T value) {
        Node<T> current = head;

        while (current != null) {
            int cmp = value.compareTo(current.data);
            if (cmp == 0) return current;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return null; // not found
    }

    public Node<T> getHead() {
        return head;
    }

    public boolean contains(T value) {
        Node<T> current = head;

        while (current != null) {
            int cmp = value.compareTo(current.data);
            if (cmp == 0) return true;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return false; // not found
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
                    "Path may only contain a binary String. Invalid char: " + c
                );
            }
        }
        return currNode;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
            return;
        }

        Node<T> current = head;

        while (true) {
            int cmp = value.compareTo(current.data);
            if (cmp == 0) {
                return;
            } else if (cmp < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node<T>(value);
                    return;
                }
            } else if (cmp > 0) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node<T>(value);
                    return;
                }
            }
        }
    }

    public boolean remove(T value) {
        if (head == null) return false;

        Node<T> parent = null;
        Node<T> current = head;

        // 1. Find the node to remove
        while (current != null && !current.data.equals(value)) {
            parent = current;
            if (value.compareTo(current.data) < 0) current = current.left;
            else current = current.right;
        }

        if (current == null) return false; // value not found

        // 2. Node has two children
        if (current.left != null && current.right != null) {
            // Find in-order successor (smallest in right subtree)
            Node<T> succParent = current;
            Node<T> succ = current.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // Copy successor's value to current node
            current.data = succ.data;

            // Now remove successor
            parent = succParent;
            current = succ;
        }

        // 3. Node has 0 or 1 child
        Node<T> child = (current.left != null) ? current.left : current.right;

        if (parent == null) {
            // Removing the root
            head = child;
        } else if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return true;
    }

    public void inOrder(Node<T> node) {
        if (node == null) return;       // base case: nothing to print
        inOrder(node.left);             // traverse left subtree
        System.out.print(node.data + " ");  // visit current node
        inOrder(node.right);            // traverse right subtree
    }
}