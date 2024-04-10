package dai.monopoly;

import java.util.LinkedList;
import java.util.Queue;

public class GameManager {

	Queue<Player> activePlayers = new LinkedList<>();
	
	public void getTheGameRunningBre() {
		boolean conditionForEnd = false; 
		while( !conditionForEnd ) {
			//determine turn player
			Player turnPlayer = activePlayers.remove();
			//make actions for them (Here or on Board Class?)
			maketurnMovesFor(turnPlayer);			
			//if player didnt lose, put player back to queue
			activePlayers.add(turnPlayer);
		}
	}
	
	public void maketurnMovesFor(Player player) { //(Here or on Board Class?)
		//roll dice --> get out of jail, if jailed dont move etc
		//move (Board)
		//do  landing actions
		// if it was a double roll, play again
	}
}
 