package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetterCount {

	public static void main(String[] args) throws IOException{
		String s;
		int non = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		for(int i=0 ; i<s.length() ; i++)
		{
			if(s.charAt(i) != 'n')
				continue;
			non++; 
		}
		System.out.println("Found " + non + " n's in the string.");
	}

}
