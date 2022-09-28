package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2751 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[Integer.parseInt(br.readLine())];
		int[] counting = new int[1000001];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < arr.length; i++) {
			counting[arr[i]]++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			
		}
		
	}
}
