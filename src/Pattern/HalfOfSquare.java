package Pattern;

public class HalfOfSquare {

    public static void main(String[] args) {

        int n = 5;
        for(int j = 1; j <= n; j++){
            for(int i = n - j + 1; i >= 1; i--){
                System.out.print("#");
            }
            System.out.print("\n");
        }
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("#");
            }
            System.out.print("\n");
        }

    }
}
