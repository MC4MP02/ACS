package baseNoStates;

import java.util.ArrayList;

public class Spaces extends Area {
  public ArrayList<Area> areas;
  private Area from;
  public Spaces(String id, ArrayList<Area> areas, Partitions from) {
    super(id);
    this.areas = areas;
    this.from = from;
  }

  public Area getFrom() {return from;}
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    //RETURN DOORS

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

  public ArrayList<Door> getDoors(){ return doors; }

  public ArrayList<Area> getAreas() { return areas; }
}
