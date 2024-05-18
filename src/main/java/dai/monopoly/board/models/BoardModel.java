package dai.monopoly.board.models;


import dai.monopoly.board.*;

import java.util.List;

public class BoardModel {
  private PropertiesModel properties;
  private List<EntoliOrApofasi> entoles;
  private List<Tax> taxes;
  private Start start;
  private Jail prison;
  private FreeParking freeParking;
  private GoJailTile goToJail;


  public BoardModel() {
  }

  public List<Tax> getTaxes() {
    return taxes;
  }

  public void setTaxes(List<Tax> taxes) {
    this.taxes = taxes;
  }
  public List<EntoliOrApofasi> getEntoles() {
    return entoles;
  }

  public void setEntoles(List<EntoliOrApofasi> entoles) {
    this.entoles = entoles;
  }

  public PropertiesModel getProperties() {
    return properties;
  }

  public void setProperties(PropertiesModel properties) {
    this.properties = properties;
  }
  public GoJailTile getGoToJail() {
    return goToJail;
  }

  public void setGoToJail(GoJailTile goToJail) {
    this.goToJail = goToJail;
  }

  public FreeParking getFreeParking() {
    return freeParking;
  }

  public void setFreeParking(FreeParking freeParking) {
    this.freeParking = freeParking;
  }

  public Start getStart() {
    return start;
  }

  public void setStart(Start start) {
    this.start = start;
  }

  public Jail getPrison() {
    return prison;
  }

  public void setPrison(Jail prison) {
    this.prison = prison;
  }
}


