package Programs;

public class FindTheJudge {

    public static void main(String[] args) {

        int N = 3;
        int[][] trust = {{1,3},
//                {1,4},
                {2,3},
//                {2,4},
//                {4,3}
        };
        int[] result = new int[N+1];
        for (int[] i : trust) {
            result[i[0]]--;
            result[i[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == N-1){
                System.out.println(i + " is a celebrity");
                return;
            }
        }
        System.out.println("-1");
    }
}
