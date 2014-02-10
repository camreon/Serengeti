import java.awt.Rectangle;
import javax.swing.*;

/**
 * Kangaroo is a Herbivore child class
 * 
 * @author Cameron
 * @version 1.0
 */
public class Kangaroo extends Herbivore {
	/**
	 * Constructor that creates image to be painted
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Kangaroo(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
		
		image = new ImageIcon(IMGPATH+"kangaroo.png");
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age. Kangaroos also make big jumps sometimes because they're 
	 * kangaroos and can jump. 
	 */
	public void move() {
		health -= 1;
		age += 1;
		
		if (gen.nextBoolean()) {
			moveX = gen.nextInt(200) - 100;
			moveY = gen.nextInt(200) - 100;
		}
		else {
			moveX = gen.nextInt(16) - 8;
			moveY = gen.nextInt(16) - 8;
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
		return other instanceof Kangaroo;
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public Animal reproduceWithAnimal(Animal other) {
		if (gen.nextInt(100) < 30)
			return new Kangaroo(x, y, bounds);
		
		return null;
	}

}
