//import javafx.beans.binding.When;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CharBuilder extends ApplicationFrame { //implements Observer {

    //private Subject subject;
    private ArrayList<TemperatureSensor> temperatureList;


    public CharBuilder(ArrayList<TemperatureSensor> temperatureList, String applicationTitle, String chartTitle) {
        super(applicationTitle);

        //Werte für Char
        this.temperatureList=temperatureList;


        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Datum und Uhrzeit", "Temperatur in °C",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);





        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        setContentPane(chartPanel);


    }


/*
    public void update(ArrayList<TemperatureSensor> l)
    {
        this.temperatureList=l;
    }
*/



    public DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (temperatureList != null) {
            for (TemperatureSensor s : temperatureList) {

                dataset.addValue(s.getTemperature(), "Temperaturverlauf", s.getTimestamp());

            }
        }

        return dataset;

    }


}
