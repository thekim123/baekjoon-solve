package iteration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No11021 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer count = null;
		try {
			count = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 1; i <= count; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				Integer sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
				bw.append("Case #"+i+": "+sum.toString()).append("\n");
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
