import java.awt.*;


/**
 * Carnivores are a type of Animal 
 * 
 * @author Cameron
 * @version 1.0
 */
public abstract class Carnivore extends Animal {
	/**
	 * Constructor
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Carnivore(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age 
	 */
	public void move() {
		super.move();
	}
	
	/**
	 * Typically Carnivores can eat any Herbivores
	 * 
	 * @param other The Animal about to maybe be eaten
	 * @return Whether or not this Animal can eat the other
	 */
	public boolean canEatAnimal(Animal other) {
		if (other instanceof Herbivore)
			return true;
		return false;
	}
	
	/**
	 * Takes other Animal's health away and adds it to Animal doing the eating
	 * 
	 * @param other Animal being eaten 
	 */
	public void eatAnimal(Animal other) {
		health += other.health;
		other.health = 0;
	}

}
