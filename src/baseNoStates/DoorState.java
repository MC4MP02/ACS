package baseNoStates;

abstract class DoorState{
  protected Door door;
  protected String name;

  public DoorState(Door door) {
    this.door=door;
  }
  public abstract void open();
  public abstract void close();
  public void lock() {

  }
  public void unlock() {

  }
}
