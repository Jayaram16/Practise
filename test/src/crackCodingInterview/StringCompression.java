package crackCodingInterview;

public class StringCompression {
	// Question could be: Should it be to the same String or not?
	// Currently Solving using 2 different Strings.
	public static void main(String[] args) {
		String abc = "aabbbbbbbcccccccccdeeeeeaas";
		String abc2 = "abcdeas";
		System.out.println(performStringCompression(abc2));
	}

	public static String performStringCompression(String input) {
		StringBuilder outputString=new StringBuilder();
		int count=1;
		char ch=input.charAt(0);
		for(int i=1;i<input.length();i++){
			if(ch==input.charAt(i)){
				++count;
			}else{
				outputString.append(ch);
				outputString.append(count);
				ch=input.charAt(i);
				count=1;
			}
		}
		outputString.append(ch);
		outputString.append(count);
		if(outputString.length()>=input.length()){
			return input;
		}
		else{
			//return outputString.toString();
			return String.valueOf(outputString);
		}
	}

}
