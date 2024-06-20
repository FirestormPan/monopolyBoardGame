package dai.monopoly.board.properties;

public class Buildable extends Property {
  public Buildable(){
  }

	public Buildable(String name, int position, int price) {
		super(name, position, price);
		// TODO Auto-generated constructor stub
	}
	private String colour;
  private int housesBuilt;
  private int hotelsBuilt;
  private int housePrice;
  private int hotelPrice;
  private int[] rentPricesPerHouse;

  public int getHousesBuilt() {
    return housesBuilt;
  }

  public void setHousesBuilt(int housesBuilt) {
    this.housesBuilt = housesBuilt;
  }

  public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public int getHotelsBuilt() {
    return hotelsBuilt;
  }

  public void setHotelsBuilt(int hotelsBuilt) {
    this.hotelsBuilt = hotelsBuilt;
  }

  public int getHousePrice() {
    return housePrice;
  }

  public void setHousePrice(int housePrice) {
    this.housePrice = housePrice;
  }

  public int getHotelPrice() {
    return hotelPrice;
  }

  public void setHotelPrice(int hotelPrice) {
    this.hotelPrice = hotelPrice;
  }

  public int[] getRentPricesPerHouse() {
    return rentPricesPerHouse;
  }

  public void setRentPricesPerHouse(int[] rentPricesPerHouse) {
    this.rentPricesPerHouse = rentPricesPerHouse;
  }


	public void buildHouse() {

    if( this.housesBuilt>4){
      System.out.println("can't build more than a hotel on a property");
      return;
    }

    System.out.println("Would you like to build a house/hotel?");
    boolean answer =true;
    if( answer ){
      if(this.housesBuilt<4){
        this.housesBuilt++;
        System.out.println("you built a house on " + this.getName());
      }else if(this.housesBuilt==4){
        this.housesBuilt++;
        System.out.println("you built a hotel on " + this.getName());
      }
    }
	}

  public int determineRent(){
    return rentPricesPerHouse[housesBuilt];
  }


}
