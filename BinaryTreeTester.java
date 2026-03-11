public class BinaryTreeTester {
    public static void main(String[] args) {
        // Create a BST of integers
        BinaryTree<Integer> bst = new BinaryTree<>();

        // add values
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(12);
        bst.add(18);

        System.out.println("In-order traversal after adds:");
        bst.inOrder(bst.getHead()); // prints sorted order
        System.out.println();

        // Test get / contains
        System.out.println("Get 7: " + (bst.get(7) != null));
        System.out.println("Get 20: " + (bst.get(20) != null));

        // Remove a leaf
        System.out.println("Remove 3 (leaf): " + bst.remove(3));
        // Remove a node with one child
        System.out.println("Remove 15 (one child): " + bst.remove(15));
        // Remove node with two children
        System.out.println("Remove 5 (two children): " + bst.remove(5));

        System.out.println("In-order traversal after removals:");
        bst.inOrder(bst.getHead());
        System.out.println();
    }
}
