package Programs;

public class CountingBits {

    public static void main(String[] args) {

        int num = 14;
        int[] ints = countBits(num);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static int[] countBits(int num) {
        int result[] = new int[num + 1];
        int offset = 1;
        //When index doubles pffset will double
        for (int index = 1; index <= num; index++){
            if (index == offset * 2){
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }
}
