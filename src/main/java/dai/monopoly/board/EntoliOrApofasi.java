package dai.monopoly.board;
import dai.monopoly.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class EntoliOrApofasi extends Tile {

  public EntoliOrApofasi(){}

  List<Consumer<Player>> functionList = Arrays.asList(
    this::goToStart,
    this::advanceToPlace,
    this::advanceToPlace,
    this::advanceToNearestCompany,
    this::advanceToNearestRailway,
    this::bankPays50
    );

	public EntoliOrApofasi(String name, int position) {
		super(name, position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landingActions(Player rechiverOfActions) {
		// TODO Auto-generated method stub

	}
  public void goToStart(Player player){}
  public void advanceToPlace(Player player){}
  public void advanceToNearestCompany(Player player){}
  public void advanceToNearestRailway(Player player){}
  public void bankPays50(Player player){}



}
