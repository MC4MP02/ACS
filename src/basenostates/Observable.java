package basenostates;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Iterator;

abstract class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();
    private boolean changed = false;

    protected boolean deteniendoReloj = false;

    public boolean isChanged() {
        return changed;
    }
    public synchronized void addObserver(Observer ob) {
        if (!observers.contains(ob)) {
            observers.add(ob);
        }
    }

    public synchronized void deleteObserver(Observer ob) {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer obs = iterator.next();
            if (obs == ob) {
                iterator.remove();
            }
        }
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public synchronized void notifyObservers(Long dateTime) {
        if(isChanged()) {
            Iterator<Observer> iterator = new ArrayList<>(observers).iterator();
            while (iterator.hasNext()) {
                Observer ob = iterator.next();
                if (deteniendoReloj) {
                    break;
                } else {
                    ob.update(this, dateTime);
                }
            }
        }
    }
}
