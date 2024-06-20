package dai.monopoly.board;
import dai.monopoly.GameManager;
import dai.monopoly.Player;
import dai.monopoly.board.properties.Buildable;
import dai.monopoly.board.properties.Company;
import dai.monopoly.board.properties.TrainProperty;

import java.util.*;
import java.util.function.Consumer;


public class Entoli extends Tile {

  public Entoli(){}

  private static final Queue<Consumer<Player>> entoliList;

  static {
    List<Consumer<Player>> tempList = Arrays.asList(
      Entoli::goToStart,
      Entoli::advanceToPlace, //TODO
      Entoli::advanceToPlace,//TODO
      Entoli::advanceToNearestCompany,
      Entoli::advanceToNearestRailway,
      Entoli::bankPays50,
      Entoli::goBack3,
      Entoli::goJail,
      Entoli::advanceToPlace, //TODO
      Entoli::advanceToPlace, //TODO boardwak
      Entoli::get150,
      Entoli::poorTax15,
      Entoli::roadRepairs,
      Entoli::payAllPlayers50
    );

    Collections.shuffle(tempList);  // Shuffle the list
    entoliList = new LinkedList<>(tempList);
  }

	public Entoli(String name, int position) {
		super(name, position);
	}

	@Override
	public void landingActions(Player rechiverOfActions) {
    Consumer<Player> currentCard = entoliList.remove();
    currentCard.accept(rechiverOfActions);
	}

  public static void goToStart(Player player){
    String text = "Move to start. Get 200.";
    Tile landingTile = Board.movePlayerTo(player, Board.getTiles()[0]);
    landingTile.landingActions(player);
  }
  public static void advanceToPlace(Player player){}
  public static void advanceToNearestCompany(Player player){
    Tile tileToMoveOn = Board.findClosestTileOfSubClass(player.getPosition(), Company.class);
    Board.movePlayerTo(player, tileToMoveOn);
    tileToMoveOn.landingActions(player);
  }
  public static void advanceToNearestRailway(Player player){
    Tile tileToMoveOn = Board.findClosestTileOfSubClass(player.getPosition(), TrainProperty.class);
    Board.movePlayerTo(player, tileToMoveOn);
    tileToMoveOn.landingActions(player);
  }
  public static void bankPays50(Player player){
    player.changeBalanceBy(50);
  }
  public static void poorTax15(Player player){
    player.changeBalanceBy(-15);
  }
  public static void goBack3(Player player){
    Tile tileToMoveOn = Board.movePlayerBy(player, -3);
    tileToMoveOn.landingActions(player);
  }

  public static void goJail(Player player){
    Board.movePlayerTo(player, Board.getTiles()[10]);
    player.setIsPrisoned(true);
  }

  public static void roadRepairs(Player player){
    int total_payment = 0;
    for(Tile tile : Board.getTiles()){
      if(tile instanceof Buildable){
        total_payment+= ((Buildable) tile).getHousesBuilt() <5 ? ((Buildable) tile).getHousesBuilt() * 25 : 100;
        player.payToBank(total_payment);
      }
    }
  }
  public static void payAllPlayers50(Player player){
    for (Player activePlayer : GameManager.getActivePlayers()) {
      if (activePlayer != player) {
        player.payRentTo(activePlayer, 50);
      }

    }
  }  public static void get150(Player player){
    player.changeBalanceBy(150);
  }


}
