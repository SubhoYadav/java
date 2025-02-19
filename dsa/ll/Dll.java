public class Dll {
    public static class Node {
        int data;
        Node back;
        Node next;

        Node (int _data, Node _back, Node _next) {
            this.data = _data;
            this.back = _back;
            this.next = _next;
        }

        Node (int _data) {
            this.data = _data;
            this.back = null;
            this.next = null;
        }
    }

    static Node arrayToDll (int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            mover.next = new Node(arr[i], mover, null);
            mover = mover.next;
        }
        return head;
    }

    static void printLinkedList (Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }

    static void printLinkedListBackwards (Node tail) {
        while (tail != null) {
            System.out.print(tail.data + " -> ");
            tail = tail.back;
        }

        System.out.println("NULL");
    }

    static Node insertTail (Node head, int data) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node newNode = new Node(data, tail, null);
        tail.next = newNode;

        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        Node head = arrayToDll(arr);
        // printLinkedList(head);

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // printLinkedListBackwards(tail);

        head = insertTail(head, 22);
        while (tail.next != null) {
            tail = tail.next;
        }
        printLinkedList(head);
    }
}
