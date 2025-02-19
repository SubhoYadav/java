public class ReverseDll {
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

    static Node reverseDll(Node head)   {
        Node current = head;
        Node last;

        while (current.next != null) {
            last = current.next;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
            current.next = current.back;
            current.back = last;

            current = last;
        }

        last = current.next;
        current.next = current.back;
        current.back = last;
        
        return current;
    }

    static Node reverseDll2 (Node head) { 
        Node current = head;
        Node last = null;

        while(current != null) {
            last = current.back;
            current.back = current.next;
            current.next = last;

            current = current.back;
        }
        return last.back; 
    }

    public static class Node {
        int data;
        Node back;
        Node next;

        Node (int _data) {
            this.data = _data;
        }
        Node(int _data, Node _back, Node _next) {
            this.data = _data;
            this.back = _back;
            this.next = _next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,6};
        Node head = arrayToDll(arr);
        printLinkedList(head);

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // printLinkedListBackwards(tail);

        head = reverseDll2(head);
        System.out.println("Reversed LL => " );
        printLinkedList( head);
    }

}
