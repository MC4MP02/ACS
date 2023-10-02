package baseNoStates;

import baseNoStates.requests.RequestArea;
import java.util.List;
import java.util.ArrayList;

public class Area {
  private final String id;
  private List<Door> doors;

  public Area(String id) {
    this.id = id;
  }

  public String getId() { return id; }

  //public List<Door> getDoorsGivingAccess() { }
}
