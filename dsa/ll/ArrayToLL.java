public class ArrayToLL {
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

        // Using the concept of constructor overridding, we are letting the compiler decide which constructor to call, based on the argumentrs
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

    static Node insertHead(Node head, int data) {
        Node newNode = new Node(data, head);
        return newNode;
    }

    static Node deleteTail (Node head) {
        Node mover = head;

        if (head == null || head.next == null) {
            return null;
        }

        while(mover.next.next != null) {
            mover = mover.next;
        }

        mover.next = null;

        return head;
    }

    static int findLengthOfLL( Node head) {
        int cnt = 0;
        Node mover = head;
        while(mover != null) {
            cnt++;
            mover = mover.next;
        }

        return cnt;
    }

    static boolean searchLinkedList(Node head, int key) {
        Node mover = head;

        while(mover != null) {
            if (mover.data == key) {
                return true;
            }

            mover = mover.next;
        }

        return false;
    }

    static void printLinkedList (Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5};
        Node head;
        head = createLLFromArray(arr);

        printLinkedList(head);
        
        // inserting a new node to the linked list
        head = insertHead(head, 12);
        printLinkedList(head);

        // delete the tail of the linked list
        head = deleteTail(head);
        printLinkedList(head); 

        // print length of linked list
        int lengthOfLL = findLengthOfLL(head);
        System.out.println("Length: " + lengthOfLL);

        // search in LL
        System.out.println(searchLinkedList(head, 12));
        System.out.println(searchLinkedList(head, 120));
    }
}