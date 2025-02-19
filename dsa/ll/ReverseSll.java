public class ReverseSll {
    static class Node {
        int data;
        Node next;

        Node (int _data) {
            this.data  = _data;
            this.next = null;
        }

        Node (int _data, Node _next) {
            this.data = _data;
            this.next = _next;
        }
    }

    static Node createLLFromArray (int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }
        return head;
    }

    static void printLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }

    static Node reverseIterative (Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    static Node reverseRecursive (Node head) {
        // base case
        if (head == null || head.next == null) return head;

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        
        Node head = createLLFromArray(arr);
        printLL(head);

        head = reverseRecursive(head);
        System.out.println("Reversed LL");
        printLL(head);
    }
}
