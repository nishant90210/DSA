package Programs;

public class ValidParenthesisString {

    public static void main(String[] args) {
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        int cmin = 0, cmax = 0; // open parentheses count in range [cmin, cmax]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++; // if `*` become `(` then openCount++
                cmin--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }
            if (cmax < 0) {
                System.out.println("false"); // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            }
            // For example: ())(
            cmin = Math.max(cmin, 0); // It's invalid if open parentheses count < 0 that's why cmin can't be negative
        }
        if(cmin == 0){
            System.out.println("true"); // Return true if can found `openCount == 0` in range [cmin, cmax]
        }
    }
}
