package iteration;

import java.util.Scanner;

public class No25304 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Receipt receipt = new Receipt();
		receipt.setPayment(scanner.nextInt());
		receipt.setCount(scanner.nextInt());
		
		int sum = 0;
		for (int i = 0; i < receipt.count; i++) {
			int productCount = scanner.nextInt();
			int productPrice = scanner.nextInt();
			sum+= productCount*productPrice;
		}

		if(sum == receipt.payment) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	public static class Receipt {
		private int count;
		private int payment;
		
		public Receipt() {
			
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getPayment() {
			return payment;
		}

		public void setPayment(int payment) {
			this.payment = payment;
		}
		
	}
	
}
