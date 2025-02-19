import java.util.*;

public class Practice {
    public static class Node {
        int data;
        Node left, right;

        Node(int _data) {
            this.data = _data;
            this.left = this.right = null;
        }
    }

    static ArrayList<Integer> iterativePreorderTraversal(Node root) {
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        Stack<Node> stck = new Stack<Node>();

        stck.push(root);
        while(!stck.isEmpty()) {
            Node n = stck.pop();
            // we will push the right node first then the left node because in pre-order traversal left comes first and then comes right node and stack is a LIFO DS
            if (n.right != null) stck.push(n.right);
            if (n.left != null) stck.push(n.left);

            traversal.add(n.data);
        }

        return traversal;
    }

    static ArrayList<Integer> iterativeInorderTraversal(Node root) {
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        Stack<Node> stck = new Stack<Node>();

        stck.push(root);

        while(!stck.isEmpty()) {
            Node n = stck.peek(); // only view and do not remove
            if (n.left != null) stck.push(n.left);
            else {
                Node p = stck.pop();
                traversal.add(p.data);

                if (n.right != null) stck.push(n.right);
                else {

                }

        }
        return traversal;
    }

    
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        ArrayList<Integer> preorder = iterativePreorderTraversal(root);
        System.out.println(preorder);


    }
}