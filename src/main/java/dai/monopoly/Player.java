package dai.monopoly;

import java.util.ArrayList;
import java.util.List;

import dai.monopoly.board.properties.Property;
import lombok.Getter;
import lombok.Setter;

public class Player {
  private int balance; // needs value from GUI
  private String name; // added name, needs value from GUI
	private String colour;
  @Getter @Setter
	private int position;
  private List<Property> ownerships;
  private boolean isInGame;
	private boolean isPrisoned;

	public Player(int id, int position) {
		this.colour = colour; 
    this.name = name; 
		this.balance = 1500; // updated value from 400 to 1500
		this.position = position;
		this.ownerships = new ArrayList();
		this.isPrisoned = jailStatus(this.position);
		this.isInGame = playerStatus(this.balance);

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
    	
    	//changeBalanceBy(-rent);
      //landowner.changeBalanceBy(rent);
    	//is changing the balance needed?
    	
      landowner.isInGame = false; // player losses immediately if they are out of money since we did't add a sell property option.
      System.out.println("Out of Money"); // completed the else statement 
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
