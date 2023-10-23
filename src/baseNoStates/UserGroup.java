package baseNoStates;

import java.time.*;
import java.util.ArrayList;
//UserGroup class that creates user groups in the system for using it for the different roles
public class UserGroup {
  private final String id;

  private final Schedule schedule;
  private final ArrayList<String> actions;
  private final ArrayList<User> users;
  private final ArrayList<Area> areas;
  //constructor that initializes the attributes with the provided values
  public UserGroup(String id, Schedule schedule, ArrayList<String> actions, ArrayList<User> users, ArrayList<Area> areas) {
    this.id = id;
    this.schedule = schedule;
    this.users = users;
    this.areas = areas;
    this.actions = actions;
  }
  //all getters
  public ArrayList<User> getUsers() { return users; }

  public void addUsers(User user) { this.users.add(user); }

  public ArrayList<Area> getAreas() { return areas; }

  public ArrayList<String> getActions() { return actions; }

  public Schedule getSchedule() { return schedule; }
}
