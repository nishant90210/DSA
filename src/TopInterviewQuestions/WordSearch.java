package TopInterviewQuestions;

public class WordSearch {

    public static void main(String[] args) {

        String givenWord = "SEE";
        char board[ ][ ] = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean b = searchWordExistance(givenWord, board);
        System.out.println(b);
    }

    private static boolean searchWordExistance(String givenWord, char[][] board) {
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == givenWord.charAt(0) && walk(board, i, j, 0, givenWord)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean walk(char[][] board, int i, int j, int count, String givenWord) {

        if (count == givenWord.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != givenWord.charAt(count)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        boolean found =
                walk(board, i+1, j, count+1, givenWord) ||
                walk(board, i, j+1, count+1, givenWord) ||
                walk(board, i-1, j, count+1, givenWord) ||
                walk(board, i, j-1, count+1, givenWord);

        board[i][j] = temp;
        return found;
    }
}
