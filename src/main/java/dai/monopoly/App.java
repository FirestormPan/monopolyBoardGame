package dai.monopoly;

import dai.monopoly.board.Tile;

public class App {

  public static void main(String[] args) {

    GameManager gm = new GameManager();
    for (Tile tile: gm.board.getTiles()){
      if (tile != null){
       System.out.println("Tile "+ tile.getPosition() + ": " + tile.getName());
      }
    }
	  gm.getTheGameRunningBre();

  }
}
