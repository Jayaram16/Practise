package test;

public class NLogN {

	public static void main(String[] args) {
		System.out.println(log(10));
	}

	private static int log(int n) {
		int result = 0;
		while (n > 1) {
         n /=2;
         result+=1;
		}
		return result;
	}

}
