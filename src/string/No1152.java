package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1152 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sentence = br.readLine();
		StringTokenizer st =  new StringTokenizer(sentence," ");
		
		int result = 0;
		
		while (st.hasMoreTokens()) {
			st.nextToken();
			result++;
		}
		
		System.out.println(result);
		
		
		
	}

}
