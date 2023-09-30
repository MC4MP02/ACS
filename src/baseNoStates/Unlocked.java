package baseNoStates;

public class Unlocked extends DoorState {

  public Unlocked(Door door) {
    super(door);
  }
  public void open() {

  }
  public void close() {

  }
  @Override
  public void lock() {
    if (door.isClosed()) {
      super.lock();
    } else {
      System.out.println("Can't lock the door. It's not closed.");
    }
  }
  public void unlock() {

  }
}

