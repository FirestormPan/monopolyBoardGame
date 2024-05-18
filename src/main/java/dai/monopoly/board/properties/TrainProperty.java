package dai.monopoly.board.properties;

import dai.monopoly.Player;

public class TrainProperty extends Property {

  private final int[] rentPricesPerStation = new int[] {25,50,100,200};
  public  TrainProperty(){ }

	public TrainProperty(String name, int position, int price) {
		super(name, position, price);
		// TODO Auto-generated constructor stub
	}

  public int determinRent() {
    Player ownerOfStation = this.getOwner();
    int tottalStationsOwnedByOwner = (int) ownerOfStation.getOwnerships().stream().filter(TrainProperty.class::isInstance).count();
    int rentPrice = rentPricesPerStation[tottalStationsOwnedByOwner];
    return rentPrice;
  }
}
