package dai.monopoly.board.properties;

import dai.monopoly.Player;
import dai.monopoly.board.Tile;

import java.util.Scanner;

public abstract class Property extends Tile{

  private int price;
	private Player owner;

  public Property(){}

	public Property(String name, int position, int price) {
		super(name, position);
		this.price = price;
    this.owner = null;
	}

	public void landingActions(Player rechiverOfActions) {

    Scanner myScanner = new Scanner(System.in);  // Create a Scanner object

    if(owner == null){
      System.out.println("Would you like to buy the property " + this.getName() + " . Press y to buy"); //todo: delete after teh gui is implemented
      String decision = myScanner.nextLine();
      boolean playerWantsToBuy = decision.equals("y");
      if(playerWantsToBuy){
        if (rechiverOfActions.getBalance() > this.price){
          rechiverOfActions.changeBalanceBy(-price);
          this.setOwner(rechiverOfActions);
          rechiverOfActions.getOwnerships().add(this);
        }
      }
    }else if(owner == rechiverOfActions){
		  //else if(owned by me), build? idk we should check rules (if building requires landin on it, then move to buildables)
    }else{  //owned by another player
      rechiverOfActions.payRentTo(this.owner, this.determinRent());
    }

		//else if(not owned), ask player about buying it
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

  public abstract int determinRent();


}
