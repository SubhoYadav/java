public class MajorityElement {
    public static void main(String[] args) {
        // int arr[] = {2,2,3,3,1,2,2};
        int arr[] = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        // Moore's voting algo
        int count = 0, el = 0;
        for (int i=0; i<arr.length; i++) {
            if (count == 0) {
                // If at any point count is 0 it means el gets cancelled
                el = arr[i];
            }

            if (arr[i] == el) {
               count++;
            }
            else {
                count--;
            }
        }
        System.out.println(el);
    }
}
