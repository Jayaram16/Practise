package test;

public class StringAnagram {

	public static void main(String[] args) {
	String s="abc";
	String t="cab";
	isAnagram(s, t);
	}
	public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
         return false;   
        }
        
        boolean[] tBoolean=new boolean[t.length()];
        char[] sArray=s.toCharArray();
        char[] tArray=t.toCharArray();
        for(char a:sArray){
            for(int i=0;i<tArray.length;i++){
                if(tArray[i]==a)
                	if(!tBoolean[i]){
                    tBoolean[i]=true;
                    break;
                }
            }
        }
        for(Boolean b:tBoolean){
            if(!b){
                return false;
            }
        }
        return true;
    }
	
	 public boolean isAnagram2(String s, String t) {
	        if(s.length()!=t.length()){
	         return false;   
	        }
	        int []alphabet=new int[26];
	        for(int i=0;i<s.length();i++){
	            alphabet[s.charAt(i)-'a']++;
	            alphabet[t.charAt(i)-'a']--;
	        }
	        for(int i=0;i<alphabet.length;i++){
	            if(alphabet[i]!=0){
	                return false;
	            }
	        }
	        return true;
	    }
}
