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
    ArrayList<DayOfWeek> daysEmployees = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
    Schedule scheduleEmployees = new Schedule(dateInicioEmployees, dateFinEmployees, daysEmployees, timeInicioEmployees, timeFinEmployees);

    ArrayList<String> actionsEmployees = new ArrayList<>(Arrays.asList(Actions.UNLOCK_SHORTLY, Actions.OPEN, Actions.CLOSE));
    ArrayList<Area> spacesEmployees = new ArrayList<>();
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("ground_floor"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("floor1"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("exterior"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("stairs"));
    ArrayList<User> usersEmployees = new ArrayList<>(Arrays.asList(new User("Ernest", "74984"), new User("Eulalia", "43295")));

    UserGroup employees = new UserGroup("employees", scheduleEmployees, actionsEmployees, usersEmployees, spacesEmployees);


    LocalDate dateInicioManagers = LocalDate.of(2023, 9, 1);
    LocalDate dateFinManagers = LocalDate.of(2024, 3, 1);
    LocalTime timeInicioManagers = LocalTime.of(8,0);
    LocalTime timeFinManagers= LocalTime.of(20,0);
    ArrayList<DayOfWeek> daysManagers = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    Schedule scheduleManagers = new Schedule(dateInicioManagers, dateFinManagers, daysManagers, timeInicioManagers, timeFinManagers);

    ArrayList<String> actionsManagers = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    ArrayList<Area> spacesManagers = new ArrayList<>(Arrays.asList(DirectoryDoorsAndAreas.findAreaById("building")));
    ArrayList<User> usersManagers = new ArrayList<>(Arrays.asList(new User("Manel", "95783"), new User("Marta", "05827")));

    UserGroup managers = new UserGroup("managers", scheduleManagers, actionsManagers, usersManagers, spacesManagers);


    LocalDate dateInicioAdmin = LocalDate.of(2023, 1, 1);
    LocalDate dateFinAdmin = LocalDate.of(2100, 1, 1);
    LocalTime timeInicioAdmin = LocalTime.of(0,0);
    LocalTime timeFinAdmin = LocalTime.of(23,59);
    ArrayList<DayOfWeek> daysAdmin = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));

    Schedule scheduleAdmin = new Schedule(dateInicioAdmin, dateFinAdmin, daysAdmin, timeInicioAdmin, timeFinAdmin);

    ArrayList<String> actionsAdmin = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    ArrayList<Area> spacesAdmin = new ArrayList<>();
    spacesAdmin = spacesManagers;
    ArrayList<User> usersAdmin = new ArrayList<>(Arrays.asList(new User("Ana", "11343")));

    UserGroup admin = new UserGroup("admin", scheduleAdmin, actionsAdmin, usersAdmin, spacesAdmin);

    LocalDate dateInicioUser = LocalDate.of(1, 1, 1);
    LocalDate dateFinUser = LocalDate.of(1, 1, 1);
    LocalTime timeInicioUser = LocalTime.of(0,0);
    LocalTime timeFinUser = LocalTime.of(0,0);
    Schedule scheduleUser = new Schedule(dateInicioUser, dateFinUser, new ArrayList<>(), timeInicioUser, timeFinUser);
    ArrayList<User> usersUser = new ArrayList<>(Arrays.asList(new User("Bernat", "12345"), new User("Blai", "77532")));

    UserGroup user = new UserGroup("user", scheduleUser, new ArrayList<>(), usersUser, new ArrayList<>());


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
