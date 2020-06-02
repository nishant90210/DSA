package Programs;

public class ConvertFive {

    public static void main(String[] args) {

        convertfive(1004);
    }

    static int convertfive(int num) {
        if(num == 0){
            return 5;
        }
        int res = num;
        int added = 5;
        while (num > 0) {
            if (num % 10 == 0) {
                res += added;
            }
            added *= 10;
            num = num / 10;
        }
        return res;
    }
}
