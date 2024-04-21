package dai.monopoly.board;


import java.util.Map;

import dai.monopoly.Player;
import lombok.Getter;

public class Board {
	private Tile[] tiles; //might need being Arraylist?
	
	private Map<Player, Integer> playerPositions;
	
	/**
	 * Initializes the board with it's tiles. Gets called in Gamemaster
	 * @param orderedTiles is a list of the tiles in monopoly, from the Initial tile, all the way to the last
	 */
	public Board(Tile[] orderedTiles)  { //probably load the orderedTiles from a File OR create the table here based on Tile.position
		this.tiles= orderedTiles;
	}

	public void movePlayerTo(Player playerToMove, Tile destination) { //or maybe destination is type int?
		throw new UnsupportedOperationException("Feature under development");
	}
	

	/**
	 * Moves a player by "steps" amount of tiles. If they pass from the Start, they gain 200. 
	 * @param playerToMove 
	 * @param steps is the combined number of dice, therefore how much to move on board
	 * @return the tile on which the player ends their movement on
	 */
	public Tile movePlayerBy(Player playerToMove, int steps) { //or maybe destination is type int?	
		int oldPosition = playerPositions.get(playerToMove);
		int newPosition = (oldPosition  + steps)% tiles.length;
		boolean passedStart = newPosition < oldPosition;
		if(passedStart) {playerToMove.changeBalanceBy(200); } //an perasei apo thn afaithria pare 200
		
		return this.tiles[newPosition];
	}
}
