package baseNoStates;

import java.util.ArrayList;

//spaces class, a space can have one or more doors, it's a closed site by doors.
public class Spaces extends Area {
  public ArrayList<Area> areas;
  private Area from;

  // spaces constructor, id, area and partition assignments.

  public Spaces(String id, ArrayList<Area> areas, Partitions from) {
    super(id);
    this.areas = areas;
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
    this.doors = doors;
    return doors;
  }

  // doors attribute getter
  public ArrayList<Door> getDoors() {
    return doors;
  }
}
