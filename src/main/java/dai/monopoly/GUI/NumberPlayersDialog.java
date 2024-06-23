package dai.monopoly.Gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class NumberPlayersDialog extends JDialog{
	
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	private JPanel panel = new JPanel();
	int NumberOfPlayers = 0;
	HashMap<String, Integer> ColorHashMap = new HashMap<>();
	
	public NumberPlayersDialog(JFrame parent)
	{
		 super(parent, "How many players?", true);
		 
		 button2.setBackground(new Color(72,145,81));
		 button3.setBackground(new Color(72,145,81));
		 button4.setBackground(new Color(72,145,81));
		 
		 
		 
		 
		 
		 
		 panel.add(button2);
		 panel.add(button3);
		 panel.add(button4);
		 panel.setBackground(new Color(205, 230, 208));
		 
		 
		 this.add(panel);
	     this.setSize(300, 200);
	     this.setResizable(false);
	     this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	     
	     //The value 1 means that the color has not selected
	     ColorHashMap.put("Blue", 1);
	     ColorHashMap.put("Red", 1);
	     ColorHashMap.put("Yellow", 1);
	     ColorHashMap.put("Pink", 1);
	     
	   
	     
	     
	     //create 2 players
	     button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				NumberOfPlayers = 2;
				
				
		        
		        for(int i=0; i<NumberOfPlayers ; i++)
		        {
		        	CharacteristicDialog characteristicsDialog = new CharacteristicDialog(parent, NumberOfPlayers , ColorHashMap);
					
			        characteristicsDialog.setVisible(true);
		        }
				
		        
				
			}
	    	 
	     });
	     
	     //create 3 players
	     button3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					
					NumberOfPlayers = 3;
					
					
					
					 for(int i=0; i<NumberOfPlayers ; i++)
				        {
						 CharacteristicDialog characteristicsDialog = new CharacteristicDialog(parent, NumberOfPlayers, ColorHashMap);
							
					        characteristicsDialog.setVisible(true);
				        }
					
					
				}
		    	 
		     });
	     
	     //create 4 players
	     button4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					
					NumberOfPlayers = 4;
					
					
					
					 for(int i=0; i<NumberOfPlayers ; i++)
				        {
						 CharacteristicDialog characteristicsDialog = new CharacteristicDialog(parent, NumberOfPlayers, ColorHashMap);
							
					        characteristicsDialog.setVisible(true);
				        }
					
					
					
				}
		    	 
		     });
	     
	}
}
