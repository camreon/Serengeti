import java.awt.Rectangle;
import javax.swing.*;

/**
 * Zebras are herbivores and have a unique movement speed, life span, and eating habit
 * 
 * @author Cameron
 * @version 1.0
 */
public class Zebra extends Herbivore {
	/**
	 * Constructor that creates image to be painted
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Zebra(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
		
		image = new ImageIcon("zebra.png"); 
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age
	 */
	public void move() {
		health -= 1;
		age += 1;
		
		moveX = gen.nextInt(30) - 15;
		moveY = gen.nextInt(30) - 15;
		
		super.move();
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public boolean canReproduceWithAnimal(Animal other) {
		if (other instanceof Zebra)
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
		if (gen.nextInt(100) < 10) {
			Zebra baby = new Zebra(x, y, bounds);
			return baby;
		}
		
		return null;

	}

}
