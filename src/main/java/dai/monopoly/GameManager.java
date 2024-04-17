package dai.monopoly;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameManager {

	Queue<Player> activePlayers = new LinkedList<>();
	
	public GameManager(){
		activePlayers.add(new Player("green"));
		activePlayers.add(new Player("red"));
		activePlayers.add(new Player("yellow"));
	}
		
	
	public void getTheGameRunningBre() {
		boolean conditionForEnd = false; 
		while( !conditionForEnd ) {
			//determine turn player
			Player turnPlayer = activePlayers.remove();
			//make actions for them (Here or on Board Class?)
			maketurnMovesFor(turnPlayer);			
			//if player didnt lose, put player back to queue
			activePlayers.add(turnPlayer);
				
			
			conditionForEnd = activePlayers.size()>1;
		}
	}
	
	public void maketurnMovesFor(Player player) { //(Here or on Board Class?)
		//roll dice --> get out of jail, if jailed dont move etc
		rollDice();
		//move (Board)
		//do  landing actions
		// if it was a double roll, play again
	}
	
	public int[] rollDice() {
		return new int [] {
			(int) Math.ceil(Math.random() * 6), //Math.random doesn't return 0 ever, so we good
			(int) Math.ceil(Math.random() * 6)
		};
	}
	
}
 