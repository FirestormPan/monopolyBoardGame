package dai.monopoly;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dai.monopoly.board.Board;
import dai.monopoly.board.Tile;

public class GameManager {

	Queue<Player> activePlayers = new LinkedList<>();
	Board board;
	
	public GameManager(){
		Tile[] tiles = this.getTilesFromFile();
		this.board = new Board(tiles);
//		activePlayers.add(new Player("green"));
//		activePlayers.add(new Player("red"));
//		activePlayers.add(new Player("yellow"));
	}
		
	
	public void getTheGameRunningBre() {
		boolean conditionForEnd = false; 
		while( !conditionForEnd ) {
			//determine turn player
			Player turnPlayer = activePlayers.remove();
			//make actions for them (Here or on Board Class?)
			maketurnMovesFor(turnPlayer);			
			//if player didnt lose, put player back to queue
			// if( turnPlayer is in game)
			activePlayers.add(turnPlayer);
			conditionForEnd = activePlayers.size()>1;
		}
	}
	
	public void maketurnMovesFor(Player player) {
		//roll dice --> get out of jail, if jailed dont move etc
		int[] diceResults = rollDice();
		// check for jailed
//		if(player.isJailed()) { //TODO: make function on player
//		// TODO: kapws na blepoume kai an einai o tritos gyros tou, giati alliws bgainei(check the rukes on monopoly about getting out of jail)
//			player.setJailedStatus( diceResults[0] != diceResults[1] ); //TODO: make function on player
//			//TODO: what happens after you get out of Jail(with doubleRoll or paying)?
//		}
		board.movePlayerBy(player, (diceResults[0] + diceResults[1]) );                                          
		Tile landingTile;
		//do  landing actions
//		landingTile.landingActions(player);
		// if it was a double roll, play again
		if(diceResults[0] == diceResults[1]) { 
		//TODO: stis poses diples zaries pame fyllakh? na to baloume?
			maketurnMovesFor(player);
		}
	}
	
	public int[] rollDice() {
		return new int [] {
			(int) Math.ceil(Math.random() * 6), //Math.random doesn't return 0 ever, so we good
			(int) Math.ceil(Math.random() * 6)
		};
	}
	
	public Tile[] getTilesFromFile(){
		
		
		return null;
	}
	
}
 