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

        @Override
        public void update(ArrayList<TemperatureSensor> l) {

            this.temperatureList = l;
            //WeatherStation w = ((WeatherStation) subject);
            /*WeatherStation w = new WeatherStation();
            temperatureList = w.getTemperaturelist();
            w.fillTemperaturelist();
            */
            //setTemperature();

        }

        public void printChart()
        {
            this.chart = new CharBuilder( temperatureList,
                    "Auswertung" ,
                    "Auswertung Temperatur");

            chart.pack( );
            RefineryUtilities.centerFrameOnScreen( chart );
            chart.setVisible( true );
        }

        public void updadeChart()
        {
            chart.createDataset();
            chart.repaint();
        }

}