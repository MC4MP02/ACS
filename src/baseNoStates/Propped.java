package baseNoStates;

public class Propped extends DoorState{
  public Propped(Door door) {
    super(door);
    setName(States.PROPPED);
  }
  public void open() {
    System.out.println("Can't open the door " + door.getId() + " because it's already open");
  }

  public void close() {
    door.setClosed(true);
    door.setState(new Locked(door));
  }

  public void lock() {
    System.out.println("Can't lock the door " + door.getId() + " because it's already locked");
  }
  public void unlock() {
    System.out.println("Can't lock the door " + door.getId() + " because it's already locked");
  }
}
