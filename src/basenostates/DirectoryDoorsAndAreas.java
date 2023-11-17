package basenostates;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *Class to create areas(spaces, partitions) and doors.
 */

public final class DirectoryDoorsAndAreas {
  /**
   * array to safe all the doors
   * and be able to search for them.
   */
  private static ArrayList<Door> allDoors;
  /**
   * array to safe all
   * the areas and be able to search for them.
   */
  private static ArrayList<Area> allAreas;
  private static Area root = null;
  private DirectoryDoorsAndAreas() {

  }

  /**
   * function to intialize
   * all the areas and doors.
   */
  public static void makeDoorsAndAreas() {
    // Partitions:
    // building --> basement, groundFloor,
    // floor1, stair and exterior

    // Spaces:
    // basement --> parking
    // groundFloor --> hall, room1, room2
    // floor1 --> room3, corridor, iT
    // Every Space/Partition have the "id"
    // (to identify) and "fromSpace" (to know
    // who is the parent Area)


    Partitions building = new Partitions("building", null);
    Partitions basement = new Partitions("basement", building);
    Partitions groundFloor = new Partitions("groundFloor", building);
    Partitions floor1 = new Partitions("floor1", building);
    Spaces parking = new Spaces("parking", basement);
    Spaces stairs = new Spaces("stairs", building);
    Spaces room1 = new Spaces("room1", groundFloor);
    Spaces room2 = new Spaces("room2", groundFloor);
    Spaces room3 = new Spaces("room3", floor1);
    Spaces hall = new Spaces("hall", groundFloor);
    Spaces corridor = new Spaces("corridor", floor1);
    Spaces iT = new Spaces("iT", floor1);
    Spaces exterior = new Spaces("exterior", building);

    building.addChilds(new ArrayList<>(Arrays.asList(basement, groundFloor, floor1, exterior, stairs)));

    basement.addChilds(new ArrayList<>(Arrays.asList(parking)));

    groundFloor.addChilds(new ArrayList<>(Arrays.asList(room1, room2, hall)));

    floor1.addChilds(new ArrayList<>(Arrays.asList(corridor, iT)));

    allAreas = new ArrayList<>(Arrays.asList(building, groundFloor, floor1, parking, stairs, room1, room2, room3, hall, corridor, iT, basement, exterior)); // initilize the allAreas

    root = building;

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
    Door d9 = new Door("D9", corridor, iT); // corridor, iT

    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9)); // initalize allDoors
  }

  // function for search in all the doors by the id
  // return: door that matches the id
  public static Door findDoorById(final String id) {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    System.out.println("door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  // function for search in all the areas by the id
  // return: area that matches the id
  public static Area findAreaById(final String id) {
    return root.findAreaById(id);
  }

  // this is needed by RequestRefresh
  public static ArrayList<Door> getAllDoors() {
    System.out.println(allDoors);
    return allDoors;
  }

  // gettes for the array allAreas
  // return: Array of all the areas
  public static ArrayList<Area> getAllAreas() {
    System.out.println(allAreas);
    return allAreas;
  }

}