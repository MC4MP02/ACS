package basenostates;

/**
 *Unlocked shortly class, we use that class when
 *we want to unlock the door for a short period of time.
 */
public class UnlockedShortly extends DoorState {
  //basic class constructor
  public UnlockedShortly(final Door door) {
    super(door);
    setName(States.UNLOCKED_SHORTLY);
  }
  //we open the door in the Unlocked_shortly state
  public void open() {
    if (door.isClosed()) {
      door.setClosed(false);
    } else {
      System.out.println("Can't open door " + door.getId() + " because it's already open");
    }
  }

  /**
   * we close the door in the unlocked_shortly state.
   */

  public void close() {
    if (!door.isClosed()) {
      door.setClosed(true);
    } else {
      System.out.println("Can't close door " + door.getId() + " because it's already closed");
    }
  }

  /**
   * the door is unlocked shortly,
   * it will lock automatically after 10 s.
   */

  public void lock() {
    System.out.println("Can't lock the door " + door.getId() + " because it's already locked");
  }
  /**
   * the door is unlocked, we cant unlock it.
   */
  public void unlock() {
    System.out.println("Can't unlock door " + door.getId() + " because it's already unlocked");
  }
  public void unlockShortly() {
    System.out.println("Can't unlock_shortly door " + door.getId() + " because it's already unlocked");
  }
}
