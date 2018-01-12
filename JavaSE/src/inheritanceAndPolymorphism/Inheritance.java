package inheritanceAndPolymorphism;

import java.awt.Color;

public class Inheritance {

	public static void main(String [ ] args) {
		// class extension
		ColoredPoint cp = new ColoredPoint(Color.RED);
		cp.setX(10);
		//System.out.println(cp);

		//constructors and extension
		Point pcp = new ColoredPoint();
		//System.out.println(pcp);


		// method overloading
		Child c = new Child();
//		c.report();
//		c.report(2);
//		c.report("abc");
//		c.report(cp);  // most specific method chosen
//		c.report(pcp); // method based on declared type of parameter
//

		/**
		 * Polymorphism
		 * Will looking for the declared type's overloading method first
		 * then looking for the overriding method according to actual type.
		 */
		// method overriding
		Parent p = new Parent();
		Parent pc = new Child();
//		p.myName();
//		c.myName();
//		pc.myName();  // method based on actual type of object
//		c.myParent();
		
		// for illustrating overriding resolution
		p.report("abc");
		c.report("abc");
		pc.report("abc");
		
		p.report(cp);
		System.out.println("1111");
		c.report(cp);
		pc.report(cp);
		System.out.println("1111");

		
		p.report(pcp);
		pc.report(pcp);

		//in this situation, it would trying to find the report method
		//in the child class. and it would trying to looking for the
		//"Declared type" of "pcp". Thus, it would see PCP as an object
		// instead of an color point
		c.report(pcp);//output is Child, object arg
	}

}
