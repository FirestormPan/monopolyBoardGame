package dai.monopoly.board;
import dai.monopoly.Player;

public abstract class Tile {
	String name;
	int position;

  public Tile() {}

  public Tile(String name, int position) {
      this.name = name;
      this.position = position;
    }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

	abstract public void landingActions(Player rechiverOfActions);


}
