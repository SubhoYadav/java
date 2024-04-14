import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static class Pair {
        int row;
        int col;
        Pair (int _row, int _col) {
            this.row = _row;
            this.col = _col;
        }
    }
    public static void main(String args[]) {
        Set<String> set = new HashSet<>();
        set.add(String.format("(%d, %d)", 2, 6));
        set.add(String.format("(%d, %d)", 2, 6));
        set.add(String.format("(%d, %d)", 2, 6));
        set.add(String.format("(%d, %d)", 2, 6));
        set.add(String.format("(%d, %d)", 2, 6));
        ArrayList<String> arrayList = new ArrayList<String>();
        
        arrayList.add("(2,4)");
        arrayList.add("(2,4)");
        arrayList.add("(2,4)");
        arrayList.add("(2,4)");
        arrayList.add("(2,4)");
        System.out.println(String.join("", arrayList));
        // System.out.println(set);
        // System.out.println(set.size());
    }
}
