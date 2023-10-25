package baseNoStates;

import java.util.Timer;
import java.util.TimerTask;

//Extend of the abstract class DoorState. It indicates that the door is locked
//When the door is locked we can't open it
public class Locked extends DoorState {

  private static int timeUnlocked = 10000;

  // sets the state of the door to Locked
  public Locked(Door door) {
    super(door);
    setName(States.LOCKED);
  }

  // If we try to open in Locked state, an error will appear
  public void open() {
    System.out.println("Can't open the door " + door.getId() + " because it's locked");
  }

  // If we try to close in Locked state, an error will appear
  public void close() {
    System.out.println("Can't close the door " + door.getId() + " because it's locked");
  }

  // If we try to lock in Locked state, an error will appear because it's already
  // locked
  public void lock() {
    System.out.println("Can't lock the door " + door.getId() + " because it's already locked");
  }

  // We can unlock the door and we change the state to Unlocked
  public void unlock() {
    if (name.equals(States.LOCKED)) {
      name = States.UNLOCKED;
      door.setState(new Unlocked(door));
    } else {
      System.out.println("Can't unlock door " + door.getId() + " because it's already unlock");
    }
  }

  // We can unlock shortly (10 seconds) the door so we change the state to
  // unlocked_shortly
  // Then a timer will start for 10 seconds, after this time the function will
  // check if the door is open or closed
  public void unlock_shortly() {
    if (name.equals(States.LOCKED)) {
      name = States.UNLOCKED_SHORTLY;
      door.setState(new UnlockedShortly(door));
      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          if (door.isClosed()) { // if the door is closed the new state will be Locked
            door.setState(new Locked(door));
          } else {
            door.setState(new Propped(door)); // if the door is open the new state will be Propped
          }
        }
      }, timeUnlocked);
    } else {
      System.out.println("Can't unlock_shortly door " + door.getId() + " because it's already unlock");
    }
  }
}
