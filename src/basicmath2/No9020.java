package basicmath2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No9020 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer bw = new StringBuffer();

	public static void main(String[] args) throws Exception {
		int count = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[10001];
		ArrayList<Integer> primeNumberArr = getPrimeNumberArray(arr);
		for (int i = 0; i < count; i++) {
			int n = Integer.parseInt(br.readLine());
			getGoldenBachNumber(n, primeNumberArr);
		}
	}

	static ArrayList<Integer> getPrimeNumberArray(boolean[] arr) {

		for (int i = 2; i < arr.length; i++) {
			arr[i] = true;
		}

		for (int i = 2; i < Math.sqrt(10000); i++) {
			if (arr[i])
				for (int j = 2; i * j < arr.length; j++) {
					arr[i * j] = false;
				}
		}

		ArrayList<Integer> primeNumberArr = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				primeNumberArr.add(i);
			}
		}

		return primeNumberArr;
	}

	static void getGoldenBachNumber(int n, ArrayList<Integer> arr) throws Exception {
		int temp = 10000;
		int minus;
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("I : " + arr.get(i));
			if (arr.get(i) >= n) {
				break;
			}
			for (int j = i; j < arr.size(); j++) {
				System.out.println("J : " + arr.get(j));
				if (arr.get(j) >= n || arr.get(i) + arr.get(j) > n) {
					break;
				}
				minus = Math.abs(arr.get(j) - arr.get(i));
				if (arr.get(i) + arr.get(j) == n && temp > minus) {
					temp = minus;
					bw.delete(0, 12);
					bw.append(arr.get(i) + " " + arr.get(j));
				}
				System.out.println("----");
			}
		}
		System.out.println(bw.toString());
	}

}
