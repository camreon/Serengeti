import java.awt.Rectangle;


/**
 * Herbivores are a type of Animal that can graze to heal
 * 
 * @author Cameron
 * @version 1.0 
 */
public abstract class Herbivore extends Animal {
	/**
	 * Constructor
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Herbivore(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age and overrides the parents move method to include grazing healing
	 */
	public void move() {
		if (health < 40)
			health += 20;
		super.move();
	}

}
