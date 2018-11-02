//import org.jfree.ui.RefineryUtilities;
//import java.util.ArrayList;


public class App {

    public static void main(String[] args) {

        WeatherStation w = new WeatherStation();
        System.out.println("++++++++++++++++++++++++");
        w.printTemperatureList();

        w.fillTemperaturelist();
        System.out.println("################");
        w.printTemperatureList();

        TemperatureObserver t = new TemperatureObserver();


        //t.update();
        t.printChart();




    }




}
