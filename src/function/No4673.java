package function;

public class No4673 {
	
	public static void main(String[] args) {
		
		int[] arr = new int[10050];
		int selfNumber;
		
		for (int i = 0; i < 10000; i++) {
			selfNumber = getNotSelfNumber(i);
			arr[selfNumber] = 1;
		}
		
		for (int i = 0; i < 10000; i++) {
			if(arr[i] == 0) {
				System.out.println(i);
			}
		}
	}
	
	public static int getNotSelfNumber(int n) {
		int result = n;
		int initNumber = n;
		int multipleFactor = 10;
		int temp;
		
		for (int i = 0; ; i++) {
			temp = initNumber%multipleFactor;
			
			result += temp;
			
			initNumber -= temp;
			initNumber /= 10;
			
			if(initNumber==0) {
				return result;
			}
		}
	}
	
	

}
