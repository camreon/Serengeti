import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Herbivores that move faster than other animals
 * 
 * @author Cameron
 * @version 1.0
 */
public class Gazelle extends Herbivore {
	/**
	 * Constructor that creates image to be painted
	 * 
	 * @param x Horizontal starting location
	 * @param y Vertical starting location
	 * @param bounds Area that all Animals must stay inside
	 */
	public Gazelle(int x, int y, Rectangle bounds) {
		super(x, y, bounds);
		
		image = new ImageIcon("gazelle.png"); 
	}
	
	/**
	 * Semi-randomly moves the animal really fast while also decreasing health and 
	 * increasing age
	 */
	public void move() {
		health -= 3;
		age += 1;
		
		moveX = gen.nextInt(70) - 35;
		moveY = gen.nextInt(70) - 35;
		
		super.move();
	}
	
	/**
	 * Reproduction rates are controlled to avoid over population
	 * 
	 * @param other The other animal being checked with
	 * @return New animal of same type in same location
	 */
	public boolean canReproduceWithAnimal(Animal other) {
		if (other instanceof Gazelle)
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
		if (gen.nextInt(100) < 50) {
			Gazelle baby = new Gazelle(x, y, bounds);
			return baby;
		}
		
		return null;
	}

}
