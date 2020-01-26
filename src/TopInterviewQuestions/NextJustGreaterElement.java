package TopInterviewQuestions;

import java.util.ArrayList;
import java.util.TreeSet;

public class NextJustGreaterElement {

    public static void main(String[] args)

    {
        int[] arr = {1, 4, 2, 9, 5, 3};
        closestGreater(arr);
    }

    public static void closestGreater(int[] arr)

    {
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

        for (int i=n-1; i>=0; i--)
            System.out.print(list.get(i) + " ");
    }
}
