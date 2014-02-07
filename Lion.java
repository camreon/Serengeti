import javax.swing.ImageIcon;
import java.awt.*;

/**
 * Carnivore class
 * 
 * @author Cameron
 * @version 1.0
 */
public class Lion extends Carnivore {
	
	/**
	 * Constructor that uses parent method and creates image
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Lion(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
		
		image = new ImageIcon("lion.png"); 
	}
	
	/**
	 * Semi-randomly moves the animal while also decreasing health and 
	 * increasing age
	 */
	public void move() {
		health -= 1;
		age += 2;
		
		moveX = gen.nextInt(50) - 25;
		moveY = gen.nextInt(50) - 25;
		
		super.move();
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public boolean canReproduceWithAnimal(Animal other) {
		if (other instanceof Lion)
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
		if (gen.nextInt(100) < 60) {
			Lion baby = new Lion(x, y, bounds);
			return baby;
		}
		
		return null;
	
	}

}
