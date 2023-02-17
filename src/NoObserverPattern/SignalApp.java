package NoObserverPattern;

import NoObserverPattern.signal.*;

/**
 * Created by Niklas on 2016-02-23.
 */
public class SignalApp {

    public static void main(String[] args){
        Signal signal = new Signal(new SignalView());
        new Thread(signal).start();
    }
}
