package iteration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No15552 {

	public static void main(String[] args) {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			Integer count = Integer.parseInt(bufferedReader.readLine());
			for (int i = 0; i < count; i++) {
				String line = bufferedReader.readLine();
				String[] splitLine = line.split(" ");
				Integer b = Integer.parseInt(splitLine[0]);
				System.out.println(b);
				Integer a = Integer.parseInt(splitLine[1]);
				System.out.println(a);
				Integer sum = a + b;
				bufferedWriter.write(sum.toString());
				if (i != count-1) {
					bufferedWriter.newLine();
				}
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
