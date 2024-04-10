package dai.monopoly;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class App {

  public static void main(String[] args) {
	  
	  //everything bellow here is examples for Queue (for the person that takes on that Class). You may delete them after understanding
		Queue<Player> activePlayers = new LinkedList<Player>(Arrays.asList( new Player("red"), new Player("green")));
		activePlayers.add(new Player("pink"));
		
        Player front = activePlayers.remove();
        System.out.println("Removed element: " + front.getColour());
        
		for(Player player :  activePlayers) {
			System.out.println( player.getColour() );			
		}
  }

}
