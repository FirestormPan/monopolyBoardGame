package dai.monopoly.board;

import dai.monopoly.Player;
import dai.monopoly.board.models.BoardModel;
import dai.monopoly.board.properties.Buildable;
import dai.monopoly.board.properties.Company;
import dai.monopoly.board.properties.TrainProperty;
import lombok.Getter;

public class Board {

  private static final int SIZE_OF_BOARD = 36;


  @Getter
  private static final Tile[] tiles= new Tile[SIZE_OF_BOARD]; //is a list of the tiles in monopoly, from the Initial tile, all the way to the last

  /**
	 * Initializes the board with its tiles. Gets called in Gamemaster
	 * @param boardModel the model from which the tiles will be extracted
	 */
	public Board(BoardModel boardModel)  { //probably load the orderedTiles from a File OR create the table here based on Tile.position
		//corners
    tiles[boardModel.getPrison().getPosition()] =  boardModel.getPrison();
    tiles[boardModel.getStart().getPosition()] =boardModel.getStart();
    tiles[boardModel.getGoToJail().getPosition()] = boardModel.getGoToJail();
    tiles[boardModel.getFreeParking().getPosition()] = boardModel.getFreeParking();

    for(EntoliOrApofasi entoli : boardModel.getEntoles()){
       tiles[entoli.getPosition()] = entoli;
    }
    for (Buildable bProperty : boardModel.getProperties().getBuildables()){
      tiles[bProperty.getPosition()] = bProperty;
    }
    for (TrainProperty tProperty : boardModel.getProperties().getTrains() ){
      tiles[tProperty.getPosition()] = tProperty;
    }
    for (Company cProperty : boardModel.getProperties().getCompanies()){
      tiles[cProperty.getPosition()] = cProperty;
    }
    for (Tax tax : boardModel.getTaxes()){
      tiles[tax.getPosition()] = tax;
    }
	}

	public static void movePlayerTo(Player playerToMove, Tile destination) {
    int oldPosition = playerToMove.getPosition();
    int newPosition = destination.getPosition();
    playerToMove.setPosition(newPosition); //move the player

    boolean passedStart = newPosition < oldPosition;
    if(passedStart) {playerToMove.changeBalanceBy(200); } //an perasei apo thn afaithria pare 200
	}


	/**
	 * Moves a player by "steps" amount of tiles. If they pass from the Start, they gain 200.
	 * @param playerToMove :
	 * @param steps is the combined number of dice, therefore how much to move on board
	 * @return the tile on which the player ends their movement on
	 */
	public static Tile movePlayerBy(Player playerToMove, int steps) {
		int oldPosition = playerToMove.getPosition();
		int newPosition = (oldPosition  + steps)% tiles.length;
    playerToMove.setPosition(newPosition); //move the player

		boolean passedStart = newPosition < oldPosition;
		if(passedStart) {playerToMove.changeBalanceBy(200); } //an perasei apo thn afaithria pare 200

		return tiles[newPosition];
	}
}
