package crackCodingInterview;

/**
 * Write a program to swap odd and even bits in an integer with as few
 * instructions as possible (e.g., bit 0 and bit! are swapped, bit 2 and bit 3
 * are swapped, and so on).
 */
public class SwapOddEvenBits {

	public static void main(String[] args) {
		int num = 15;
		String numInBinary = getBinaryValue(num);
		System.out.println(numInBinary);
		System.out.println(getBinaryValue(swapOddEvenBits(num)));
		System.out.println("Using efficient ways ");
		System.out.println(String.format("%016d",new Integer(Integer.toString(num,2))));
		//sizeof(int);
		/**
		Similarly you can use Integer.toString(num,8);Integer.toString(num,16);
		*/
		
		System.out.println(Integer.toBinaryString(num));
	}

	public static boolean getBit(int num, int i) {
		if ((num & (1 << i)) == 0) {
			return false;
		}
		return true;
	}

	/**
	 * This is not the most efficient way to get binary numbers
	 * 
	 * 
	 * @param num
	 * @return
	 */
	public static String getBinaryValue(int num) {
		boolean flag[] = new boolean[16];
		for (int i = 1; i <= 16; i++) {
			flag[i - 1] = getBit(num, i - 1);
		}
		StringBuilder br = new StringBuilder();
		for (int i = 16; i > 0; i--) {
			if (flag[i - 1]) {
				br.append(1);
			} else
				br.append(0);
		}
		return (br.toString());
	}

	public static int swapOddEvenBits(int x) {
		return (((x & 0xAAAAAAAA) >> 1) | ((x & 0x55555555) << 1));
	}
}
