import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.util.ArrayList;

public class TemperatureObserver implements Observer {

        //private Subject subject;
        private ArrayList<TemperatureSensor> temperatureList;

        CharBuilder chart;

/*
    public TemperatureObserver(Subject subject) {
            this.subject = subject;
        }
*/
        public TemperatureObserver()
        {}


    /**
     * Wird aufgerufen wenn sich das konkrete Subjekt verändert hat (in diesem Beispiel ist dies die WetterStation)
     * @param l ArrayListe mit TemperaturSensor Werten
     */
    @Override
    public void update(ArrayList<TemperatureSensor> l) {

            this.temperatureList = l;
        }

    /**
     * Chart erstellen
     */
    public void printChart()
        {
            this.chart = new CharBuilder( temperatureList,
                    "Auswertung" ,
                    "Auswertung Temperatur");

            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }


}