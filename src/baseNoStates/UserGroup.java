package baseNoStates;

import java.time.*;
import java.util.ArrayList;

public class UserGroup {
  private ArrayList<User> users;
  private LocalDate dateInici;
  private LocalDate dateFin;
  private LocalTime timeInici;
  private LocalTime timeFin;

  private ArrayList<DayOfWeek> days;
  private ArrayList<String> actions;
  private ArrayList<Area> spaces;

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
