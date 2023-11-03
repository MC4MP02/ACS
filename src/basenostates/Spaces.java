package basenostates;

import java.util.ArrayList;

/**
 *Spaces class, a space can have one or more doors.
 *It's a closed site by doors.
 */
public class Spaces extends Area {
  private Area from;

  // spaces constructor, id, area and partition assignments.

  public Spaces(String id, Area from) {
    super(id);
    this.from = from;
  }

  // from getter
  public Area getFrom() {
    return from;
  }

  // this function searchs and returns a list of doors that are accessible for this space
  // return: ArrayList Door type with all doors
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    // RETURN DOORS

    ArrayList<Door> doors = new ArrayList<>();
    ArrayList<Door> allDoors = new ArrayList<>();
    allDoors = DirectoryDoorsAndAreas.getAllDoors();

    for (int i = 0; i < allDoors.size(); i++) {
      if (allDoors.get(i).getTo() == this) {
        doors.add(allDoors.get(i));
      }
    }
    this.setDoors(doors);
    return doors;
  }

  // doors attribute getter
  @Override
  public ArrayList<Door> getDoors() {
    return this.getDoors();
  }

  @Override
  public Area findAreaById(String id) {
    if (this.getId().equals(id)) {
      return this;
    }
    return null;
  }

  @Override
  public String getId() { return this.getId(); }
}
