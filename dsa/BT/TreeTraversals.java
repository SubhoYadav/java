import java.util.*;

// There are two types of traversals in BT: BFS and DFS.
// BFS: Level order traversal
// DFS: Pre-order, Post-order, In-order
//      RtLR        LRRt       LRtR 
public class TreeTraversals {
  // why we are declaring this class static ??
  public static class Node {
    int data;
    Node left, right;

    Node(int key) {
      data = key;
    }
  }

  static void preorderTraversal(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preorderTraversal(root.left);
    preorderTraversal(root.right);
  }

  static void postorderTraversal(Node root) {
    if (root == null) return;
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    System.out.print(root.data + " ");
  }

  static void inorderTraversal(Node root) {
    if (root == null) return;
    inorderTraversal(root.left);
    System.out.print(root.data + " ");
    inorderTraversal(root.right);
  }

  static void levelOrderTraversal(Node root) {
    // Queue is an interface so it needs a concrete class like LinkedList for its implementation
    Queue<Node> queue = new LinkedList<Node>();
    ArrayList<Integer> traversal = new ArrayList<Integer>();

    queue.add(root);
    while(!queue.isEmpty()) {
      Node removedNode = queue.remove();
      traversal.add(removedNode.data);

      if (removedNode.left != null) queue.add(removedNode.left);
      if (removedNode.right != null) queue.add(removedNode.right);
    }

    System.out.println("Level order traversal is " + traversal);
  }

  public static void main(String args[]) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    root.left.right.left = new Node(8);
    root.right.right.left = new Node(9);
    root.right.right.right = new Node(10);

    System.out.println("Pre-order traversal ");
    preorderTraversal(root);
    System.out.println();

    System.out.println("Post-order traversal ");
    postorderTraversal(root);
    System.out.println();

    System.out.println("In-order traversal ");
    inorderTraversal(root);
    System.out.println();
    
    levelOrderTraversal(root);

    Queue<Node> q = new LinkedList<Node>();
    q.add(root);

    System.out.println(q.peek().data);
  }
}


// Inorder traversal of the tree: 4,2,8,5,1,6,3,9,7,10 
// Preorder traversal of the tree: 1,2,4,5,8,3,6,7,9,10
// Postorder traversal of the tree: 4,8,5,2,6,9,10,7,3,1