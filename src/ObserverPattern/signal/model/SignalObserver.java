package ObserverPattern.signal.model;

/**
 * Created by Niklas on 2016-02-23.
 */
public interface SignalObserver {
    void actOnSignalChange(String name, SignalStatus newStatus);
}
