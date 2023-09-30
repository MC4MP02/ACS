package baseNoStates;

public class Unlocked extends DoorState {

  public Unlocked(Door door) {
    super(door);
    setName(States.UNLOCKED);
  }
  public void open() {
    if (door.isClosed() && name.equals(States.UNLOCKED)) {
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
    if(door.isClosed()) {
      door.setState(new Locked(door));
    }
    else {
      System.out.println("Can't lock door " + door.getId() + " because it's open");
    }
  }

  public void unlock() {
    System.out.println("Can't close door " + door.getId() + " because it's already unlocked");
  }
}

