import java.util.*;
public class IterativeTraversal {

  public static class Node {
    int data;
    Node left;
    Node right;
    Node(int key) {
      data = key;
    }
  }

  static void iterativePreorderTraversal(Node root) {
    Stack<Node> stck = new Stack<Node>();
    stck.push(root);
    ArrayList<Integer> ans = new ArrayList<Integer>();

    while(!stck.isEmpty()) {
      Node poppedNode = stck.pop();
      // push the right node first because left has to come first and stack is a LIFO DS
      if (poppedNode.right != null) stck.push(poppedNode.right);
      if(poppedNode.left != null) stck.push(poppedNode.left);

      ans.add(poppedNode.data);
    }
    System.out.println("Pre-order traversal " + ans);
  }

  static void iterativeInorderTraversal(Node root) {
    Stack<Node> stck = new Stack<Node>();
    ArrayList<Integer> ans = new ArrayList<Integer>();

    stck.push(root);

    while(!stck.isEmpty()) {
      Node topNode = stck.peek();
      if (topNode.left != null) stck.push(topNode.left);
      
      else {
        Node poppedNode = stck.pop();
        // store the  result
        ans.add(poppedNode.data);
        if (poppedNode.right != null) stck.push(poppedNode.right);
        else {
          Node poppNode = 
        }
      }
    }
  }

  public static void main(String args[]) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(7);

    root.left.left = new Node(3);
    root.left.right = new Node(4);

    root.left.right.left = new Node(5);
    root.left.right.right = new Node(6);

    iterativePreorderTraversal(root);
  }
}
