package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryDoorsAndAreas {
  private static ArrayList<Door> allDoors;
  private static ArrayList<Area> allAreas;

  public static void makeDoorsAndAreas() {
    Partitions building = new Partitions("building", allAreas, null);
    Partitions basement = new Partitions("basement", allAreas, building);
    Partitions ground_floor = new Partitions("ground_floor", allAreas, building);
    Partitions floor1 = new Partitions("floor1", allAreas, building);
    Spaces parking = new Spaces("parking", allAreas, basement);
    Spaces stairs = new Spaces("stairs", allAreas, building);
    Spaces room1 = new Spaces("room1", allAreas, ground_floor);
    Spaces room2 = new Spaces("room2", allAreas, ground_floor);
    Spaces room3 = new Spaces("room3", allAreas, floor1);
    Spaces hall = new Spaces("hall", allAreas, ground_floor);
    Spaces corridor = new Spaces("corridor", allAreas, floor1);
    Spaces IT = new Spaces("IT", allAreas, floor1);
    Spaces exterior = new Spaces("exterior", allAreas, building);

    allAreas = new ArrayList<>(Arrays.asList(basement, ground_floor, floor1, parking, stairs, room1, room2, room3, hall, corridor, IT, building, exterior));

    // basement
    Door d1 = new Door("D1", exterior, parking); // exterior, parking
    Door d2 = new Door("D2", stairs, parking); // stairs, parking

    // ground floor
    Door d3 = new Door("D3", exterior, hall); // exterior, hall
    Door d4 = new Door("D4", stairs, hall); // stairs, hall
    Door d5 = new Door("D5", hall, room1); // hall, room1
    Door d6 = new Door("D6", hall, room2); // hall, room2

    // first floor
    Door d7 = new Door("D7", stairs, corridor); // stairs, corridor
    Door d8 = new Door("D8", corridor, room3); // corridor, room3
    Door d9 = new Door("D9", corridor, IT); // corridor, IT

    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
  }

  public static Door findDoorById(String id) {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    System.out.println("door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  public static Area findAreaById(String id) {
    for (Area area : allAreas) {
      if (area.getId().equals(id)) {
        return area;
      }
    }
    System.out.println("area with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  // this is needed by RequestRefresh
  public static ArrayList<Door> getAllDoors() {
    System.out.println(allDoors);
    return allDoors;
  }
  public static ArrayList<Area> getAllAreas() {
    System.out.println(allAreas);
    return allAreas;
  }

}
