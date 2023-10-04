package baseNoStates;

abstract public class DoorState{
  protected Door door;
  protected String name;

  public DoorState(Door door) {
    this.door = door;
    this.name = States.UNLOCKED;
  }

  public void open() {}

  public void close() {}

  public void lock() {}

  public void unlock() {}

  public void unlock_shorty() {}
  public String getName() {
    return name;
  }
  public void setName(String name) { this.name = name; }
}