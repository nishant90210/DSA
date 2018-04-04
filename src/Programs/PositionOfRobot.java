package Programs;

/**
 * Created by NISHANT on 3/26/18.
 */
// https://www.geeksforgeeks.org/position-of-robot-after-given-movements/
public class PositionOfRobot {

    public static void main(String[] args) {

        String input = "UDDLLRUUUDUURUDDUULLDRRRR";
        Integer leftSide =0;
        Integer rightSide =0;
        char[] chars = input.toCharArray();
        for (char c : chars) {
            switch (c){
                case 'U':
                    rightSide += 1;
                    break;
                case 'D':
                    rightSide -= 1;
                    break;
                case 'L':
                    leftSide -= 1;
                    break;
                case 'R':
                    leftSide += 1;
                    break;
            }
        }
        System.out.println("( " + leftSide + " ," + rightSide + ")");
    }
}
