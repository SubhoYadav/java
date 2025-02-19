import java.util.*;

public class SetIterator {
    public static void main(String[] args) {
        Set<Integer> st = new HashSet();
        st.add(1);
        st.add(2);
        st.add(3);
        
        Iterator<Integer> it = st.iterator();
        if (it.hasNext()) {
            int firstInteger = it.next();
            System.out.println(firstInteger);

            st.remove(firstInteger);
        }

    }
}
