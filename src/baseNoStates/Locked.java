package baseNoStates;

import java.util.Timer;
import java.util.TimerTask;

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
  public void unlock_shorty() {
    if(name.equals(States.LOCKED)) {
      name = States.UNLOCKED_SHORTLY;
      door.setState(new UnlockedShortly(door));
      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          door.setState(new Locked(door));
        }
      }, 10000);
    }
    else {
      System.out.println("Can't unlock_shortly door " + door.getId() + " because it's already unlock");
    }
  }
}

