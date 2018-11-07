import java.util.ArrayList;

public interface Subject {

    /**
     * Observer in die Observerliste hinzufügen
     * @param o Observer, welcher hinzugefügt werden soll
     */
    public void registerObserver(Observer o);

    /**
     * Observer aus der Observerliste löschen
     * @param o Observer, welcher gelöscht werden soll
     */
    public void deregisterObserver(Observer o);

    /**
     * Observer benachrichtigen
     * @param l ArrayList mit den aktuellen Temperaturwerten
     */
    public void notifyObserver(ArrayList<TemperatureSensor> l);

}