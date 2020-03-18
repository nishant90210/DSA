package TopInterviewQuestions;

import java.util.*;

public class CourseSchedule_TopologicalSort {

    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}};

        boolean b = canFinish(prerequisites, 2);
        System.out.println(b);
    }

    public static boolean canFinish(int[][] prerequisites, int numCourses) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int[] pair : prerequisites) {
            indegree[pair[1]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            numCourses--;
            int course = queue.poll();
            for (int[] pair : prerequisites) {
                if (pair[0] == course) {
                    indegree[pair[1]]--;
                    if (indegree[pair[1]] == 0) {
                        queue.add(pair[1]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}