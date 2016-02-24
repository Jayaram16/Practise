package com.java.practise;

public class Concatenation {
	public static void main(String[] args) {
		String mango = "mango";
		String s = "abc" + mango + "def" + 47;
		System.out.println(s);
	}
}
/**
 * Result when used javap
 */
/**C:\Users\Jayaram\workspace\test\bin\com\java\practise>javap -c Concatenation.class
Compiled from "Concatenation.java"
public class com.java.practise.Concatenation {
  public com.java.practise.Concatenation();
    Code:
       0: aload_0
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #16                 // String mango
       2: astore_1
       3: new           #18                 // class java/lang/StringBuilder
       6: dup
       7: ldc           #20                 // String abc
       9: invokespecial #22                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
      12: aload_1
      13: invokevirtual #25                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      16: ldc           #29                 // String def
      18: invokevirtual #25                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      21: bipush        47
      23: invokevirtual #31                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      26: invokevirtual #34                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      29: astore_2
      30: getstatic     #38                 // Field java/lang/System.out:Ljava/io/PrintStream;
      33: aload_2
      34: invokevirtual #44                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      37: return
}

C:\Users\Jayaram\workspace\test\bin\com\java\practise>*/



/*StringBuilder was introduced in Java SE5. 
 * Prior to this, Java used StringBuffer, which ensured thread safety (see the Concurrency chapter) and 
 * so was significantly more expensive. Thus, string operations in Java SE5/6 should be faster.  
 * */
 