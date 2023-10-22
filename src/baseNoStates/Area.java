package baseNoStates;

import baseNoStates.requests.RequestArea;
import java.util.List;
import java.util.ArrayList;

//This abstract class "contains" the Area objects, which can be of two types: Space or Partition
abstract public class Area {
  protected final String id;
  protected ArrayList<Door> doors; // list of doors that the area has

  public Area(String id) {
    this.doors = new ArrayList<Door>();
    this.id = id;
  }

  public String getId() {
    return id;
  } // getter of area's id

  abstract public Area getFrom(); // getter from the object's parent area

  abstract public ArrayList<Door> getDoors(); // getter of the array of doors of the area

  abstract public ArrayList<Door> getDoorsGivingAccess(); // getter of the doors that the object area has access to
}
