package baseNoStates;

import baseNoStates.requests.RequestArea;
import java.util.List;
import java.util.ArrayList;

public class Area {
  protected final String id;
  protected ArrayList<Door> doors;
  public Area(String id) {
    this.doors = new ArrayList<Door>();
    this.id = id;
  }

  public String getId() { return id; }

  public ArrayList<Door> getDoorsGivingAccess() {
    return this.doors;
  }

  public ArrayList<Door> getDoorsFromPartitions() {
    ArrayList<Door> doorsFromPartitions = new ArrayList<Door>();

    if (this instanceof Partitions partitions) {
      ArrayList<Area> pAreas = partitions.areas;
      for (Area iAreas : pAreas) {
        if (iAreas instanceof Partitions) {
          doorsFromPartitions.addAll(iAreas.getDoorsFromPartitions());
        }
        doorsFromPartitions.addAll(iAreas.doors);
      }
    } else {
      doorsFromPartitions = doors;
    }
    return doorsFromPartitions;
  }
}
