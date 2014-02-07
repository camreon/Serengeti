import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;

/**
 * This is the ControlPanel for the Serengeti. It allows the
 * user to pick which Animal it would like to add next.
 * 
 * @author Sundeep and Cameron
 * @version 1.0
 */
public class ControlPanel extends JPanel
{
	private static final long serialVersionUID = 1L; //
	
	private JButton zebra, gazelle, lion, dragon, lemmings, kangaroo;
	private JLabel current;
	
	private String animalType; //This whole thing would be more efficient using Reflection
								//but I didn't want to over-complicate things for you guys
	
	public ControlPanel()
	{
		setPreferredSize(new Dimension(150, SerengetiPanel.HEIGHT));
		
		zebra = new JButton("Zebra");
		zebra.addActionListener(new ButtonListener("Zebra"));
		add(zebra);
		
		gazelle = new JButton("Gazelle");
		gazelle.addActionListener(new ButtonListener("Gazelle"));
		add(gazelle);
		
		lion = new JButton("Lion");
		lion.addActionListener(new ButtonListener("Lion"));
		add(lion);
		
		dragon = new JButton("Dragon");
		dragon.addActionListener(new ButtonListener("Dragon"));
		add(dragon);
		
		lemmings = new JButton("Lemmings");
		lemmings.addActionListener(new ButtonListener("Lemmings"));
		add(lemmings);
		
		kangaroo = new JButton("Kangaroo");
		kangaroo.addActionListener(new ButtonListener("Kangaroo"));
		add(kangaroo);
		
		//default starting animal
		animalType = "Zebra";
		add(new JLabel("Current Animal"));
		current = new JLabel("Zebra");
		add(current);
		
		//implement timer speed control if you feel adventurous
	}
	
	/**
	 * Invoked by SerengetiPanel to determine which Animal
	 * was chosen
	 * 
	 * @return The currently selected Animal type 
	 */
	public String getAnimalType()
	{
		return animalType;
	}
	
	public class ButtonListener implements ActionListener
	{
		private String name;
		
		public ButtonListener(String className)
		{
			name = className;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			animalType = name;
			current.setText(name);
		}
	}
}
