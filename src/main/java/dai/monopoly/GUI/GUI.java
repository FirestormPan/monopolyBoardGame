package dai.monopoly.Gui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame{
	
	private JButton PlayButton = new JButton("Play");
	private JButton HowtoPlayButton = new JButton("How To Play");
	private JButton GoBackButton = new JButton("Go Back");
	private JButton CloseButton = new JButton("Close");
	private JPanel StartPanel = new ImagePanel("MonopolyGame.jpg");
	private JPanel PlayPanel = new ImagePanel("MonopolyGameCloudy.png");
	private JPanel RulesPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout(); //help us to switch between panels
	private JTextArea RulestextArea = new JTextArea(); //text area to write the rules
	private NumberPlayersDialog HowManyPlayersDialog = new NumberPlayersDialog(this);
	private CharacteristicDialog PlayersCharactDialog;
	

	
	
	public GUI(){
		
		this.setTitle("Monopoly"); 
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    this.setSize(800,600); 
	    this.setVisible(true); 
	    this.setLayout(cardLayout);
	    this.add(StartPanel,"StartPanel");
        this.add(PlayPanel,"PlayPanel");
        this.add(RulesPanel,"RulesPanel");
        
                
        
	    StartPanel.add(PlayButton);
	    StartPanel.add(HowtoPlayButton);
	    PlayPanel.add(GoBackButton);
	    RulesPanel.setBackground(new Color(205, 230, 208));
	    RulesPanel.add(RulestextArea);
	    RulesPanel.add(CloseButton);
	    
	    
	    cardLayout.show(this.getContentPane(),"StartPanel");
	    
	    //edit the text area
	    RulestextArea.setBackground(new Color(205, 230, 208));
	    RulestextArea.setEditable(false);
	    RulestextArea.setText("hi how are you?");
	    
	    PlayButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Total charge is: ");//????????????
				
				cardLayout.show(getContentPane(),"PlayPanel");
				
				HowManyPlayersDialog.setVisible(true);
				
				
				
			}
	    
	     });
	    
	    
	    HowtoPlayButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Total charge is: ");//?????????????
				
				cardLayout.show(getContentPane(),"RulesPanel");
				
				
			}
	    
	     });
	    
	    GoBackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Total charge is: ");//?????????
				
				cardLayout.show(getContentPane(),"StartPanel");
				
				
			}
	    
	      });
	    
	    
	    CloseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Total charge is: ");//?????????
				
				cardLayout.show(getContentPane(),"StartPanel");
				
				
			}
	    
	      });
	    
	
	

}
    }
