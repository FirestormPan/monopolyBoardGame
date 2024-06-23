package dai.monopoly.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CharacteristicDialog extends JDialog{
	
	private JButton BlueButton = new JButton();
	private JButton RedButton = new JButton();
	private JButton YellowButton = new JButton();
	private JButton PinkButton = new JButton();
	private JButton NextButton = new JButton("next");
	private JTextField NameField = new JTextField(10);
	private JPanel panel = new JPanel();
	private JLabel NameLabel = new JLabel("name: ");
	private JLabel ColorLabel = new JLabel("color: ");
	private String selectedColor = "";
	private int numberOfPlayers;
	private HashMap<String, Integer> ColorHashMap;
	
	
	
	public CharacteristicDialog(JFrame parent, int numberOfPlayers , HashMap<String, Integer> ColorHashMap)
	{
		super(parent, "Player Characteristics", true);
		
		
		 this.numberOfPlayers = numberOfPlayers;
	     this.ColorHashMap = ColorHashMap;
		
		
		
		//Customize BlueButton
		BlueButton.setPreferredSize(new Dimension(20,20));
		BlueButton.setBackground(Color.blue);
		
		//Customize RebButton
		RedButton.setPreferredSize(new Dimension(20,20));
		RedButton.setBackground(Color.red);
		
		//Customize YellowButton
		YellowButton.setPreferredSize(new Dimension(20,20));
		YellowButton.setBackground(Color.yellow);
		
		//Customize PinkButton
		PinkButton.setPreferredSize(new Dimension(20,20));
		PinkButton.setBackground(Color.pink);
		
		
		
		panel.add(NameLabel);
		panel.add(NameField);
		panel.add(ColorLabel);
		panel.add(BlueButton);
		panel.add(RedButton);
		panel.add(YellowButton);
		panel.add(PinkButton);
		panel.add(NextButton);
		
	    this.add(panel);
	    this.setSize(250, 300);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    
	    
	    
	    //Disable buttons based on ColorHashMap
	    if(ColorHashMap.get("Blue") == 0)
		{
			BlueButton.setEnabled(false);
		}
	    
	    if(ColorHashMap.get("Red") == 0)
		{
			RedButton.setEnabled(false);
		}
	    
	    if(ColorHashMap.get("Yellow") == 0)
		{
			YellowButton.setEnabled(false);
		}
	    
	    if(ColorHashMap.get("Pink") == 0)
		{
			PinkButton.setEnabled(false);
		}
	  
	    
        
        
       
        
        
        BlueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				panel.setBackground(Color.BLUE);

				NextButton.setBackground(Color.BLUE);
				
				selectedColor = "Blue"; // keep the value of the color was clicked
				
				
				
				
				
			}
        	
        });
        
        
        RedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				panel.setBackground(Color.RED);
				
				NextButton.setBackground(Color.red);
				
				selectedColor = "Red"; // keep the value of the color was clicked
				
				
			}
        	
        });
        
        
        YellowButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				panel.setBackground(Color.YELLOW);
				
				NextButton.setBackground(Color.yellow);
				
				selectedColor = "Yellow"; // keep the value of the color was clicked
				
				
				
			}
        	
        });
        
        
        PinkButton.addActionListener(new ActionListener() {
        	
        	

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panel.setBackground(Color.PINK);
				
				NextButton.setBackground(Color.pink);
				
				selectedColor = "Pink"; // keep the value of the color was clicked
				
				
				
				
			}
        	
        });
        
        
        
        NextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				 if (!NameField.getText().isEmpty() && selectedColor != null) {
					 
					 
					    ColorHashMap.put(selectedColor, 0); // Update ColorHashMap
	                    dispose(); // Close the dialog if conditions are met
	                } 
				 
				 
				 
				
			}
        	
        });
      
       
        
        
	    
	}

}
