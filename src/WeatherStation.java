//import javax.xml.transform.sax.SAXSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.Locale;

public class WeatherStation implements Subject {

    private ArrayList<Observer> observerlist;
    private ArrayList<TemperatureSensor> temperaturelist;


    public WeatherStation() {
        observerlist = new ArrayList<>();
        temperaturelist = new ArrayList<>();
    }



    public void registerObserver(Observer o) {
        observerlist.add(o);
        this.notifyObserver(this.temperaturelist);
    }

    public void deregisterObserver(Observer o) {
        observerlist.remove(o);
    }

    public void notifyObserver(ArrayList<TemperatureSensor> l) {
        for (Observer o : observerlist) {
            o.update(l);
        }
    }

    public ArrayList<TemperatureSensor> getTemperaturelist() {
        return temperaturelist;
    }


    public void printTemperatureList() {
        for (TemperatureSensor s : temperaturelist) {
            System.out.println("Temperatur: " + s.getTemperature());
            System.out.println("Zeit: " + s.getTimestamp());
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
    }

    public void removeAllFromTemperaturlist()
    {

        Iterator<TemperatureSensor> it = temperaturelist.iterator();
        while (it.hasNext()) {
            TemperatureSensor t = it.next();
            it.remove();
        }

    }

    public void fillTemperaturelist() {

            if (temperaturelist != null)
            {
                removeAllFromTemperaturlist();
            }

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/test/test.csv"));
            String zeile = null;
            while ((zeile = br.readLine()) != null) {
                //String zeile = br.readLine();
                String[] teile = zeile.split(";");

                temperaturelist.add(new TemperatureSensor(teile[0], Double.parseDouble(teile[1])));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Leider hat es nicht geklappt! \n Vermutlich ist das File nicht vorhanden oder fehlerhaft.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fehlerhaftes File!");


        }

    }

/*

    SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN);
                s.parse(teile[0]);

*/
}