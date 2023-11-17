package basenostates;

import basenostates.requests.RequestReader;
import org.json.JSONObject;

/**
 *Doors class, we have on it the declaration. me gusta el pene
 */

public class Door {
  private final String id;
  private final Area from;
  private final Area to;
  private boolean closed;
  private DoorState state;

  public Door(final String doorId, final Area sourceArea, final Area targetArea) {
    this.id = doorId;
    this.from = sourceArea;
    this.to = targetArea;
    closed = true;
    state = new Unlocked(this);
  }

  public void processRequest(final RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  public void setState(final DoorState doorStates) {
    state = doorStates;
  }

  private void doAction(final String action) {
    switch (action) {
      case Actions.OPEN:
        state.open();
        break;
      case Actions.CLOSE:
        state.close();
        break;
      case Actions.LOCK:
        state.lock();
        break;
      case Actions.UNLOCK:
        state.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        state.unlockShortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(final boolean closedDoor) {
    this.closed = closedDoor; }

  public String getId() {
    return id;
  }
  public Area getTo() {
    return to;
  }
  public Area getFrom() {
    return from; }

  public String getStateName() {
    return state.name;
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
}