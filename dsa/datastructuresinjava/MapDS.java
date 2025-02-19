import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * If the map does not contains a key, it returns null
 * HashMaps are unordered in java
 */

public class MapDS {
    public static void main(String[] args) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i=0; i<5; i++) {
            mp.put(i, i*i);
        }
        System.out.println(mp.get(1));
        System.out.println(mp.get(10));
        System.out.println(mp.containsKey(5));
        System.out.println(mp.containsKey(4));

        // Iterating the entries into the map
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        for (Integer key : mp.values()) {
            System.out.println(key);
        }

        String st1 = "Subho";

        System.out.println(Collections.sort(Arrays.asList(st1.toCharArray())));
    }  
}
