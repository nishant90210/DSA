package TopInterviewQuestions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by NISHANT on 3/16/18.
 */
public class ParenthesisMatcher {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String inputSentence = "(I want (to write a language parser), would (you) help me)";
        int openingBraceNum = 2;
        int res = closingBracePosition(inputSentence, openingBraceNum);
        System.out.println(res);

    }

    static class ParenthesisObj{
        char parenthesis;
        int position;
    }

    static int closingBracePosition(String inputSentence, int openingBraceNum) {
        Stack<ParenthesisObj> stack = new Stack<>();
        int countPar = 1;
        int x = -1;
        for(int i = 0; i < inputSentence.length(); i++){
            if(inputSentence.charAt(i)=='('){
                ParenthesisObj parenthesisObj = new ParenthesisObj();
                parenthesisObj.parenthesis = '(';
                parenthesisObj.position = countPar;
                stack.push(parenthesisObj);
                countPar++;
            }
            else if(inputSentence.charAt(i)==')'){
                if(stack.empty()){
                    return -1;
                }
                ParenthesisObj pop = stack.pop();
                if(pop.position == openingBraceNum){
                    x = i;
                }
            }
        }
        if(!stack.empty()) {
            return -1;
        }
//        if(x > -1){
//            x = x + 1;
//        }
        return x;
    }
}
