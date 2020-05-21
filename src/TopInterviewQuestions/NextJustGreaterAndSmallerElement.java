package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.TreeSet;

public class NextJustGreaterAndSmallerElement {

    public static void main(String[] args)

    {
        int[] arr = {1, 4, 2, 9, 5, 3};
        //2 5 3 -1 -1 -1
        closestGreater(arr);
        int[] arr1 = {4, 8, 5, 2, 25};
        System.out.println();
        closestSmallest(arr1);
    }

    private static void closestSmallest(int[] arr) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        for (int i = arr.length-1; i >= 0; i--){
            if (treeSet.floor(arr[i]) == null){
                list.add(-1);
            }else {
                list.add(treeSet.floor(arr[i]));
            }
            treeSet.add(arr[i]);
        }
        for (int i=arr.length-1; i>=0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }


    public static void closestGreater(int[] arr) {

        int n = arr.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = n - 1; i >= 0; i--) {
            Integer greater = treeSet.ceiling(arr[i]);
            if (greater == null) {
                list.add(-1);
            }
            else {
                list.add(greater);
            }
            treeSet.add(arr[i]);
        }

        for (int i=n-1; i>=0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
