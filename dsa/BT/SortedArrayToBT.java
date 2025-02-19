import java.util.ArrayList;

public class SortedArrayToBT {

    public static class Node {
        int val;
        Node left;
        Node right;

        Node () {}
        Node (int _val) {
            this.val = _val;
        }
    }
    static Node convert (int arr[], int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            Node root = new Node(arr[mid]);
            
            root.left = convert(arr, low, mid - 1);
            root.right = convert(arr, mid + 1, high);

            return root;
        }
        return null;
    }

    static void preorder (Node root, ArrayList<Integer> traversal) {
        if (root == null) return;

        traversal.add(root.val);
        preorder(root.left, traversal);
        preorder(root.right, traversal);
    }
    public static void main(String[] args) {
        int arr[] = {-10,-3,0,5,9};

        Node root = convert(arr, 0, arr.length - 1);
        ArrayList<Integer> tree = new ArrayList<Integer>();

        preorder(root, tree);
        System.out.println(tree);
    }
}
