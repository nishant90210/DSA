package TopInterviewQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {

        int count = 0;
        int fresh = 0;
//        int grid[][] = { {1, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 1, 0, 0, 0, 0, 1, 0}
//        };
        int grid[][] = { {2, 1, 1},
                         {0, 1, 1},
                         {1, 0, 1}
        };

        Queue<int[]> queue = new LinkedList();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        queue.add(new int[]{-1, -1});
        while (!queue.isEmpty() && fresh > 0){
            int[] poll = queue.poll();
            int X = poll[0];
            int Y = poll[1];
            if ((X == -1 || Y == -1) && queue.size() != 0){
                count++;
                queue.add(new int[]{-1, -1});
            }
            if (X > 0 && X != -1 && grid[X-1][Y] == 1){
                grid[X-1][Y] = 2;
                queue.add(new int[]{X-1, Y});
                fresh--;
            }
            if (Y > 0 && Y != -1 && grid[X][Y-1] == 1){
                grid[X][Y-1] = 2;
                queue.add(new int[]{X, Y-1});
                fresh--;
            }
            if (X < grid.length-1 && X != -1 && grid[X+1][Y] == 1){
                grid[X+1][Y] = 2;
                queue.add(new int[]{X+1, Y});
                fresh--;
            }
            if (Y < grid[0].length-1 && Y != -1 && grid[X][Y+1] == 1){
                grid[X][Y+1] = 2;
                queue.add(new int[]{X, Y+1});
                fresh--;
            }
        }
        System.out.println("Count -- " + count);
        System.out.println("Fresh -- " + fresh);
        System.out.println(fresh == 0 ? count : 0);
    }
}
