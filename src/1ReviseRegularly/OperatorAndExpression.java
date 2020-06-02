package TopInterviewQuestions;

import java.util.LinkedList;
import java.util.List;

public class OperatorAndExpression {

    public static void main(String[] args) {

        List<String> stringList = addOperators("125", 7);
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public static List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        backtrack(num.toCharArray(), res, "", 0, target, 0);
        return res;
    }

    private static void backtrack(char[] nums, List<String> res, String str, int pos, int rem, int prevNum) {

        if (rem == prevNum){
            res.add(str);
            return;
        }
        int val = 0;
        for (int i = pos; i < nums.length; i++) {
            val = val*10 + nums[i]-'0';
            if (pos == 0) {
                backtrack(nums, res, "" + val, i + 1, rem, val);
            }else {
                backtrack(nums, res, str+"+"+val, i + 1, rem-prevNum, val);
                backtrack(nums, res, str+"-"+val, i + 1, rem-prevNum, -val);
                backtrack(nums, res, str+"*"+val, i + 1, rem,prevNum*val);
            }
        }
    }
}
