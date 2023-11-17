package basenostates;

/**
 *Abstract class that indicates the different states of a door.
 */
public abstract  class DoorState {
  public Door door;
  protected String name;

  public DoorState(final Door doorId) {
    this.door = doorId;
    this.name = States.UNLOCKED;
  }

  public void open() { } //the door is open

  public void close() { } //the door is closed

  public void lock() { } //the door is locked

  public void unlock() { } //the door is unlocked

  public void unlockShortly() { } //the door is unlocked for 10 seconds

  //used to assign a name to a door
  public void setName(final String nameDoor) {
    this.name = nameDoor; }
}
