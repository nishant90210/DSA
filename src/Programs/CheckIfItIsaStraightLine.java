package Programs;

public class CheckIfItIsaStraightLine {

    public static void main(String[] args) {

        // slope=(y2-y1)/(x2-x1)
        //Slope should be equal
        int[][] coordinates = {
                {1,1},
                {2,2},
                {3,4},
                {4,5},
                {5,6},
                {7,7}
        };
        boolean b = checkStraightLine(coordinates);
        System.out.println(b);
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        double gd = (double)(coordinates[0][1] - coordinates[1][1])/(coordinates[0][0] - coordinates[1][0]);
        for(int i=1; i<coordinates.length-1; i++){
            double t = (double)(coordinates[i][1] - coordinates[i+1][1])/(coordinates[i][0] - coordinates[i+1][0]);
            if(t!=gd) {
                return false;
            }
        }
        return true;
    }
}
