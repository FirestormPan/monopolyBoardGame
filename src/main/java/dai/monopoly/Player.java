package dai.monopoly;

import java.util.ArrayList;
import java.util.List;

import dai.monopoly.board.Board;
import dai.monopoly.board.properties.Property;
import lombok.Getter;


public class Player {
	public Player(String colour) {
		super();
		this.colour = colour;
		this.balance = 5000; // h osa einai pou 3ekiname anyway
		this.ownerships = new ArrayList();
		this.isPrisoned = false;
	}

	@Getter
	private String colour;
	private int balance;
	private List<Property> ownerships; 
	private boolean isPrisoned; //?
	
	
	public int changeBalanceBy(int payment) {
		throw new UnsupportedOperationException("Feature under development");
	}

	public int payRentTo(Player landowner) {
		throw new UnsupportedOperationException("Feature under development");
	}

	public String getColour() {
		return this.colour;
	}
	
}
