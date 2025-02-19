import java.util.ArrayList;

public class MergeTwoBT {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node (int _val) {
            this.val = _val;
        }

        Node () {
        }
    }

  static void dfs (Node root1, Node root2, Node mergedRoot) {
        if (root1 == null && root2 == null) return;
        
        if (root1 != null && root2 != null) {
            mergedRoot.val = root1.val + root2.val;
            
            if (mergedRoot.left == null && (root1.left != null || root2.left != null)) {
                mergedRoot.left = new Node();
            }
            dfs (root1.left, root2.left, mergedRoot.left);

            if (mergedRoot.right == null && (root1.right != null || root2.right != null)) {
                mergedRoot.right = new Node();
            }
            dfs (root1.right, root2.right, mergedRoot.right);
        }
        else if (root1 != null) {
            mergedRoot.val = root1.val;

            if (mergedRoot.left == null && (root1.left != null)) {
                mergedRoot.left  = new Node();
            }
            dfs(root1.left, null, mergedRoot.left);

            if (mergedRoot.right == null && (root1.right != null)) {
                mergedRoot.right = new Node();
            }
            dfs(root1.right, null, mergedRoot.right);
        }
        else {
            mergedRoot.val = root2.val;

            if (mergedRoot.left == null && (root2.left != null)) {
                mergedRoot.left= new Node();
            }
            dfs(null, root2.left, mergedRoot.left);

            if (mergedRoot.right == null && (root2.right != null)) {
                mergedRoot.right = new Node();
            }
            dfs(null, root2.right, mergedRoot.right);
        }
    }

    static Node merge (Node root1 , Node root2) {
        if (root1 == null && root2 == null) return null;

        int v1 = root1 != null ? root1.val : 0;
        int v2 = root2 != null ? root2.val : 0;

        Node mergedRoot = new Node(v1+v2);

        mergedRoot.left = merge(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        mergedRoot.right = merge(root1 != null ? root1.right : null, root2 != null ? root2.right : null);

        return mergedRoot;
    }

    static void preorder (Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static void main(String[] args) {
        // Node root1 = new Node(1);
        // root1.left = new Node(3);
        // root1.right = new Node(2);

        // root1.left.left = new Node(5);


        // Node root2 = new Node(2);
        // root2.left = new Node(1);
        // root2.right = new Node(3);

        // root2.left.right = new Node(4);
        // root2.right.right = new Node(7);


        // Node mergedRoot = new Node();

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(3);

        Node root2 = new Node(1);
        root2.right = new Node(2);
        root2.right.right = new Node(3);

        
        Node mergedRoot = merge(root1, root2);

        ArrayList<Integer> preorder = new ArrayList<Integer>();
        preorder(mergedRoot, preorder);
        System.out.println(preorder);
    }
}
