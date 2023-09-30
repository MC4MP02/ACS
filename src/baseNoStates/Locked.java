package baseNoStates;

public class Locked extends DoorState {

  public Locked(Door door) {
    super(door);
  }
  public void open() {

  }
  public void close() {

  }
  public void lock() {

  }
  @Override
  public void unlock() {
    super.unlock();
  }
  @Override
  public boolean canOpen() {
    return false; // Puertas bloqueadas no pueden abrirse
  }
}

