package dai.monopoly.board;


import java.util.Map;

import dai.monopoly.Player;
import lombok.Getter;

public class Board {
	private static Tile[] tiles; //might need being Arraylist?
	
	private Map<Player, Tile> playerPositions;
	
	/**
	 * Initializes the board
	 * @param orderedTiles is a list of the tiles in monopoly, from the Initial tile, all the way to the last
	 */
	public Board(Tile[] orderedTiles)  { //probably load the orderedTiles from a File OR create the table here based on Tile.position
		Board.tiles= orderedTiles;
	}

	public void movePlayerTo(Player playerToMove, Tile destination) { //or maybe destination is type int?
		throw new UnsupportedOperationException("Feature under development");
	}

}
