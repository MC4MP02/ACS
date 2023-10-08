package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryDoors {
  private static ArrayList<Door> allDoors;
  private static ArrayList<Area> allAreas;

  public static void makeDoors() {
    Area basement = new Area("basement");
    Area ground_floor = new Area("ground_floor");
    Area floor1 = new Area("floor1");
    Area parking = new Area("parking");
    Area stairs = new Area("stairs");
    Area room1 = new Area("room1");
    Area room2 = new Area("room2");
    Area room3 = new Area("room3");
    Area hall = new Area("hall");
    Area corridor = new Area("corridor");
    Area IT = new Area("IT");
    Area building = new Area("building");
    Area exterior = new Area("exterior");

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

  // this is needed by RequestRefresh
  public static ArrayList<Door> getAllDoors() {
    System.out.println(allDoors);
    return allDoors;
  }

}
