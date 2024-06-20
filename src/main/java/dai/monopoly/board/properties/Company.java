package dai.monopoly.board.properties;

import dai.monopoly.GameManager;
import dai.monopoly.Player;

public class Company extends Property {

  private final int[] multiplierPerCompanyOwned= new int[] {4,10};

  public Company(){}

	public Company(String name, int position, int price) {
		super(name, position, price);
	}

  public int determineRent() {
    Player ownerOfCompany = this.getOwner();
    int totalCompaniesOwnedByOwner = (int) ownerOfCompany.getOwnerships().stream().filter(Company.class::isInstance).count();

    int[] diceroll = GameManager.rollDice();
    int rentPrice = (diceroll[0] + diceroll[1]) * multiplierPerCompanyOwned[totalCompaniesOwnedByOwner];
    return rentPrice;
  }
}

