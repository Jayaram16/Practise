package test;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class StringManipulation {

	public static void main(String[] args) throws UnsupportedEncodingException {

		Scanner src=new Scanner(System.in);
        String inputString=src.next();
        for (byte a:inputString.getBytes("US-ASCII"))
        System.out.printf("%2s",a-64+"");  
        src.close();
        
        String name = "admin";
        int ascii = name.toCharArray()[0];
        System.out.println("\n"+ascii);
	}

}
