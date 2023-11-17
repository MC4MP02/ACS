package basenostates;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *Class to create the users and the groups of user.
 */

public final class DirectoryUserGroups {
  private DirectoryUserGroups() {
  }
  private static final Integer ONE = 1;
  private static final Integer YEAR = 2023;

  //array of all the groups for search them
  private static Iterable<UserGroup> userGroups;

  //function to intialize all the users and groups of users
  public static void makeUserGroup() {
    //start date in format LocalDate
    LocalDate dateInicioEmployees = LocalDate.of(YEAR, Month.SEPTEMBER, ONE);
    //end date in format LocalDate
    LocalDate dateFinEmployees = LocalDate.of(2024, Month.MARCH, ONE);
    //start time in format LocalTime
    LocalTime timeInicioEmployees = LocalTime.of(9, 0);
    //end time in format LocalTime
    LocalTime timeFinEmployees = LocalTime.of(17, 0);
    //array of all the days in format DayOfWeek that the group have access
    ArrayList<DayOfWeek> daysEmployees = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
    //initialize a object of Schedule
    Schedule scheduleEmployees = new Schedule(dateInicioEmployees, dateFinEmployees, daysEmployees, timeInicioEmployees, timeFinEmployees);

    ArrayList<String> actionsEmployees = new ArrayList<>(Arrays.asList(Actions.UNLOCK_SHORTLY, Actions.OPEN, Actions.CLOSE));
    ArrayList<Area> spacesEmployees = new ArrayList<>();
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("ground_floor"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("floor1"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("exterior"));
    spacesEmployees.add(DirectoryDoorsAndAreas.findAreaById("stairs"));
    ArrayList<User> usersEmployees = new ArrayList<>(Arrays.asList(new User("Ernest", "74984"), new User("Eulalia", "43295")));

    UserGroup employees = new UserGroup("employees", scheduleEmployees, actionsEmployees, usersEmployees, spacesEmployees);


    LocalDate dateInicioManagers = LocalDate.of(2023, Month.SEPTEMBER, ONE.intValue());
    LocalDate dateFinManagers = LocalDate.of(2024, Month.MARCH, ONE);
    LocalTime timeInicioManagers = LocalTime.of(8, 0);
    LocalTime timeFinManagers = LocalTime.of(20, 0);
    ArrayList<DayOfWeek> daysManagers = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    Schedule scheduleManagers = new Schedule(dateInicioManagers, dateFinManagers, daysManagers, timeInicioManagers, timeFinManagers);

    ArrayList<String> actionsManagers = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    ArrayList<Area> spacesManagers = new ArrayList<>(Arrays.asList(DirectoryDoorsAndAreas.findAreaById("building")));
    ArrayList<User> usersManagers = new ArrayList<>(Arrays.asList(new User("Manel", "95783"), new User("Marta", "05827")));

    UserGroup managers = new UserGroup("managers", scheduleManagers, actionsManagers, usersManagers, spacesManagers);


    LocalDate dateInicioAdmin = LocalDate.of(2023, 1, 1);
    LocalDate dateFinAdmin = LocalDate.of(2100, 1, 1);
    LocalTime timeInicioAdmin = LocalTime.of(0, 0);
    LocalTime timeFinAdmin = LocalTime.of(23, 59);
    ArrayList<DayOfWeek> daysAdmin = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));

    Schedule scheduleAdmin = new Schedule(dateInicioAdmin, dateFinAdmin, daysAdmin, timeInicioAdmin, timeFinAdmin);

    ArrayList<String> actionsAdmin = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    ArrayList<Area> spacesAdmin = new ArrayList<>();
    spacesAdmin = spacesManagers;
    ArrayList<User> usersAdmin = new ArrayList<>(Arrays.asList(new User("Ana", "11343")));

    UserGroup admin = new UserGroup("admin", scheduleAdmin, actionsAdmin, usersAdmin, spacesAdmin);

    LocalDate dateInicioUser = LocalDate.of(1, 1, 1);
    LocalDate dateFinUser = LocalDate.of(1, 1, 1);
    LocalTime timeInicioUser = LocalTime.of(0, 0);
    LocalTime timeFinUser = LocalTime.of(0, 0);
    Schedule scheduleUser = new Schedule(dateInicioUser, dateFinUser, new ArrayList<>(), timeInicioUser, timeFinUser);
    ArrayList<User> usersUser = new ArrayList<>(Arrays.asList(new User("Bernat", "12345"), new User("Blai", "77532")));

    UserGroup user = new UserGroup("user", scheduleUser, new ArrayList<>(), usersUser, new ArrayList<>());


    userGroups = new ArrayList<>(Arrays.asList(user, admin, employees, managers));
  }
  //we search a concrete user by his credential
  //returns a User object if it finds it
  public static User findUserByCredential(final String credential) {
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
  //we search a concrete userGroup by a user that belongs to it
  //returns a UserGroup object if it finds it
  public static UserGroup findUserGroupByUser(final String credential) {
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