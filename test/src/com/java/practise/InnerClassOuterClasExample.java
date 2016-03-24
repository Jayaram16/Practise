package com.java.practise;

/**
 * for more details go to https://www.youtube.com/watch?v=Ns-MOqn6N04
 * http://tutorials.jenkov.com/java/nested-classes.html
 * http://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-
 * class
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
	int sameX = 15;

	void outerMethod() {
		System.out.println("outer value" + outerX);

	}

	class InnerClass {
		int innerX = 20;
		int sameX = 25;
		private int val = 220;

		/**
		 * Inner Class method's and variables can access outer class methods and
		 * variables even if they are private.
		 */
		void innerMethod() {
			System.out.println("innerX" + innerX);
			System.out.println("outer x value from inner class" + outerX);
			outerMethod();

			// The below approach is called Shadowing.
			System.out.println("SameX in inner " + sameX);
			System.out.println("SameX in inner " + OuterClass.this.sameX);
		}

	}
	/**
	 * Static Nested Class invocation Outer.Nested instance = new
	 * Outer.Nested();
	 * 
	 * 
	 * Frankly, static classes are a pretty worthless feature because classes
	 * are already divided into namespaces by packages. The only real
	 * conceivable reason to create a static class is that such a class has
	 * access to its containing class's private static members, but I find this
	 * to be a pretty lame justification for the static class feature to exist.
	 * 
	 * 
	 * pizza.Rhino.Goat
	 * 
	 * package pizza;
	 * 
	 * public class Rhino {
	 * 
	 * ...
	 * 
	 * public static class Goat { ... } }
	 */

	/**
	 * Local classes can only be accessed from inside the method or scope block
	 * in which they are defined.
	 * 
	 * Local classes can access members (fields and methods) of its enclosing
	 * class just like regular inner classes.
	 * 
	 * Local classes can also access local variables inside the same method or
	 * scope block, provided these variables are declared final.
	 * 
	 * From Java 8 local classes can also access local variables and parameters
	 * of the method the local class is declared in. The parameter will have to
	 * be declared final or be effectually final. Effectually final means that
	 * the variable is never changed after it is initialized. Method parameters
	 * are often effectually final.
	 * 
	 * Local classes can also be declared inside static methods. In that case
	 * the local class only has access to the static parts of the enclosing
	 * class. Local classes cannot contain all kinds of static declarations
	 * (constants are allowed - variables declared static final), because local
	 * classes are non-static in nature - even if declared inside a static
	 * method.
	 * 
	 * The same shadowing rules apply for local classes as for inner classes.
	 * 
	 * Eg:class Outer {
	 * 
	 * public void printText() {
	 * 
	 * class Local {
	 * 
	 * }
	 * 
	 * Local local = new Local(); }
	 * 
	 * }
	 */

	/**
	 * Anonymous Class is the one where the implementation of a given interface
	 * method is given on the fly.
	 */
	/**
	 * Advantages: Logical grouping of classes. Typically used within or only by
	 * the class. The inner class can be exposed to different entities using
	 * different access modifiers for the inner classes.Eg: CacheEntry and Cache
	 * class
	 */
}
