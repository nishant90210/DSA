package TopInterviewQuestions;

public class MinimumJumps {

    //Linear Approach
    public static void main(String[] args) {

//        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 2, 0, 1};
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.print("Minimum number of jumps to reach end is " + minJumps(arr));
    }

    private static int minJumps(int arr[])
    {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;


        // Start traversing array
        for (int i = 1; i < arr.length; i++)
        {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i+arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0)
            {
                //  we must have used a jump
                jump++;

                //Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if(i>=maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

    //Iterative
    private static int minJump(int[] arr) {

        if (arr.length <= 1){
            return 0;
        }
        if (arr[0] == 0){
            return 0;
        }
        int ladder = arr[0];
        int stairs = arr[0];
        int jump = 1;
        for(int level = 1; level < arr.length; level++){
            if (level == arr.length - 1){
                return jump;
            }
            if (level + arr[level] > ladder) {
                ladder = level + arr[level];
            }
            stairs--;
            if (stairs == 0){
                jump++;
                stairs = ladder - level;
            }
        }
        return jump;
    }

}
