package baseNoStates.requests;

import baseNoStates.*;

import java.time.*;
import java.util.ArrayList;

import com.sun.source.tree.DirectiveTree;
import org.json.JSONArray;
import org.json.JSONObject;

public class RequestReader implements Request {
  private final String credential; // who
  private final String action;     // what
  private final LocalDateTime now; // when
  private final String doorId;     // where
  private String userName;
  private boolean authorized;
  private final ArrayList<String> reasons; // why not authorized
  private String doorStateName;
  private boolean doorClosed;

  public RequestReader(String credential, String action, LocalDateTime now, String doorId) {
    this.credential = credential;
    this.action = action;
    this.doorId = doorId;
    reasons = new ArrayList<>();
    this.now = now;
  }

  public void setDoorStateName(String name) {
    doorStateName = name;
  }

  public String getAction() {
    return action;
  }

  public boolean isAuthorized() {
    return authorized;
  }

  public void addReason(String reason) {
    reasons.add(reason);
  }


  @Override
  public String toString() {
    if (userName == null) {
      userName = "unknown";
    }
    return "Request{"
            + "credential=" + credential
            + ", userName=" + userName
            + ", action=" + action
            + ", now=" + now
            + ", doorID=" + doorId
            + ", closed=" + doorClosed
            + ", authorized=" + authorized
            + ", reasons=" + reasons
            + "}";
  }

  public JSONObject answerToJson() {
    JSONObject json = new JSONObject();
    json.put("authorized", authorized);
    json.put("action", action);
    json.put("doorId", doorId);
    json.put("closed", doorClosed);
    json.put("state", doorStateName);
    json.put("reasons", new JSONArray(reasons));
    return json;
  }

  // see if the request is authorized and put this into the request, then send it to the door.
  // if authorized, perform the action.
  public void process() {
    User user = DirectoryUserGroups.findUserByCredential(credential);
    Door door = DirectoryDoorsAndAreas.findDoorById(doorId);
    assert door != null : "door " + doorId + " not found";
    authorize(user, door);
    // this sets the boolean authorize attribute of the request
    door.processRequest(this);
    // even if not authorized we process the request, so that if desired we could log all
    // the requests made to the server as part of processing the request
    doorClosed = door.isClosed();
  }

  // the result is put into the request object plus, if not authorized, why not,
  // only for testing
  private void authorize(User user, Door door) {
    if (user == null) {
      authorized = false;
      addReason("user doesn't exists");
    } else {
      //TODO: get the who, where, when and what in order to decide, and if not
      // authorized add the reason(s)
      UserGroup userGroup = DirectoryUserGroups.findUserGroupByUser(user.getCredential());

      ArrayList<Area> area = userGroup.getSpaces();
      LocalDate dateInici = userGroup.getDateInici();
      LocalDate dateFin = userGroup.getDateFin();
      LocalTime timeInici = userGroup.getTimeInici();
      LocalTime timeFin = userGroup.getTimeFin();
      ArrayList<DayOfWeek> days = userGroup.getDays();
      ArrayList<String> actions = userGroup.getActions();
      ArrayList<User> users = userGroup.getUsers();

      boolean areaTrue = false;
      for (Area areas : area) {
        if (door.getTo().getFrom() == areas || door.getTo() == areas) {
          areaTrue = true;
        }
      }

      boolean daysTrue = days.contains(now.getDayOfWeek());
      boolean dateTrue = now.toLocalDate().isAfter(dateInici) && now.toLocalDate().isBefore(dateFin);
      boolean timeTrue = now.toLocalTime().isAfter(timeInici) && now.toLocalTime().isBefore(timeFin);
      boolean actionsTrue = false;
      for (String act : actions) {
        if (action.equals(act)) {
          actionsTrue = true;
        }
      }

      if(areaTrue && daysTrue && dateTrue && timeTrue && actionsTrue) {
        authorized = true;
      } else {
        authorized = false;
      }

      if (!authorized) {
        if (!areaTrue) reasons.add("User " + user.getName() + " has no access to this area");
        else if (!daysTrue) reasons.add("User " + user.getName() + " has no access today");
        else if (!dateTrue) reasons.add("User " + user.getName() + " has no access today");
        else if (!timeTrue) reasons.add("User " + user.getName() + " has no access at " + now.toLocalTime());
        else if (!actionsTrue) reasons.add("User " + user.getName() + " can't do " + action);
      }
      //authorized = true;
    }
  }
}

