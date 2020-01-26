package Matrix;

import Programs.AreaOfHistogram;

public class MaximumSizeRectangle {

    public static void main(String[] args) {

        int maxArea = 0;
        int area = 0;
        int[][] mat = { {0, 1, 1, 0},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0},
                      };
        int[] temp = new int[mat[0].length];
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if (i == 0){
                    temp[j] = mat[i][j];
                }else {
                    if (mat[i][j] == 1){
                        temp[j] = mat[i-1][j] + 1;
                    }else {
                        temp[j] = mat[i][j];
                    }
                }
            }
            if (area > maxArea){
                maxArea = area;
            }
            area = AreaOfHistogram.calculateAreaOfHistogram(temp, temp.length);
        }

        System.out.println("Maximum size of rectangle is :- " + maxArea);
    }
}
