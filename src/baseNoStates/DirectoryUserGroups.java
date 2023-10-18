package baseNoStates;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryUserGroups {
  private static ArrayList<UserGroup> userGroups;

  public static void makeUserGroup() {
    LocalDate dateInicioEmployees = LocalDate.of(2023, 9, 1);
    LocalDate dateFinEmployees = LocalDate.of(2024, 3, 1);
    LocalTime timeInicioEmployees = LocalTime.of(9,0);
    LocalTime timeFinEmployees = LocalTime.of(17,0);
    ArrayList<String> actionsEmployees = new ArrayList<>(Arrays.asList(Actions.UNLOCK_SHORTLY));
    ArrayList<Area> spacesEmployees = new ArrayList<>();
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("ground_floor"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("floor1"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("exterior"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("stairs"));
    ArrayList<DayOfWeek> daysEmployees = new ArrayList<DayOfWeek>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));

    UserGroup employees = new UserGroup(dateInicioEmployees, dateFinEmployees, daysEmployees, timeInicioEmployees, timeFinEmployees, actionsEmployees, spacesEmployees);
    employees.addUsers(new User("Ernest", "74984"));
    employees.addUsers(new User("Eulalia", "43295"));


    LocalDate dateInicioManagers = LocalDate.of(2023, 9, 1);
    LocalDate dateFinManagers = LocalDate.of(2024, 3, 1);
    LocalTime timeInicioManagers = LocalTime.of(8,0);
    LocalTime timeFinManagers= LocalTime.of(20,0);
    ArrayList<String> actionsManagers = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    ArrayList<Area> spacesManagers = new ArrayList<>();
    spacesManagers = spacesEmployees;
    spacesManagers.add(DirectoryDoorsAndAreas.findAreaById("parking"));
    ArrayList<DayOfWeek> daysManagers = daysEmployees;
    daysManagers.add(DayOfWeek.SATURDAY);

    UserGroup managers = new UserGroup(dateInicioManagers, dateFinManagers, daysManagers, timeInicioManagers, timeFinManagers, actionsManagers, spacesManagers);
    managers.addUsers(new User("Manel", "95783"));
    managers.addUsers(new User("Marta", "05827"));


    LocalDate dateInicioAdmin = LocalDate.of(2023, 1, 1);
    LocalDate dateFinAdmin = LocalDate.of(2100, 1, 1);
    LocalTime timeInicioAdmin = LocalTime.of(0,0);
    LocalTime timeFinAdmin = LocalTime.of(0,0);
    ArrayList<String> actionsAdmin = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    ArrayList<Area> spacesAdmin = new ArrayList<>();
    spacesAdmin = spacesManagers;
    ArrayList<DayOfWeek> daysAdmin = daysManagers;
    daysAdmin.add(DayOfWeek.SUNDAY);

    UserGroup admin = new UserGroup(dateInicioAdmin, dateFinAdmin, daysAdmin,timeInicioAdmin, timeFinAdmin, actionsAdmin, spacesManagers);
    admin.addUsers(new User("Ana", "11343"));

    LocalDate dateInicioUser = LocalDate.of(1, 1, 1);
    LocalDate dateFinUser = LocalDate.of(1, 1, 1);
    LocalTime timeInicioUser = LocalTime.of(0,0);
    LocalTime timeFinUser = LocalTime.of(0,0);
    UserGroup user = new UserGroup(dateInicioUser, dateFinUser, new ArrayList<>(), timeInicioUser, timeFinUser, new ArrayList<>(), new ArrayList<>());
    user.addUsers(new User("Bernat", "12345"));
    user.addUsers(new User("Blai", "77532"));

    userGroups = new ArrayList<>(Arrays.asList(user, admin, employees, managers));
  }

  public static User findUserByCredential(String credential) {
    for (UserGroup userGroup: userGroups) {
      for (User user : userGroup.getUsers()) {
        if (user.getCredential().equals(credential)) {
          return user;
        }
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null;
  }

  public static UserGroup findUserGroupByUser(String credential) {
    for (UserGroup userGroup: userGroups) {
      for (User user : userGroup.getUsers()) {
        if (user.getCredential().equals(credential)) {
          return userGroup;
        }
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null;
  }
}
