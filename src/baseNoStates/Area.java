package baseNoStates;

import baseNoStates.requests.RequestArea;
import java.util.List;
import java.util.ArrayList;

abstract public class Area {
  protected final String id;
  protected ArrayList<Door> doors;

  public Area(String id) {
    this.doors = new ArrayList<Door>();
    this.id = id;
  }

  public String getId() { return id; }

  abstract Area getFrom();

  abstract public ArrayList<Door> getDoorsGivingAccess();
}

