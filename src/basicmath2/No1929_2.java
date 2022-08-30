// 아래의 링크의 소스를 공부하고 기록한 소스입니다.
// https://www.acmicpc.net/source/44217074
// 백준 ID : dokuny 
// 좋은 소스를 공개해주셔서 감사합니다.
// 아래의 주석들은 제가 바로 이해하지 못하고 생각했던 것들을 기록한 것입니다.
package basicmath2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1929_2 {

	public static void main(String[] args) throws Exception {
		// 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		int number;
		int midNumber;

		boolean[] primeNumberArray = new boolean[10001];

		// 소수 배열 만들기
		primeNumberArray[0] = primeNumberArray[1] = true;
		for (int i = 2; i <= Math.sqrt(primeNumberArray.length - 1); i++) {
			if (primeNumberArray[i]) {
				continue;
			}
			
			// i*i 인 이유는 i의 전의 수들은 모두 배수로 제외되었기 때문
			for (int j = i * i; j < primeNumberArray.length; j += i) {
				primeNumberArray[j] = true;
			}
		}
		
		// 골든 바흐의 수 구하기
		for (int i = 0; i < count; i++) {
			number = Integer.parseInt(br.readLine());
			midNumber = number / 2;
			
			// 두 인덱스를 더하면 number가 됩니다.
			// number의 가운데 수(midNumber)에서 부터 시작하면 구성 수들의 차이가 최소인 값입니다.
			while (true) {
				if(!primeNumberArray[midNumber] && !primeNumberArray[number-midNumber]) {
					sb.append(midNumber).append(" ").append(number-midNumber).append("\n");
					break;
				}
				midNumber--;
			}
		}

		System.out.println(sb);
	}
}
