package com.java.practise;
/*
 * for more details go to https://www.youtube.com/watch?v=Ns-MOqn6N04
 * 
 */

public class InnerClassOuterClasExample {

	public static void main(String[] args) {
		OuterClass outerClassObj = new OuterClass();
		outerClassObj.outerMethod();

		// If inner class methods and objects need to be accessed then use the
		// outer to access inner object
		OuterClass.InnerClass innerObj = outerClassObj.new InnerClass();
		innerObj.innerMethod();
	}

}

class OuterClass {
	int outerX = 10;

	void outerMethod() {
		System.out.println("outer value" + outerX);

	}

	class InnerClass {
		int innerX = 20;

		/**
		 * Inner Class method's and variables can access outer class methods and
		 * variables.
		 */
		void innerMethod() {
			System.out.println("innerX" + innerX);
			System.out.println("outer x value from inner class" + outerX);
			outerMethod();
		}

	}
}
