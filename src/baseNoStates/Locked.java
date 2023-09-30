package baseNoStates;

public class Locked extends DoorState {

  public Locked(Door door) {
    super(door);
    setName(States.LOCKED);
  }

  public void open() {

  }

  public void close() {

  }

  public void lock() {

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

