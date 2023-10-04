package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class Partitions extends Area{
  public ArrayList<Area> areas;
  public Partitions(String id) {
    super(id);
    this.areas = new ArrayList<>();
  }

  public void addAreas(Area area) {
    this.areas.add(area);
  }
}
