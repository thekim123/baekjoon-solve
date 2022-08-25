package iteration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2439 {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			Integer count = Integer.parseInt(br.readLine());
			br.close();
			for (int i = 1; i <= count; i++) {
				for (int j = 1; j <=count; j++) {
					if(j<=count-i) {
						bw.append(" ");
					} else {
						bw.append("*");
					}
				}
				bw.append("\n");
			}
			bw.flush();
			bw.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
