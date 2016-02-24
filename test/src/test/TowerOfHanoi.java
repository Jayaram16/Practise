package test;

public class TowerOfHanoi {

	public static void main(String[] args) {
		//Scanner src = new Scanner(System.in);
		//int n = src.nextInt();
		callHanoi(3, "A", "B", "C");
		//src.close();
	}

	private static void callHanoi(int n, String source, String destination, String auxillary) {
		if (n == 1) {
			System.out.println(source + "-->" + destination);
		} else {
			callHanoi(n - 1, source, auxillary, destination);
			System.out.println(source + "-->" + destination);
			callHanoi(n - 1, auxillary, destination, source);
		}
	}

}
