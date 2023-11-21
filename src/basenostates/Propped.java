package basenostates;
/**
 *Propped class, the door passes to propped state when the
 *door is unlocked_shortly during 10s, the door is open
 *and no one closes it.
 */
public class Propped extends DoorState {

  // class constructor
  public Propped(final Door doorId) {
    super(doorId);
    setName(States.PROPPED);
  }
  // open, close, lock and unlock function
  // for the propped state
  // we can't open the door because it's open,
  // can't unlock or lock it because it's propped
  // we can close it only
  public void open() {
    System.out.println("Can't open the door " + this.getDoor().getId() + " because it's already open");
  }

  public void close() {
    this.getDoor().setClosed(true);
    this.getDoor().setState(new Locked(this.getDoor()));
  }

  public void lock() {
    System.out.println("Can't lock the door " + this.getDoor().getId() + " because it's propped");
  }

  public void unlock() {
    System.out.println("Can't unlock the door " + this.getDoor().getId() + " because it's propped");
  }
  public void unlockShortly() {
    System.out.println("Can't unlock_shortly the door " + this.getDoor().getId() + " because it's propped"); }
}
