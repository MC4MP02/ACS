package baseNoStates;

public class UnlockedShortly extends DoorState {
  public UnlockedShortly(Door door) {
    super(door);
    setName(States.UNLOCKED_SHORTLY);
  }

  public void open() {
    if (door.isClosed()) {
      door.setClosed(false);
    } else {
      System.out.println("Can't open door " + door.getId() + " because it's already open");
    }
  }

  public void close() {
    if(!door.isClosed()) {
      door.setClosed(true);
    }
    else
    {
      System.out.println("Can't close door " + door.getId() + " because it's already closed");
    }
  }

  public void lock() {
    System.out.println("Can't lock the door " + door.getId() + " because it's already locked");
  }
  public void unlock() {
    System.out.println("Can't unlock door " + door.getId() + " because it's already unlocked");
  }
}
