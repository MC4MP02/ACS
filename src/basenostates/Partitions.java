package basenostates;

import java.util.*;

/**
 *Extend from Area, is a type of Area.
 *A partition is a group of spaces.
 */

public class Partitions extends Area {
 private List<Area> childs;
  private Area from;
  public Partitions(String ident,Area from) {
    super(ident);
    this.childs = new ArrayList<>();
    this.from = from;
  }

  public Area getFrom() {
    return from;
  } // getter of the father Area

  public void addChilds(Collection<Area> childs) {
    this.childs.addAll(childs);
  }

  //public ArrayList<Area> getChilds() { return childs; }

  // getter of the doors that the Partition has access to
    //returns an ArrayList of doors with Door type
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    List<Area> allAreas = new ArrayList<>();
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
    return this.getDoors();
  }// getter of the array of doors of the partition
    // function for search in all the Areas by the id
    // return: Area that matches the id
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
    return this.getId();
  }
}
