package TopInterviewQuestions;

public class MinimumJumps {

    public static int minJumps = Integer.MAX_VALUE;
    //Linear Approach
    public static void main(String[] args) {

//        int ar1[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arr[] = {2, 0, 3, 5, 0, 0, 3, 0, 0, 6, 3};
//        int arr[] = {2, 3, 1, 1, 4};
        System.out.print("Minimum number of jumps to reach end is " + minJump(arr));
        minJumpRecursive(arr);
    }

//    public static int minJump(int[] a) {
//        /*three variable as discussed in the editorial*/
//        int maxReachable = 0;
//        int jumps = 0;
//        int currReachable = 0;
//        /*exploring every index in the given array */
//        for (int currIdx = 0; currIdx < a.length; currIdx++) {
//
//            /*updating max reachable index every time we visit a new index*/
//            maxReachable = Math.max(maxReachable, currIdx + a[currIdx]);
//
//            /* as we have already considered the max jump length at this
//             * index and if max reachable index is still equal to or
//             * less than current index, then we can move forward from
//             * this index therefore answer is not possible in this case*/
//            if (maxReachable <= currIdx) {
//                return -1;
//            }
//
//            /*if current index is equal to the current reachable, increment jumps required and update current reachable*/
//            if (currIdx == currReachable) {
//                jumps++;
//                currReachable = maxReachable;
//            }
//        }
//        return jumps;
//    }

    private static int minJump(int[] arr) {

        //Aggar 1 se kum element ho
        if (arr.length <= 1){
            return 0;
        }
        //Aggar 1st element 0 ho to no jump
        if (arr[0] == 0){
            return 0;
        }
        //Jitni ladder utni stairs hongi
        int ladder = arr[0], stairs = arr[0];
        int jumps = 1;

        //Looping through the array from 1 kyuki arr[0] to ladder aur stairs mein already de diya hai
        for(int index = 1; index < arr.length; index++){

            //Aggar last tak pahuch jaye to wahi se return ho jao
            if (index == arr.length - 1){
                return jumps;
            }
            //Aggar agla element aur uska index, ladder se jyada ho to ladder replace kardo, kyuki lambi jump le sakenge
            if (index + arr[index] > ladder){
                ladder = index + arr[index];
            }
            //Uske baad stairs ko kum karenge taki aggar ladder khatam ho jaye to jump karne ka pata chal jaye kyuki ladder khatam hone ke baad jump LENI hi padegi
            stairs--;
            //Aggar stairs khatam ho gai to jump leni hi padegi
            if (stairs == 0){
                //Aggar stairs khatam ho jaye to jump leni padegi
                jumps++;
                //Aur uske baad stairs bhi update karenge
                stairs = ladder - index;
            }
        }
        return jumps;
    }

    private static void minJumpRecursive(int[] arr) {

        solve(0, arr, 0);

        if(minJumps == (int) 1e9 + 1)
        {
            /*if the min jumps is still infinity, this means it has
             * never been updated that is, we did not reach the end
             * index even once, hence answer is not possible in this
             * case*/
            System.out.println("Not Possible");
        }
        else {
            System.out.println(minJumps);
        }
    }

    public static void solve(int currIdx, int[] a, int jumps) {
        /* base case : Case 1 - if current index is equal to last
         * index (destination) update the global min jumps if the
         * current number of jumps is lesser and return.
         * Case 2 - if current index is greater than the last index,
         * simply return because this is not the result we are looking for*/
        if (currIdx >= a.length - 1) {
            if (currIdx == a.length - 1) {
                minJumps = Math.min(minJumps, jumps);
            }
            return;
        }
        /*maximum length of any jump that can be made from this index*/
        int reachableIdxs = a[currIdx];
        if (reachableIdxs == 0){
            return;
        }

        /* recursive calls for all lengths of jump varying from 1 to max
         * length and incrementing number of jumps by 1 in every call */
        for (int jumpLength = 1; jumpLength <= reachableIdxs; jumpLength++) {
            solve(currIdx + jumpLength, a, jumps + 1);
        }
    }
}
