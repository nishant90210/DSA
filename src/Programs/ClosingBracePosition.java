package Programs;

import java.util.Stack;

/**
 * Created by NISHANT on 6/26/18.
 */
public class ClosingBracePosition {

    public static void main(String[] args) {

    }

    static int closingBracePosition(String inputSentence, int openingBraceNum) {
        int count = 0;
        int i;
        char[] charArray = inputSentence.toCharArray();
        for (i = 0; i < charArray.length; i++) {
            if (')' == charArray[i]){
                return -1;
            } else if ('(' == charArray[i]){
                count++;
                if (count == openingBraceNum){
                    continue;
                }
            }else if (')' == charArray[i]){
                break;
            }
        }
        return i;
    }


//    /*
// * Complete the closingBracePosition function below.
// */
//    static class ParenthesisObj{
//        char parenthesis;
//        int position;
//    }
//    static int closingBracePosition(String inputSentence, int openingBraceNum) {
//        /*
//         * Write your code here.
//         */
//        Stack<ParenthesisObj> stack = new Stack<>();
//        int countPar = 1;
//        int x = -1;
//        for(int i=0;i<inputSentence.length();i++){
//            if(inputSentence.charAt(i)=='('){
//                ParenthesisObj parenthesisObj = new ParenthesisObj();
//                parenthesisObj.parenthesis = '(';
//                parenthesisObj.position = countPar;
//                stack.push(parenthesisObj);
//                countPar++;
//            }
//            else if(inputSentence.charAt(i)==')'){
//                if(stack.empty()){
//                    return -1;
//                }
//                ParenthesisObj pop = stack.pop();
//                if(pop.position == openingBraceNum){
//                    x = i;
//                }
//            }
//        }
//        if(!stack.empty()) {
//            return -1;
//        }
//        if(x>-1){
//            x = x+1;
//        }
//        return x;
//    }


}
