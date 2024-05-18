package dai.monopoly.board;

import dai.monopoly.Player;

public class Tax extends Tile {

  int taxAmount;

  public Tax(){}

	public Tax(String name, int position) {
		super(name, position);
		// TODO Auto-generated constructor stub
	}

  public int getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(int taxAmount) {
    this.taxAmount = taxAmount;
  }

	@Override
	public void landingActions(Player reciverOfActions) {


	}

}
