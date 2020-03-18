package TopInterviewQuestions;

public class MinimumJumps {

    //Linear Approach
    public static void main(String[] args) {

        int ar1[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arr[] = {2, 0, 3, 5, 0, 0, 3, 0, 0, 6, 3};
//        int arr[] = {2, 3, 1, 1, 4};
        System.out.print("Minimum number of jumps to reach end is " + minJump(arr));
    }

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
}
