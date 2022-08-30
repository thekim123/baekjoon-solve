package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2908 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String input1 = st.nextToken();
		String input2 = st.nextToken();

		for (int i = input1.length()-1; i >=0 ; i--) {
			sb.append(input1.charAt(i));
		}
		int convertNumber1 = Integer.parseInt(sb.toString());
		sb.delete(0, input1.length());
		for (int j = input2.length()-1; j >=0 ; j--) {
			sb.append(input2.charAt(j));
		}
		int convertNumber2 = Integer.parseInt(sb.toString());

		if(convertNumber1>=convertNumber2) {
			System.out.println(convertNumber1);
		}else {
			System.out.println(convertNumber2);
		}
	}

}
