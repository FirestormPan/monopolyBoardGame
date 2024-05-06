package dai.monopoly.board.properties;

import dai.monopoly.Player;
import dai.monopoly.board.Tile;

public abstract class Property extends Tile{

  private int price;
	private Player owner;

  public Property(){}

	public Property(String name, int position, int price) {
		super(name, position);
		this.price = price;
	}

	public void landingActions(Player rechiverOfActions) {
		//if (owned by other), pay rent
		//else if(not owned), ask player about buying it
		//else if(owned by me), build? idk we should check rules (if building requires landin on it, then move to buildables)
	}

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Player getOwner() {
    return owner;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

}
