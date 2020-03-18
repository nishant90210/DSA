package TopInterviewQuestions;

import java.util.*;

public class LargestNumberByCombiningNumbers {

    public static void main(String[] args) {

        int[] arr = {3, 30, 34, 5, 9};
        largestNumber(arr);
    }

    private static String largestNumber(int[] arr) {

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            stringList.add(String.valueOf(arr[i]));
        }

        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {

                String XY = X + Y;
                String YX = Y + X;

                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator it = stringList.iterator();

        StringBuilder stringBuilder = new StringBuilder();
        while(it.hasNext()) {
            stringBuilder.append(it.next());
        }
        String str = String.valueOf(stringBuilder);
        double v = Double.parseDouble(str);
        if(v == 0){
            return "0";
        }
        return String.valueOf(stringBuilder);
    }
}
