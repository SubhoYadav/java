import java.util.HashMap;
import java.util.Map;

public class DetectLoopLL {

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
    
    // Using the tortoise and hare method, the distance between the fast and slow pointer will decrease by 1 with each step
    static boolean optmal (Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }
        return false;
    }
    public static void main(String[] args) {
    }
}
