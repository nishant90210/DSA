package Stack;

import java.util.Stack;

/**
 * Created by NISHANT on 9/11/17.
 */
public class NextGreaterElement {

    public static void main(String args[])
    {
        int arr[]= {11, 13, 21, 3};
        int n = arr.length;
        printNGEUsingStack(arr, n);
    }

    private static void printNGE(int[] arr, int n) {

        int i,j;
        for (i = 0; i < arr.length; i++) {
            int next = -1;
            for (j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[i]){
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " ---- " + next);
        }
    }

    /* prints element and NGE pair for
       all elements of arr[] of size n */
    static void printNGEUsingStack(int arr[], int n)
    {
        int i = 0;
        java.util.Stack<Integer> s = new Stack();
        int element, next;

        /* push the first element to stack */
        s.push(arr[0]);

        // iterate for rest of the elements
        for (i = 1; i < n; i++)
        {
            next = arr[i];

            if (s.isEmpty() == false)
            {

                // if stack is not empty, then
                // pop an element from stack
                element = s.pop();

                /* If the popped element is smaller than
                   next, then a) print the pair b) keep
                   popping while elements are smaller and
                   stack is not empty */
                while (element < next)
                {
                    System.out.println(element + " -- " + next);
                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }

                /* If element is greater than next, then
                   push the element back */
                if (element > next)
                    s.push(element);
            }

            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }

        /* After iterating over the loop, the remaining
           elements in stack do not have the next greater
           element, so print -1 for them */
        while (s.isEmpty() == false)
        {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

}
