public class LinkedList<T> {
    Node<T> head;
    Node<T> newestNode;

    public LinkedList(T head) {
        this.head = new Node<>(head);
        newestNode = this.head;
    }

    public LinkedList() {
        this.head = null;
        newestNode = null;
    }

    public Node<T> get(int pos) {
        if (pos >= size()) {
            throw new IndexOutOfBoundsException(
                "Position " + pos + " is out of bounds. Size is " + size() + "."
            );
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < pos; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }    

    public void add(T value) {
        Node<T> placeholder = new Node<>(value);

        if (head == null) {
            head = placeholder;
            newestNode = placeholder;
        } else {
            newestNode.next = placeholder;
            placeholder.prev = newestNode;
            newestNode = placeholder;
        }

    }

    public void add(int pos, T value) {
        Node<T> newNode = new Node<>(value);

        if (pos > size()) {
            throw new IndexOutOfBoundsException(
                "Position " + pos + " is out of bounds. Size is " + size() + "."
            );
        } else if (pos > 0) {
            Node<T> prevNode = get(pos - 1);
            Node<T> nextNode = prevNode.next;

            newNode.prev = prevNode;
            newNode.next = nextNode;

            prevNode.next = newNode;

            // for if pos == size()
            if (nextNode != null) nextNode.prev = newNode;
            else newestNode = newNode;

        } else { // Changing Head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (head != null) head.prev = newNode;
        newNode.next = head;
        head = newNode;
        if (newestNode == null) newestNode = newNode;
    }

    public void set(int pos, T value) {
        if (pos < 0 || pos >= size()) {
            throw new IndexOutOfBoundsException(
                "Position " + pos + " is out of bounds. Size is " + size() + "."
            );
        } else {
            Node<T> node = get(pos);
            node.data = value;
        }
    }

    public int size() {
        int size = 0;

        Node<T> currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }
}
