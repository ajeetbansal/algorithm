package aj.algorithm.tree;

/**
 * Created by ajeet on 4/4/2019.
 */
public class BinarySearchTree {
    class Node{
        int value;
        Node left;
        Node right;
    }
    Node root;

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.build(arr);
        System.out.println("binarySearchTree.search(10) = " + binarySearchTree.search(10));
        System.out.println("binarySearchTree.search(12) = " + binarySearchTree.search(12));
        System.out.println("binarySearchTree.search(11) = " + binarySearchTree.search(11));
        System.out.println("binarySearchTree.search(13) = " + binarySearchTree.search(13));
        System.out.println("binarySearchTree.search(5) = " + binarySearchTree.search(5));
        System.out.println("binarySearchTree.search(6) = " + binarySearchTree.search(6));
        System.out.println("binarySearchTree.search(7) = " + binarySearchTree.search(7));

    }

    public void build(int[] arr) {
        for(int i=0;i < arr.length; i++) {
            root = add(root, arr[i]);
        }
    }

    private Node add(Node root, int value) {
        if(root==null){
            root = new Node();
            root.value = value;
            return root;
        }
        if(value < root.value){
            root.left = add(root.left, value);
        }
        if(value > root.value){
            root.right = add(root.right, value);
        }
        return root;
    }

    public boolean search(int value) {
        return search(root, value);
    }

    public boolean search(Node root, int value) {
        if(root == null){
            return false;
        }
        if(value == root.value)
            return true;
        if(value < root.value){
            return search(root.left, value);
        }
        return search(root.right, value);
    }
}
