package baseNoStates;

public class Locked extends DoorState {

  public Locked(Door door) {
    super(door);
    setName(States.LOCKED);
  }

  public void open() {
    System.out.println("Can't open the door " + door.getId() + " because it's locked");
  }

  public void close() {
    System.out.println("Can't close the door " + door.getId() + " because it's locked");
  }

  public void lock() {
    System.out.println("Can't lock the door " + door.getId() + " because it's already locked");
  }
  public void unlock() {
    if(name.equals(States.LOCKED)) {
      name = States.UNLOCKED;
      door.setState(new Unlocked(door));
    }
    else {
      System.out.println("Can't unlock door " + door.getId() + " because it's already unlock");
    }
  }
}

