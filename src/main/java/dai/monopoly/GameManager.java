package dai.monopoly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

import dai.monopoly.board.Board;
import dai.monopoly.board.models.BoardModel;
import dai.monopoly.board.Tile;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class GameManager {

	Queue<Player> activePlayers = new LinkedList<>();
	Board board;

	public GameManager(){
		BoardModel tiles = this.getTilesFromFile();
		this.board = new Board(tiles);

    this.activePlayers = insetPayers();

    //generateGui(Board, activePlayers)
	}


  /**
   * Runs through a queue of players until there is only one player remaining in the game
   */
  public void getTheGameRunningBre() {
		boolean conditionForEnd = false;
		while( !conditionForEnd ) {
			//determine turn player
			Player turnPlayer = activePlayers.remove();
			//make actions for them
      makeTurnMovesFor(turnPlayer, 1);
			//if player didnt lose, put player back to queue
      if( turnPlayer.isInGame() ){
        activePlayers.add(turnPlayer);
      }
			conditionForEnd = activePlayers.size()>1;
		}
	}

	public void makeTurnMovesFor(Player player, int consecutiveTimePlaying) {
		//roll dice --> get out of jail, if jailed don't move etc
		int[] diceResults = rollDice();
		// check for jailed
		if(player.isJailed()) {
//		// TODO: kapws na blepoume kai an einai o tritos gyros tou, giati alliws bgainei?(check the rules on monopoly about getting out of jail)
			boolean gotOutOfJail = player.setIsPrisoned( diceResults[0] != diceResults[1] );
      if(!gotOutOfJail){
        //TODO: offer the player the option to pay and get out. When does the player get to choose about this?
      }
//			//TODO: what happens after you get out of Jail(with doubleRoll or paying)?
		}

		Tile landingTile = board.movePlayerBy(player, (diceResults[0] + diceResults[1]) );;
		//do  landing actions
		landingTile.landingActions(player);
		// if it was a double roll, play again
		if(diceResults[0] == diceResults[1]) {
      consecutiveTimePlaying++;
      if(consecutiveTimePlaying == 3){ //third time you roll doubles, go to Jail
        player.setIsPrisoned(true);
      }else{
        makeTurnMovesFor(player, consecutiveTimePlaying);
      }
		}
	}

	public int[] rollDice() {
		return new int [] {
			(int) Math.ceil(Math.random() * 6), //Math.random doesn't return 0 ever, so we good
			(int) Math.ceil(Math.random() * 6)
		};
	}


  private Queue<Player> insetPayers() {
    //get the insertion of players and create them

    //    activePlayers.add(new Player("green"));
    //		activePlayers.add(new Player("red"));
    //		activePlayers.add(new Player("yellow"));
    return null;
  }


  public BoardModel getTilesFromFile(){
    BoardModel tiles = null;
    try{
      File tilesFile = new File("C:\\Users\\pante\\eclipse-workspace\\monopoly\\src\\main\\resources\\tiles.yaml");
      FileInputStream inputStream = new FileInputStream(tilesFile);

      LoaderOptions loaderOptions = new LoaderOptions();
      Yaml yaml = new Yaml(new Constructor(BoardModel.class, loaderOptions));
      tiles = yaml.load(inputStream);

    }catch (FileNotFoundException e){
      throw new RuntimeException(e);
    }
    return tiles;
	}

}
