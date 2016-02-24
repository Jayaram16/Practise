package test;

public class ReplaceSpaces {

	public static void main(String[] args) {
		String abc = " ABC EF ";
		//System.out.println(abc.trim());
		System.out.println(replaceSpaces(abc,5));
	}

	public static String replaceSpaces(String inputString,int trueLength) {
		int newLength=(inputString.length()-trueLength)*3+trueLength;
		System.out.println(newLength);	
		char ar[]=new char[newLength];
		int counter=0;
		for(int i=0;i<inputString.length();i++){
			if(inputString.charAt(i)==' '){
				ar[counter++]='%';
				ar[counter++]='2';
				ar[counter++]='0';
			}
			else{
				ar[counter++]=inputString.charAt(i);
			}
		}
		return new String(ar);
	}
}
