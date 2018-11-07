import java.util.ArrayList;

/**
 * Interface um die konkrete Observer upzudaten
 * @author Markus
 */
public interface Observer {

    /**
     * Observer updaten -> aktuelle ArrayListe welche die TemperaturSensor Objekte beinnhaltet wird mitgeliefert
     * @param l ArrayListe mit den aktuellen Werten um die Observer upzudaten.
     */
    public void update(ArrayList<TemperatureSensor> l);
}
