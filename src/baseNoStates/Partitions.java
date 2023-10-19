package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class Partitions extends Area{
  public ArrayList<Area> areas;
  public Area from;

  public Partitions(String id, ArrayList<Area> areas, Partitions from) {
    super(id);
    this.areas = areas;
    this.from = from;
  }

  public Area getFrom() {return from;}
  public void addAreas(Area area) {
    this.areas.add(area);
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Area> allAreas = new ArrayList<>();
    ArrayList<Door> doors = new ArrayList<>();
    allAreas = DirectoryDoorsAndAreas.getAllAreas();


    for (int i = 0; i < allAreas.size(); i++) {
      if(allAreas.get(i).getFrom() == this) {
        doors.addAll(allAreas.get(i).getDoorsGivingAccess());
      }
    }
    return doors;
  }

  public ArrayList<Door> getDoors(){ return doors; }

  public ArrayList<Area> getAreas() { return areas; }

}
