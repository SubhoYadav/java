import java.util.*;
public class IterativeTraversal {

  public static class Node {
    int data;
    Node left;
    Node right;
    Node(int key) {
      data = key;
      left = null;
      right = null;
    }
  }
  static ArrayList<Integer> iterativePostOrderTraversal (Node root) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<Node> stck = new Stack<Node>();
    stck.push(root);
    Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

    while(!stck.isEmpty()) {
      Node stackTop = stck.peek();
      // System.out.println("stcaktop " + " " + stackTop.data + " " + stackTop.right.data);
      

      if (stackTop.right != null && visited.get(stackTop.right.data) == null) {
        stck.push(stackTop.right);
      }


      if (stackTop.left!= null && visited.get(stackTop.left.data) == null) {
        stck.push(stackTop.left);
      }

      if (visited.get(stackTop.data) != null) {
        // we are visiting the element twice so pop it off
        result.add(stackTop.data);
        stck.pop();
      }
      else {
        visited.put(stackTop.data, true);
      }
    }

    return result;

  }
   
     
  static ArrayList<Integer> iterativePostOrderTraversalMap (Node root) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    Stack<Node> stck = new Stack<Node>();
    stck.push(root);
    Stack<Boolean> visited = new Stack<Boolean>();
    visited.push(false);

    while(!stck.isEmpty()) {
      Node stackTop = stck.pop();
      Boolean isStackTopVisited = visited.pop();
      
      if (isStackTopVisited == true) {
        result.add(stackTop.data);
      }

      else {
        stck.push(stackTop);
        visited.push(true);
        
        if (stackTop.right != null) {
          stck.push(stackTop.right);
          visited.push(false);
        }


        if (stackTop.left != null) {
          stck.push(stackTop.left);
          visited.push(false); 
        }
      
      }
    }

    return result;

  }
  

  static ArrayList<Integer> iterativeInorderTraversal (Node root) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    Stack<Node> stck = new Stack<Node>();
    Node curr = root;

    while (!stck.isEmpty() || curr != null) {
      while (curr != null) {
        stck.push(curr);
        curr = curr.left;
      } 

      curr = stck.pop();
      ans.add(curr.data);
      curr = curr.right;
    }

    return ans;
  }
  public static void main(String args[]) {
    Node root = new Node(5);
    root.left = new Node(1);
    root.right = new Node(4);


    root.right.left = new Node(2);
    root.right.right = new Node(3);

    // System.out.println(iterativePostOrderTraversal(root));

    
    System.out.println(iterativeInorderTraversal(root));
  }
}
