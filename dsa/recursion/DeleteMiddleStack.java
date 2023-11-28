import java.util.*;
public class DeleteMiddleStack {
    public static void main(String a[]) {
        Stack<Integer> stck = new Stack<Integer>();
        System.out.println(stck);
        stck.push(5);
        stck.push(7);
        System.out.println(stck);
        stck.pop();
        System.out.println(stck);
        System.out.println(stck.peek());
    }
}