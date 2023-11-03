package basenostates;

/**
 *Abstract class that indicates the different states of a door.
 */
abstract public class DoorState{
  protected Door door;
  protected String name;

  public DoorState(Door door) {
    this.door = door;
    this.name = States.UNLOCKED;
  }

  public void open() {} //the door is open

  public void close() {} //the door is closed

  public void lock() {} //the door is locked

  public void unlock() {} //the door is unlocked

  public void unlock_shortly() {} //the door is unlocked for 10 seconds

  public void setName(String name) { this.name = name; } //used to assign a name to a door
}