public class SumFromRootToLeaf {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node () {}
        Node (int _val) {
            this.val = _val;
        }
    }

    static int calculate (Node root, int initialSum) {
        int num1, num2;

        if (root.left == null && root.right == null) {
            // Its a leaf node
            return initialSum  + root.val;
        }

        if (root.left != null) {
            num1 = calculate(root.left, (root.val + initialSum) * 10);
        }
        else {
            num1 = 0;
        }
        
        if (root.right != null) {
            num2 = calculate(root.right, (root.val + initialSum) * 10);
        }
        else {
            num2 = 0;
        }

        return num1 + num2;
    }
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(0);

        root.left.left = new Node(5);
        root.left.right = new Node(1);

        int sum = calculate (root, 0);
        System.out.println(sum);
    }
}
