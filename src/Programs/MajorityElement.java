package Programs;

/**
 * Created by NISHANT on 4/5/18.
 */
// https://www.geeksforgeeks.org/majority-element/
public class MajorityElement {

    public static void main(String[] args)
    {
        int a[] = new int[]{2, 2, 3, 5, 2, 2, 6};
//        int a[] = new int[]{1, 3, 3, 1, 2};
        int size = a.length;
        int candidate = printMajority(a, size);
        if (isMajority(a, candidate, size)){
            System.out.println(" " + candidate + " ");
        }else {
            System.out.println("No Majority Element");
        }
    }

    private static boolean isMajority(int[] a, int candidate, int size) {

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == candidate){
                count++;
            }
        }
        if (count > (size/2)){
            return true;
        }
        return false;
    }

    private static int printMajority(int[] a, int size) {

        int maj_index = 0;
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (a[maj_index] == a[i]){
                count++;
            }else {
                count--;
            }
            if (count == 0){
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }
}
