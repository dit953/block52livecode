package ObserverPattern;

import ObserverPattern.signal.*;
import ObserverPattern.signal.model.Signal;
import ObserverPattern.signal.model.SignalObserver;

/**
 * Created by Niklas on 2016-02-23.
 */
public class SignalApp {

    public static void main(String[] args){
        Signal signal = new Signal("Signal 1");
        Signal signal2 = new Signal("Signal 2");
        signal.addObserver(new SignalView());
        signal2.addObserver(new SignalView());
        SignalObserver logger = new SignalLogger();
        signal.addObserver(logger);
        signal2.addObserver(logger);
        new SpeedController(signal);
        new Thread(signal).start();
        new Thread(signal2).start();
    }
}
