package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryAreas {
    private static ArrayList<Area> allAreas;
    public static void makeAreas(){
        Area a1= new Area("basement");
        Area a2= new Area("ground floor");
        Area a3= new Area("floor 1");

        allAreas= new ArrayList<>(Arrays.asList(a1,a2,a3));
    }
    public static Area findAreaById(String id)
    {
        for (Area area: allAreas)
        {
            if(area.getId().equals(id)){
                return area;
            }
        }
        System.out.println("area with id " + id + " not found");
        return null; // otherwise we get a Java error
    }
}
