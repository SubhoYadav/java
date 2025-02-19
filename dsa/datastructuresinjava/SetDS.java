import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetDS {
   public static void main(String[] args) {
    Integer[] nums = {1,4,3,5};
    Set<Integer> set = new HashSet<Integer>(Arrays.asList(nums));
    System.out.println(set);
   }
}
