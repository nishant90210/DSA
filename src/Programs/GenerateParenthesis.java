package Programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

    public static void main(String[] args) {

//        Set set = generateParentheses(3);
//        for (Object o : set) {
//            System.out.println(o.toString());
//        }
        List<String> strings = generateParenthesesRecursive(2);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //Recusive Approach
    public static List<String> generateParenthesesRecursive(int numPairs) {
        List<String> result = new ArrayList<>();
        backtrack(result,"", 0,0, numPairs);
        return result;
    }

    private static void backtrack(List<String> result, String currentString, int open, int close, int max) {

        if (currentString.length() == max * 2){
            result.add(currentString);
            return;
        }
        if (open < max){
            backtrack(result, currentString + "(", open+1, close, max);
        }
        if (close < open){
            backtrack(result, currentString + ")", open, close+1, max);
        }
    }

    private static void directedGenerateBalancedParentheses(int numLeftParensNeeded, int numRightParensNeeded,
                                                            String parenStringInProgress, List<String> result) {
    /*
      The recursion has bottomed out.
      We have used all left and right parens necessary within constraints up
      to this point. Therefore, the answer we add will be a valid paren string.

      We can add this answer and then backtrack so the previous call can exhaust
      more possibilities and express more answers...and then return to its caller,
      etc. etc.
      Yeah...this is what backtracking is all about.
    */
        if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
            result.add(parenStringInProgress);
            return;
        }

    /*
      At each frame of the recursion we have 2 things we can do:
      1.) Insert a left parenthesis
      2.) Insert a right parenthesis
      These represent all of the possibilities of paths we can take from this
      respective call. The path that we can take all depends on the state coming
      into this call.
    */

    /*
      Can we insert a left parenthesis? Only if we have lefts remaining to insert
      at this point in the recursion
    */
        if (numLeftParensNeeded > 0) {
      /*
        numLeftParensNeeded - 1 ->       We are using a left paren
        numRightParensNeeded ->          We did not use a right paren
        parenStringInProgress + "(" ->   We append a left paren to the string in progress
        result ->                        Just pass the result list along for the next call to use
      */
            directedGenerateBalancedParentheses(
                    numLeftParensNeeded - 1,
                    numRightParensNeeded,
                    parenStringInProgress + "(",
                    result
            );
        }

    /*
      Can we insert a right parenthesis? Only if the number of left parens needed
      is less than then number of right parens needed.

      This means that there are open left parenthesis to close OTHERWISE WE CANNOT
      USE A RIGHT TO CLOSE ANYTHING. We would lose balance.
    */
        if (numLeftParensNeeded < numRightParensNeeded) {
      /*
        numLeftParensNeeded ->           We did not use a left paren
        numRightParensNeeded - 1 ->      We used a right paren
        parenStringInProgress + ")" ->   We append a right paren to the string in progress
        result ->                        Just pass the result list along for the next call to use
      */
            directedGenerateBalancedParentheses(
                    numLeftParensNeeded,
                    numRightParensNeeded - 1,
                    parenStringInProgress + ")",
                    result
            );
        }
    }

    public static Set generateParentheses(int n) {
        Set solutions = new HashSet();

        //Case n=0 generates the empty set.
        if(n > 0) {
            //Case n=1, which adds the first solution.
            solutions.add("()");
        }

        //This loop start with n=2
        for(int i=2; i<=n; i++) {
            Set newSolutions = new HashSet();
            //Loop through the combinations obtained in the previous step
            for(Object previousSolution : solutions) {
                newSolutions.add("()" + previousSolution);
                newSolutions.add("(" + previousSolution + ")");
                newSolutions.add(previousSolution + "()");
            }
            solutions = newSolutions;
        }
        return solutions;
    }
}
