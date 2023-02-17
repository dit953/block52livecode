package NoObserverPattern.signal;

/**
 * Created by Niklas on 2016-02-22.
 */
public class Signal implements Runnable {

    private enum Speed {
        SUPERSLOW, SLOW, NORMAL, FAST, SUPERFAST;

        private static final Speed[] vals = values();
        public Speed up() { return vals[Math.min(this.ordinal()+1, vals.length-1)]; }
        public Speed down() { return vals[Math.max(this.ordinal()-1, 0)]; }
    }

    private SignalStatus status = SignalStatus.RED;
    private Speed speed = Speed.NORMAL;
    private final SignalView view;
    public Signal(SignalView view) {
        this.view = view;
    }

    public void speedUp(){
        speed = speed.up();
    }
    public void slowDown(){
        speed = speed.down();
    }

    public void run(){
        while (speed != null) {
            try {
                longWait();
                nextStatus();
                shortWait();
                nextStatus();
            } catch (InterruptedException e) {
                speed = null;
                System.exit(0);
            }
        }
    }
    private void longWait() throws InterruptedException {
        Thread.sleep(4000/(speed.ordinal()+1));
    }
    private void shortWait() throws InterruptedException {
        Thread.sleep(400);
    }
    private void nextStatus(){
        status = status.next();
        view.actOnSignalChange(status);
    }

}
