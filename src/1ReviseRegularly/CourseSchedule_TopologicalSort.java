package TopInterviewQuestions;

import java.util.*;

public class CourseSchedule_TopologicalSort {

    public static void main(String[] args) {

//        int[][] prerequisites = {{1, 0}};

        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

        boolean b = canFinish(prerequisites, 4);
        System.out.println(b);
    }

    public static boolean canFinish(int[][] prerequisites, int numCourses) {
        int[] array = new int[numCourses];
        Queue<Integer> sister = new LinkedList<>();
        for(int[] pair : prerequisites) {
            array[pair[1]]++;
        }

        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                sister.add(i);
            }
        }

        while(!sister.isEmpty()) {

            numCourses--;
            Integer nikamma = sister.poll();
            for (int[] pair : prerequisites) {
                if(nikamma == pair[0]) {
                    array[pair[1]]--;
                    if(array[pair[1]] == 0) {
                        sister.add(pair[1]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}