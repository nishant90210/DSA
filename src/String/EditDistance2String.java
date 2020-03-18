package String;

public class EditDistance2String {

	public static void main(String args[]) {
		String str1 = "horse";
		String str2 = "ros";
		System.out.println(editDist(str1, str2));
	}

	private static int editDist(String word1, String word2) {

		int[][] dp = new int[word2.length()+1][word1.length()+1];
		for(int i = 0; i <= word2.length(); i++){
			for (int j = 0; j <= word1.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0){
					dp[i][j] = i;
				}else if (word1.charAt(j-1) == word2.charAt(i-1)){
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1 + (Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]));
				}
			}
		}
		return dp[word2.length()][word1.length()];
	}
}
