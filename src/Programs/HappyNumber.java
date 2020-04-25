package Programs;

public class HappyNumber {

    public static void main(String[] args) {

        int num = 19;
        happy(num);
    }

    private static void happy(int num) {
        int restNum= 0;
        int mod = 0;
        int sum = 0;
        happyRec(num, sum, mod, restNum);
    }

    private static void happyRec(int num, int sum, int mod, int restNum) {

        while (num >= 10){
            mod = num % 10;
            sum += mod * mod;
            num = num / 10;
            restNum = num;
        }
        sum += restNum * restNum;
        if (sum == 1){
            System.out.println("HAPPY");;
        }else {
            happyRec(sum, 0, 0, 0);
        }
    }
}
