package dai.monopoly.board;
import dai.monopoly.Player;

public abstract class Tile {
	String name;
	int position;
		
	
	public Tile(String name, int position) {
		this.name = name;
		this.position = position;
	}
	
	abstract public void landingActions(Player rechiverOfActions);
	
	
}
