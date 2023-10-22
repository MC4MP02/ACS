package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

//Extend from Area, is a type of Area
//A partition is a group of spaces
public class Partitions extends Area {
  public Area from;

  public Partitions(String id, Partitions from) {
    super(id);
    this.from = from;
  }

  public Area getFrom() {
    return from;
  } // getter of the father Area

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
}
