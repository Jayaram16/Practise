package com.java.practise;

import java.util.Formatter;

//: strings/Receipt.java import java.util.*;  
public class Receipt {
	private double total = 0;
	private Formatter f = new Formatter(System.out);

	public void printTitle() {
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}

	public void print(String name, int qty, double price) {
		f.format("%-15.15s %5d %10.2f\n", name, qty, price);
		total += price;
	}

	public void printTotal() {
		f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
		f.format("%-15s %5s %10s\n", "", "", "-----");
		f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
	}

	public static void main(String[] args) {
		Receipt receipt = new Receipt();
		receipt.printTitle();
		receipt.print("Jack’s Magic Beans", 4, 4.25);
		receipt.print("Princess Peas", 3, 5.1);
		receipt.print("Three Bears Porridge", 1, 14.29);
		receipt.printTotal();
	}
} /*For Strings, the precision specifies the maximum number of characters from the String to print
%[argument_index$][flags][width][.precision]conversion 
	 * Output: 
	 * 
Item              Qty      Price
----              ---      -----
Jack’s Magic Be     4       4.25
Princess Peas       3       5.10
Three Bears Por     1      14.29
Tax                         1.42
                           -----
Total                      25.06
*
*
*
*These are the conversions you’ll come across most frequently:  
      Conversion Characters  
      d     Integral (as decimal) 
      c     Unicode character 
      b     Boolean value 
      s     String 
      f     Floating point (as decimal) 
      e     Floating point (in scientific notation) 
      x     Integral (as hex) 
      h     Hash code (as hex) 
    %     Literal "%" 
Here’s an example that shows these conversions in action: 
*
*
*
*/