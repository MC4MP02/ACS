package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

//Extend from Area, is a type of Area
//A partition is a group of spaces
public class Partitions extends Area {
 private ArrayList<Area> childs;
  private Area from;
  public Partitions(String id,Area from) {
    super(id);
    this.childs = new ArrayList<>();
    this.from = from;
  }

  public Area getFrom() {
    return from;
  } // getter of the father Area

  public void addChilds(ArrayList<Area> childs) {
    this.childs.addAll(childs);
  }

  //public ArrayList<Area> getChilds() { return childs; }

  // getter of the doors that the Partition has access to
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Area> allAreas = new ArrayList<>();
    ArrayList<Door> doors = new ArrayList<>();
    allAreas = DirectoryDoorsAndAreas.getAllAreas();

    for (int i = 0; i < allAreas.size(); i++) {
      if (allAreas.get(i).getFrom() == this) {
        doors.addAll(allAreas.get(i).getDoorsGivingAccess());
      }
    }
    return doors;
  }

  public ArrayList<Door> getDoors() {
    return doors;
  }// getter of the array of doors of the partition

  @Override
  public Area findAreaById(String id) {
    if (this.getId().equals(id)) {
      return this;
    } else {
      for (Area area : childs) {
        Area found = area.findAreaById(id);
        if (found != null) {
          return found;
        }
      }
      return null;
    }
  }

  @Override
  public String getId() {
    return id;
  }
}
