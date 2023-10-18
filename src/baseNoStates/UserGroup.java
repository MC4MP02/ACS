package baseNoStates;

import java.time.*;
import java.util.ArrayList;

public class UserGroup {
  private final ArrayList<User> users;
  private final LocalDate dateInici;
  private final LocalDate dateFin;
  private final LocalTime timeInici;
  private final LocalTime timeFin;

  private final ArrayList<DayOfWeek> days;
  private final ArrayList<String> actions;
  private final ArrayList<Area> spaces;

  public UserGroup(LocalDate dateInici, LocalDate dateFin, ArrayList<DayOfWeek> days,  LocalTime timeInici, LocalTime timeFin, ArrayList<String> actions, ArrayList<Area> spaces) {
    this.users = new ArrayList<User>();
    this.dateInici = dateInici;
    this.dateFin = dateFin;
    this.timeInici = timeInici;
    this.timeFin = timeFin;
    this.actions = actions;
    this.spaces = spaces;
    this.days = days;
  }

  public ArrayList<User> getUsers() { return users; }

  public void addUsers(User user) { this.users.add(user); }

  public ArrayList<Area> getSpaces() { return spaces; }

  public LocalDate getDateInici() { return dateInici; }

  public LocalDate getDateFin() { return dateFin; }

  public LocalTime getTimeInici() { return timeInici; }

  public LocalTime getTimeFin() { return timeFin; }

  public ArrayList<DayOfWeek> getDays() { return days; }

  public ArrayList<String> getActions() { return actions; }
}
