package basenostates;

/**
 *Extend of the abstract class DoorState.
 *It indicates that the door is Unlocked.
 *When the door is unlocked we can open, close and lock it.
 */
public class Unlocked extends DoorState {

  //sets the door state to unlocked
  public Unlocked(final Door door) {
    super(door);
    setName(States.UNLOCKED);
  }

  /**
   * sets the attribute closed of the door to false so the door is now open.
   */
  public void open() {
    if (door.isClosed() && name.equals(States.UNLOCKED)) {
      door.setClosed(false);
    } else {
      System.out.println("Can't open door " + door.getId() + " because it's already open");
    }
  }

  public void close() {
    if (!door.isClosed()) {
      door.setClosed(true);
    } else {
      System.out.println("Can't close door " + door.getId() + " because it's already closed");
    }
  }

  public void lock() {
    if (door.isClosed()) {
      door.setState(new Locked(door));
    } else {
      System.out.println("Can't lock door " + door.getId() + " because it's open");
    }
  }

  public void unlock() {
    System.out.println("Can't unlock door " + door.getId() + " because it's already unlocked");
  }

  public void unlockShortly() {
    System.out.println("Can't unlock_shortly door " + door.getId() + " because it's already unlocked");
  }
}

