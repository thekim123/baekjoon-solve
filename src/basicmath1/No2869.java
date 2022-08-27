package basicmath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2869 {

	public static void main(String[] args) throws NumberFormatException, IOException {

//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		System.out.println(String.format("%.0f",Math.ceil((double)(v-b)/(a-b))));
			// a*(d)-b(d-1) >=v        
			// d>=v-b/a-b
	}

}
