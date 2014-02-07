import java.util.Random;
import java.awt.*;
import javax.swing.*;

/**
 * Top most class in the hierarchy of the plains
 * 
 * @author Cameron Guthrie
 * @version 1.0, 4/1/2012
 */
public abstract class Animal {
	
	Random gen = new Random();
	
	protected int x = gen.nextInt(500) + 50;
	protected int y = gen.nextInt(500) + 50;
	protected int moveX, moveY;

	protected Rectangle bounds;
	protected Rectangle location;
	
	protected int health = 300;
	protected int age = 0;
	
	protected ImageIcon image; 
	
	/**
	 * Constructor that sets instance variables and the Animal's location
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Animal(int x, int y, Rectangle bounds) {
		this.x = x;
		this.y = y;
		this.bounds = bounds; 
		this.location = new Rectangle(x, y, 50, 50);
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age. Also updates location
	 */
	public void move() {
		x += moveX;
		y += moveY;
		
		location = new Rectangle(x, y, 50, 50);
	}
	
	/**
	 * Draws the animal at its location
	 * 
	 * @param g Graphics page object
	 */
	public void draw(Graphics g) {
		image.paintIcon(null, g, x, y);
	}
	
	/**
	 * Determined by Animal location and image's dimensions
	 * 
	 * @param other The other animal being checked with
	 * @return Whether or not one Animal collides with the other
	 */
	public boolean collidesWithAnimal(Animal other) {
		if (location.intersects(other.location))
			return true;
		return false;
	}
	
	/**
	 * Reproduction only only done by same class Animals
	 * 
	 * @param other The other animal being checked with
	 * @return Whether the two animals are the same class
	 */
	public abstract boolean canReproduceWithAnimal(Animal other);
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public abstract Animal reproduceWithAnimal(Animal other);
	
	/**
	 * If an Animal is over 90 then it is old and will die
	 * 
	 * @return Whether or not Animal has passed max age 
	 */
	public boolean isOld() {
		if (age > 90) 
			return true;
		return false;
	}
	
	/**
	 * Called when Animal dies
	 */
	public void die() {
		health = 0; 
	}
	
	/**
	 * Checks if Animal has health
	 * 
	 * @return Whether or not the animal is dead
	 */
	public boolean isDead() {
		if (health <= 0)
			return true;
		return false;
	}
	
}
