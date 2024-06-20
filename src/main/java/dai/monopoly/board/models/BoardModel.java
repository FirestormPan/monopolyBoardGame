package dai.monopoly.board.models;


import dai.monopoly.board.*;
import dai.monopoly.board.properties.Apofasi;

import java.util.List;

public class BoardModel {
  private PropertiesModel properties;
  private List<Entoli> entoles;
  private List<Apofasi> apofaseis;
  private List<Tax> taxes;
  private Start start;
  private Jail prison;
  private FreeParking freeParking;
  private GoJailTile goToJail;


  public BoardModel() {
  }


  public List<Apofasi> getApofaseis() {
    return apofaseis;
  }

  public void setApofaseis(List<Apofasi> apofaseis) {
    this.apofaseis = apofaseis;
  }

  public List<Tax> getTaxes() {
    return taxes;
  }

  public void setTaxes(List<Tax> taxes) {
    this.taxes = taxes;
  }
  public List<Entoli> getEntoles() {
    return entoles;
  }

  public void setEntoles(List<Entoli> entoles) {
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


