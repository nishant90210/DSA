package Programs;

public class ProductofArrayExceptSelf {

    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4};
        int n = input.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] output = new int[n];

        productWithSpace(input, n, leftProduct, rightProduct, output);
        productWithOutSpace(input, n, output);
    }

    private static void productWithOutSpace(int[] input, int n, int[] output) {

        output[0] = 1;
        for(int i = 1; i < n; i++){
            output[i] = input[i-1] * output[i-1];
        }
        //output = [1, 1, 2, 6]
        int temp = 1;
        for(int i = n-1; i >= 0; i--){
            output[i] = output[i] * temp;
            temp = temp * input[i];
        }

        for (int i : output) {
            System.out.print(i + " ");
        }
    }


    private static void productWithSpace(int[] input, int n, int[] leftProduct, int[] rightProduct, int[] output) {
        leftProduct[0] = 1;
        for(int i = 1; i < n; i++){
            leftProduct[i] = input[i-1] * leftProduct[i-1];
        }

        rightProduct[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            rightProduct[i] = input[i+1] * rightProduct[i+1];
        }

        for (int i = 0; i < n; i++){
            output[i] = leftProduct[i] * rightProduct[i];
        }

        for (int i : output) {
            System.out.print(i + " ");
        }
    }
}
