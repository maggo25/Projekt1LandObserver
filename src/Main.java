import com.lowagie.text.DocumentException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<TemperatureSensor> al = new ArrayList<>();

        WeatherStation w = new WeatherStation();

        al = w.getTemperaturelist();

        Observer t1 = new TemperatureObserver();
        Observer t2 = new PDFGenerator();


        Timestamp temp = new Timestamp(System.currentTimeMillis());
        long time = temp.getTime();
        File file = new File("c:\\test\\test.csv");


        w.fillTemperaturelist();
        w.registerObserver(t1);
        w.registerObserver(t2);
        //w.notifyObserver(al);

        //((TemperatureObserver) t).printChart();

        //TimeUnit.SECONDS.sleep(10);


        Scanner scan = (new Scanner(System.in));

        String s = "-";
        while (!s.equals("4")) {

            System.out.println("1) File Datum checken und Chart sowie PDF generieren falls sich das Dokument verändert hat");
            System.out.println("2) PDF erstellen");
            System.out.println("3) Chart generieren");
            System.out.println("4) beenden");
            System.out.println("");
            s = scan.nextLine();
            switch (s) {
                case "1":
                    if (file.lastModified() > time) {
                        w.fillTemperaturelist();;
                        al = w.getTemperaturelist();
                        w.notifyObserver(al);
                        temp = new Timestamp(System.currentTimeMillis());
                        time = temp.getTime();

                        ((TemperatureObserver) t1).printChart();
                        ((PDFGenerator) t2).generatePdf();

                    }else
                    {
                        System.out.println("Das File hat sich nicht verändert!");
                    }
                    break;
                case "2":
                    if (file.lastModified() > time) {
                        w.fillTemperaturelist();;
                        al = w.getTemperaturelist();
                        w.notifyObserver(al);
                        temp = new Timestamp(System.currentTimeMillis());
                        time = temp.getTime();
                    }
                    ((PDFGenerator) t2).generatePdf();

                    break;
                case "3":
                    if (file.lastModified() > time) {
                        w.fillTemperaturelist();;
                        al = w.getTemperaturelist();
                        w.notifyObserver(al);
                        temp = new Timestamp(System.currentTimeMillis());
                        time = temp.getTime();
                    }
                    ((TemperatureObserver) t1).printChart();
                    break;
                case "4":
                    System.out.println("Aufwiedersehen!");
                    break;
                default:
                    break;

            }
        }
    }
}

