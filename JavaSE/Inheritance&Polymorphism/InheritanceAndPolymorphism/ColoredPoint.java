package InheritanceAndPolymorphism;

import java.awt.Color;

public class ColoredPoint extends Point {

	private Color color; // the colour

	/** Create a new ColoredPoint with coordinates (0,0)
	 *  and given color.
	 */
	public ColoredPoint(Color color) {
		//if the parents class dont have default constructor
		//the children class's constructor must using "super" notation
		//as the first statement in the children constructor
		super(0,0);
		this.color = color;
	}

	//this statement refers to the constructor above
	public ColoredPoint() {
		this(Color.BLACK);
	}
	
	/** The color of this ColoredPoint. */
	public Color color() {
		return color;
	}

	public String toString () {
		return "ColoredPoint: x = " + x + 
				"; y = " + y + "; color = " + color;
	}
}

