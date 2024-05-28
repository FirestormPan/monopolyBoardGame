package dai.monopoly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
		boolean gameContinues = true;
		while( gameContinues) {
			//determine turn player
			Player turnPlayer = activePlayers.remove();
			//make actions for them
      makeTurnMovesFor(turnPlayer, 1);
			//if player didn't lose, put player back to queue
      if( turnPlayer.isInGame() ){
        activePlayers.add(turnPlayer);
      }
      gameContinues = activePlayers.size()>1;
		}
	}

  /**
   * Everything that needs to be done for the player in turn. Roll dice, move(if not Jailed), etc...
   * @param player player having his turn
   * @param consecutiveTimePlaying : how many times has the player played in a row(double rolls)? Useful for sending them in Jail after 3 double rolls
   */
	public void makeTurnMovesFor(Player player, int consecutiveTimePlaying) {
		int[] diceResults = rollDice();
    System.out.println("Player " + player.getColour() + " rolled :" + + diceResults[0] + " , " + diceResults[1]);
		// check for jailed
		if(player.isJailed()) {
      //ask player to pay for getting out of jail
      askPayToUnJail(player); //maybe replace with a function in Player class, that is always available to call from GUI
      //if they didn't pay to get out of Jail, roll dice for getting out
      if(player.isJailed()){
			 player.setIsPrisoned( diceResults[0] != diceResults[1] );
        if(player.isJailed()){ //if they are still jailed, it means the dice results are not the same, so end their turn
          return;
        }else{ //if they are the same results(and he got out of jail), play again because of the double roll
          System.out.println("Congratulations! You got out of Jail by double rolling");
          diceResults=rollDice(); //we just roll dice and continue the function, no need to call it again
          System.out.println("Player " + player.getColour() + " rolled : " + diceResults[0] + " , " + diceResults[1]);
        }
      }

		}

		Tile landingTile = Board.movePlayerBy(player, (diceResults[0] + diceResults[1]) );
    System.out.println("Player " + player + "landed on :" + landingTile.getName());
		//do  landing actions
		landingTile.landingActions(player);
		// if it was a double roll, play again
		if(diceResults[0] == diceResults[1]) {
      consecutiveTimePlaying++;
      if(consecutiveTimePlaying == 3){ //third time you roll doubles, go to Jail
        System.out.println("It was the third time you rolled doubles. GO TO JAIL");
        player.setIsPrisoned(true);
      }else{
        System.out.println("You rolled doubles! You play again!");
        makeTurnMovesFor(player, consecutiveTimePlaying);
      }
		}
	}

  public boolean askPayToUnJail(Player player){
    // ask in gui for paying
    Scanner unjailScanner = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Would you like to pay 100 to get out of jail? (Y(es) or N(o))");
    String playerAnswer = unjailScanner.nextLine();  // Read user input

    boolean playerWantsToPay = playerAnswer.equals("Y") || playerAnswer.equals("Yes"); //TODO: ask for changing from the console or GUI
    if(playerWantsToPay) {
      player.setIsPrisoned(false);
      player.changeBalanceBy(-100);
    }
    return playerWantsToPay;
  }

	public static int[] rollDice() {
		return new int [] {
			(int) Math.ceil(Math.random() * 6), //Math.random doesn't return 0 ever, so we good
			(int) Math.ceil(Math.random() * 6)
		};
	}

  /**
   * @return the list of the players who are partaking the game
   */
  private Queue<Player> insetPayers() {
    //get the insertion of players and create them
        activePlayers.add(new Player("green"));
    		activePlayers.add(new Player("red"));
    //		activePlayers.add(new Player("yellow"));
    return activePlayers;
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
