package Programs;

import java.util.*;

public class LargestNumberByCombining {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        int[] arr = {3, 30, 34, 5, 9};
        for (int i = 0; i < arr.length; i++) {
            stringList.add(String.valueOf(arr[i]));
        }
        Collections.sort(stringList, new TestComparator());
        for (String i : stringList) {
            System.out.print(i);
        }
    }

    static class TestComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {

            String XY = o1 + o2;
            System.out.println("XY " + XY);
            String YX = o2 + o1;
            System.out.println("YX " + YX);
            int i = XY.compareTo(YX);
            System.out.println("printing compare value " + i);
            if (i > 0) {
                return -1;
            }else {
                return 1;
            }
        }
    }
}



