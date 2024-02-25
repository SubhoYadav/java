import java.util.ArrayList;

public class UnionOfTwoSortedArrays {

  static ArrayList<Integer> solve(int[] arr1, int[] arr2) {
    int n1= arr1.length;
    int n2 = arr2.length;
    int i=0, j=0;
    ArrayList<Integer> unionArr = new ArrayList<Integer>();

    while(i <n1 && j<n2) {
      if (arr1[i] <= arr2[j]) {
        if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr1[i]) {
          unionArr.add(arr1[i]);
        }
        i++;
      }
      else {
        if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr2[j]) {
          unionArr.add(arr2[j]);
        }
        j++;
      }
    }

    while(i < n1) {
      if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr1[i]) {
          unionArr.add(arr1[i]);
      }
      i++;
    }

    while(j < n2) {
      if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr2[j]) {
        unionArr.add(arr2[j]);
      }
      j++;
    }

    return unionArr;
  }
  public static void main(String args[]) {
    int arr1[] = {1,1,2,3,4,5};
    int arr2[] = {2,3,4,4,5,6};

    ArrayList<Integer> result = solve(arr1, arr2);
    System.out.println("Result = " + result);
  }
}
