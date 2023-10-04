package baseNoStates;

import baseNoStates.Area;
import baseNoStates.DirectoryDoors;
import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
  private static ArrayList<Area> allAreas = new ArrayList<>();

    public static void makeAreas() {
      ArrayList<Door> allDoors = new ArrayList<Door>(DirectoryDoors.getAllDoors());
      Partitions basement = new Partitions("basement");
      Partitions ground_floor = new Partitions("ground_floor");
      Partitions floor1 = new Partitions("floor1");
      Partitions building = new Partitions("building");

      Spaces parking = new Spaces("parking");
      Spaces stairs = new Spaces("stairs");
      Spaces room1 = new Spaces("room1");
      Spaces room2 = new Spaces("room2");
      Spaces room3 = new Spaces("room3");
      Spaces hall = new Spaces("hall");
      Spaces corridor = new Spaces("corridor");
      Spaces IT = new Spaces("IT");
      Spaces exterior = new Spaces("exterior");

      building.addAreas(basement);
      building.addAreas(ground_floor);
      building.addAreas(floor1);
      basement.addAreas(parking);
      ground_floor.addAreas(hall);
      ground_floor.addAreas(room1);
      ground_floor.addAreas(room2);
      floor1.addAreas(room3);
      floor1.addAreas(corridor);
      floor1.addAreas(IT);

      parking.doors.add(allDoors.get(0));
      parking.doors.add(allDoors.get(1));
      stairs.doors.add(allDoors.get(1));
      stairs.doors.add(allDoors.get(3));
      stairs.doors.add(allDoors.get(6));
      room1.doors.add(allDoors.get(4));
      room2.doors.add(allDoors.get(5));
      room3.doors.add(allDoors.get(7));
      hall.doors.add(allDoors.get(4));
      hall.doors.add(allDoors.get(3));
      hall.doors.add(allDoors.get(2));
      corridor.doors.add(allDoors.get(7));
      corridor.doors.add(allDoors.get(8));
      corridor.doors.add(allDoors.get(6));
      IT.doors.add(allDoors.get(8));
      exterior.doors.add(allDoors.get(0));
      exterior.doors.add(allDoors.get(2));

      allAreas = new ArrayList<>(Arrays.asList(basement, ground_floor, floor1, building, parking, stairs, room1, room2, room3, hall, corridor, IT, exterior));
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
    public static ArrayList<Area> getAllAreas() {
      System.out.println(allAreas);
      return allAreas;
    }

}

