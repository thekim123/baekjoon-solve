package iteration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No10871 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine(), " ");
			Integer count = Integer.parseInt(st.nextToken());
			Integer stdNo = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			br.close();
			
			for (int i = 0; i < count; i++) {
				Integer num = Integer.parseInt(st.nextToken());
				if( num < stdNo) {
					bw.append(num+" ");
				}
			}
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
