package iteration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No10952 {

	public static void main(String[] args) {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		String formula = "";
		while (true) {
			try {
				formula = br.readLine();
				st = new StringTokenizer(formula, " ");
				Integer sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
				if (formula.equals("0 0")) {
					break;
				}
				bw.append(sum + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
