package baseNoStates;

import baseNoStates.Area;
import baseNoStates.DirectoryDoorsAndAreas;
import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
    private Area rootArea;
    private final static ArrayList<Area> allAreas = new ArrayList<>();

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

