package baseNoStates;

abstract class DoorState{
  protected Door door;
  protected String name;

  public DoorState(Door door) {
    this.door=door;
  }

  public void open() {
    if (canOpen()) {
      System.out.println("Opening the door.");
      door.setClosed(false);
    } else {
      System.out.println("Can't open the door. It's locked.");
    }
  }

  public void close() {
    if(!door.isClosed()) {
      System.out.println("Closing the door.");
      door.setClosed(true);
    }
    else
    {
      System.out.println("Can't close the door. Is already closed.");
    }
  }

  public void lock() {
    System.out.println("Locking the door.");
    door.setState(new Locked(door));
  }

  public void unlock() {
    System.out.println("Unlocking the door.");
    door.setState(new Unlocked(door));
  }
  public String getName() {
    return name;
  }
  public boolean canOpen() {
    return true;
  }
}