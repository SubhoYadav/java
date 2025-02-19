// https://www.geeksforgeeks.org/binary-tree-data-structure/

public class BTImplementation {
  // why we are declaring this class static ??
  public static class Node {
    int data;
    Node left, right;

    Node(int key) {
      data = key;
      left = right = null;
    }
  }
  public static void main(String args[]) {
    Node root = new Node(1);
    System.out.println(root.data + " " +  root.left + " " + root.right);
  }
}