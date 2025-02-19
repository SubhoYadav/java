// Tortoise and Hare method
public class MiddleOfLinkedList {

    public static class Node {
        int data;
        Node next;

        Node (int _data) {
            this.data = _data;
            this.next = null;
        }
        Node (int _data, Node _next) {
            this.data = _data;
            this.next = _next;
        }

    }

    static Node createLLFromArray (int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            mover.next = new Node(arr[i]);
            mover = mover.next; // sliding the mover to the newly added node
        }
        return head;
    }

    static Node findMiddleNode (Node head) {
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5};
        int[] arr = {1,2,3,4,5,6};
        Node head = createLLFromArray(arr);

        Node middleNode = findMiddleNode (head);
        System.out.println("Middle node = " + middleNode.data);
    }
}
