package baseNoStates;

import baseNoStates.Area;
import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
  private static ArrayList<Area> allAreas;

    public static void makeAreas() {

      Area a1 = new Area("basement");
      Area a2 = new Area("ground_floor");
      Area a3 = new Area("floor1");
      Area a4 = new Area("parking");
      Area a5 = new Area("stairs");
      Area a6 = new Area("room1");
      Area a7 = new Area("room2");
      Area a8 = new Area("room3");
      Area a9 = new Area("hall");
      Area a10 = new Area("corridor");
      Area a11 = new Area("IT");
      Area a12 = new Area("hall");
      Area a13 = new Area("building");
      Area a14 = new Area("exterior");

      allAreas = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14));
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

