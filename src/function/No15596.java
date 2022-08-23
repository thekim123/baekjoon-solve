package function;

public class No15596 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3,4,5};
		int result = sum(arr);
		System.out.println(result);
	}
	
	
	public static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

}
