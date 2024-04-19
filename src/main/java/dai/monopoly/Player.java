package dai.monopoly;

import java.util.ArrayList;
import java.util.List;

import dai.monopoly.board.properties.Property;

public class Player {
	private int balance;
	private String colour;
	private int position;
	private List<Property> ownerships;
	private boolean isInGame;
	private boolean isPrisoned;

	public Player(int id, int position) {
		this.colour = colour;
		this.balance = 400; 
		this.position = position;
		this.ownerships = new ArrayList();
		this.isPrisoned = jailStatus(this.position);
		this.isInGame = playerStatus(this.balance);
		
	}
	
	public boolean jailStatus(int position ) {
		return (position == 10); // 10 is not permanent
			
	}
	
	public boolean playerStatus(int balance ) {
		return (balance > 0); 
			
	}
	
	public int changeBalanceBy(int payment) {
		balance = balance + payment;
		playerStatus(balance);
		return balance;
	}
	
	public void payRentTo(Player landowner,int rent) {
		landowner.balance = landowner.balance + rent;
		changeBalanceBy(rent);
		
	}
	

}
