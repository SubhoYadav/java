import java.util.*;
public class SerialiszeDeserialize {
  static ArrayList<String> res = new ArrayList<String>();
  static int ptr = 0;

  public static class Node {
    int data;
    Node left, right;

    Node(int key) {
      data = key;
      left = right = null;
    }
  }

  static void preorder (Node root) {
    if (root == null) return;

    System.out.print(root.data +  " ");
    preorder(root.left);
    preorder(root.right);
  }

  static void dfs(Node root) {
    if (root == null) {
        res.add("N");
        return;
    }

    res.add(Integer.toString(root.data));
    dfs(root.left);
    dfs(root.right);
  }

  static String serialisze (Node root) {
    dfs(root);
    return String.join(",", res);
  }

  static Node construct (String[] nodes) {
    if (nodes[ptr].equals("N")) {
        ptr++;
        return null;
    }

    Node root = new Node(Integer.parseInt(nodes[ptr]));
    ptr++;

    root.left = construct(nodes);
    root.right = construct(nodes);

    return root;
  }
  static Node deserialize (String serial) {
    String nodes[] = serial.split(",");
    return construct(nodes);
  }

  public static void main(String args[]) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.right.left = new Node(4);
    root.right.right = new Node(5);

    System.out.println("Preorder traversal before seialization:");
    preorder(root);
    System.out.println();

    String serialized = serialisze(root);
    System.out.println(serialized);

    Node deserialisedTreeRoot = deserialize(serialized);

    System.out.println("Preorder traversal after seialization:");
    preorder(deserialisedTreeRoot);
    System.out.println();
  }
}
