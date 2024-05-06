package dai.monopoly.board.models;

import dai.monopoly.board.properties.Buildable;
import dai.monopoly.board.properties.Company;
import dai.monopoly.board.properties.TrainProperty;

import java.util.ArrayList;
import java.util.List;

public class PropertiesModel {
  private List<Buildable> buildables;
  private List<TrainProperty> trains;
  private List<Company> companies;

  public PropertiesModel() {
    this.buildables = new ArrayList<>();
    this.trains = new ArrayList<>();
    this.companies = new ArrayList<>();
  }

  public List<Buildable> getBuildables() {
    return buildables;
  }

  public void setBuildables(List<Buildable> buildables) {
    this.buildables = buildables;
  }

  public List<TrainProperty> getTrains() {
    return trains;
  }

  public void setTrains(List<TrainProperty> trains) {
    this.trains = trains;
  }

  public List<Company> getCompanies() {
    return companies;
  }

  public void setCompanies(List<Company> companies) {
    this.companies = companies;
  }
}
