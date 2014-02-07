import java.awt.Rectangle;

import javax.swing.ImageIcon;


/**
 * Carnivores that can eat any type of Animal except other Dragons, never die of 
 * old age, and reproduce infrequently
 * 
 * @author Cameron
 * @version 1.0
 */
public class Dragon extends Carnivore {
	/**
	 * Constructor that creates image to be painted
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Dragon(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
		
		image = new ImageIcon("dragon.png"); 
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age
	 */
	public void move() {
		health -= 1;
		
		moveX = gen.nextInt(22) - 11;
		moveY = gen.nextInt(22) - 11;
		
		super.move();
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public boolean canReproduceWithAnimal(Animal other) { 
		if (other instanceof Dragon)
			return true;
		return false;
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public Animal reproduceWithAnimal(Animal other) {
		if (gen.nextInt(100) < 5) {
			Dragon baby = new Dragon(x, y, bounds);
			return baby;
		}
		
		return null;
	}
	
	/**
	 * Overriding method so that Dragons can eat any other class
	 * 
	 * @param other The Animal about to maybe be eaten
	 * @return Whether or not this Animal can eat the other
	 */
	public boolean canEatAnimal(Animal other) {
		if (!(other instanceof Dragon))
			return true;
		return false;
	}
}
