/*
 * [3,1,-2,-5,2,-4]
 * the array contains equal no. of positive and -ve nos. we have to rearrange them in the following manner
 * [3,-2,1,-5,2,-4]
 * [+ve, -ve, +ve, -ve, +ve, -ve]
 */
 import java.util.*;

 public class RearrangeArrEl {
    static int[] brute (int[] arr) {
        int size = arr.length;
        ArrayList<Integer> posList = new ArrayList<Integer>();
        ArrayList<Integer> negList = new ArrayList<Integer>();
        // O(N)
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                // -ve no.
                negList.add(arr[i]);
            }
            else {
                // +ve no.
                posList.add(arr[i]);
            }
        }

        for (int i=0; i<size/2; i++) {
            // +ve numbers are at even indexes and -ve nos. are on odd indexes
            arr[2*i] = posList.get(i);
            arr[2*i + 1] = negList.get(i);
        }
        return arr;
    }

    static int[] optimal (int[] arr) {
        int size = arr.length;
        int[] ans = new int[size];
        int posIndex = 0, negIndex = 1; // stores the indices of next +ve and -ve position respectively
        for (int i=0; i<size; i++) {
            if (arr[i] < 0) {
                // -ve no.
                ans[negIndex] = arr[i];
                negIndex += 2;
            }
            else {
                // +ve no.
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }

        return ans;
    }
    static int[] variety2(int[] arr) {
        // when the no. of +ve and -ve elements are bot equal, the brute solution becomes the optimal and we will fallback to the same
        int size = arr.length;
        ArrayList<Integer> posList = new ArrayList<Integer>();
        ArrayList<Integer> negList = new ArrayList<Integer>();

        for (int i=0; i<size; i++) {
            if (arr[i] < 0) {
                // -ve no.
                negList.add(arr[i]);
            }
            else {
                // +ve no.
                posList.add(arr[i]);
            }
        }

        if (posList.size() > negList.size()) {
            for (int i=0; i<negList.size(); i++) {
              arr[2*i] = posList.get(i);
              arr[2*i + 1] = negList.get(i);
            }
            int index = 2*negList.size();
            for (int i=negList.size(); i<posList.size(); i++) {
                arr[index] = posList.get(i);
                index++;
            }
        }
        else {
            for (int i=0; i<posList.size(); i++) {
              arr[2*i] = posList.get(i);
              arr[2*i + 1] = negList.get(i);
            }
            int index = 2*posList.size();
            for (int i=posList.size(); i<negList.size(); i++) {
                arr[index] = negList.get(i);
                index++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        // int[] arr = {3,1,-2,-5,2,-4};
        // int[] ans = brute(arr);
        // int[] ans = optimal(arr);

        int[] arr2 = {-1,2,3,4,-3,1};
        int[] ans = variety2(arr2);
        for (int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
 }