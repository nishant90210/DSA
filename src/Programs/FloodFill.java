package Programs;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image = {
                {0,0,0},
                {1,1,0},
                {0,0,0}
        };

        int sr = 1, sc = 1, newColor = 2;
        int[][] ints = floodFill(image, sr, sc, newColor);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image[sr][sc] == newColor){
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void dfs(int[][] image, int i, int j, int color, int newColor) {

        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color){
            return;
        }
        image[i][j] = newColor;
        dfs(image, i + 1, j, color, newColor);
        dfs(image, i, j + 1, color, newColor);
        dfs(image, i - 1, j, color, newColor);
        dfs(image, i, j - 1, color, newColor);
    }
}
