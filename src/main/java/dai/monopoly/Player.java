package dai.monopoly;

import java.util.ArrayList;
import java.util.List;

import dai.monopoly.board.properties.Property;
import lombok.Getter;
import lombok.Setter;

public class Player {
  private int balance;
  @Getter
	private String colour;
  @Getter @Setter
	private int position;
  private List<Property> ownerships;
  private boolean isInGame;
	private boolean isPrisoned;

	public Player( String colour) {
		this.colour = colour;
		this.balance = 1500;
		this.position = 0;
		this.ownerships = new ArrayList();
		this.isPrisoned = false;
		this.isInGame = true;

	}

	public boolean jailStatus(int position ) {
		return (position == 10); // 10 is not permanent

	}

	public boolean playerStatus(int balance ) {
		return (balance > 0);

	}

	public int changeBalanceBy(int payment) {
		balance = balance + payment;
		playerStatus(balance);
		return balance;

	}
  public List<Property> getOwnerships() {
    return ownerships;
  }

  public void setOwnerships(List<Property> ownerships) {
    this.ownerships = ownerships;
  }


	public void payRentTo(Player landowner,int rent) {
    if(this.balance >= rent){
		  changeBalanceBy(-rent);
      landowner.changeBalanceBy(rent);
    }else{
      //TODO: ypo8hkes? lose instantly?
    }
	}

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
  public boolean setIsPrisoned(boolean prisoned) {
    isPrisoned = prisoned;
    if(prisoned){
      this.position=10;
    }
    return prisoned;
  }

  public boolean isJailed(){
    return this.isPrisoned;
  }

  public boolean isInGame() {
    return isInGame;
  }

  public void setInGame(boolean inGame) {
    isInGame = inGame;
  }

}
