package iteration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No11022 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			Integer count = Integer.parseInt(br.readLine());
			Integer numberA;
			Integer numberB;
			Integer sum;
			
			StringTokenizer st;
			for (int i = 1; i <= count; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				numberA = Integer.parseInt(st.nextToken());
				numberB = Integer.parseInt(st.nextToken());
				
				sum = numberA+numberB;
				bw.append("Case #"+i+": "+numberA+" + "+ numberB+" = "+ sum).append("\n");
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
