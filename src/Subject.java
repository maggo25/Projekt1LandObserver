import java.util.ArrayList;

public interface Subject {

    public void registerObserver(Observer o);

    public void deregisterObserver(Observer o);

    public void notifyObserver(ArrayList<TemperatureSensor> l);

}