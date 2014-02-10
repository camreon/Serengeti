import java.awt.Rectangle;
import javax.swing.*;

/**
 * Lemmings is a Herbivore child class
 * 
 * @author Cameron
 * @version	1.0
 */
public class Lemmings extends Herbivore {
	/**
	 * Constructor that creates image to be painted
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Lemmings(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
		
		image = new ImageIcon(IMGPATH+"lemmings.png");
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age. Also Lemmings can only move in straight lines 
	 */
	public void move() {
		health -= 1;
		age += 1;
		
		if (gen.nextBoolean()) {
			moveX = gen.nextInt(16);
			moveY = 0;
		}
		else {
			moveX = gen.nextInt(16) - 16;
			moveY = 0;
		}
		
		super.move();
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public boolean canReproduceWithAnimal(Animal other) {
		return other instanceof Lemmings;
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * Lemmings also reproduce a lot
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public Animal reproduceWithAnimal(Animal other) {
		if (gen.nextInt(100) < 80) {
			return new Lemmings(x, y, bounds);
		}
		
		return null;
		
	}
}
