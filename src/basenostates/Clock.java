package basenostates;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Observable {
    private Timer timer = new Timer();
    private Long dateTime;

    private boolean relojIniciado = false;
    private boolean deteniendoReloj = false;

    private static Clock instance = null;

    private Clock() {
        this.timer = new Timer();
    }

    public void iniciarReloj() {
        if(!relojIniciado) {
            this.timer = new Timer();
            this.timer.scheduleAtFixedRate(new ClockTask(), 0,
                    1000);
            relojIniciado = true;
        }

    }

    private class ClockTask extends TimerTask {
        @Override
        public void run() {
            setChanged(true);
            notifyObservers(System.currentTimeMillis());
            setChanged(false);
        }
    }

    public void stopClock() {
        if (relojIniciado) {
            deteniendoReloj = true;
            this.timer.cancel();
            relojIniciado = false;
            deteniendoReloj = false;
        }
    }

    public boolean isDeteniendoReloj() {
        return deteniendoReloj;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }
}
