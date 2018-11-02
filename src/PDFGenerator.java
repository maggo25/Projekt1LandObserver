import java.awt.*;
import java.io.File;
import java.io.IOException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfRectangle;
import com.orsonpdf.PDFFont;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.w3c.dom.html.HTMLBaseFontElement;


import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class PDFGenerator implements Observer {

    //private Subject subject;
    private ArrayList<TemperatureSensor> temperatureList;


    @Override
    public void update(ArrayList<TemperatureSensor> l) {
        this.temperatureList=l;
    }
/*
    public PDFGenerator(Subject subject) {
        this.subject = subject;
    }
*/
    public PDFGenerator()
    {}

    public String temperaturlistToString()
    {
        String out = "Die Liste ist leer!";

        if (this.temperatureList !=null)
        {
            out = "";
            for (TemperatureSensor t: temperatureList)
            {
                out += " Datum: " +t.getTimestamp() + " Uhr | Temperatur: " + t.getTemperature()+"°C;";
            }
            return out;
        }
        return null;
    }

    public String[] listToArray()
    {
        String out = "keine Werte vorhanden!";
        int groesse = this.temperatureList.size();
        String[] liste = new String[groesse];
        String temp = temperaturlistToString();
        if (temp==null)
        {
            liste[0] = out;
            return liste;
        }
        else
        {
            for (int i = 0; i<groesse; i++)
            {

                return temp.split(";");

            }

        }
        return null;
    }

    public String arrayToString(int index, String[] a)
    {
        return a[index];
    }




    public void generatePdf() {

        PDDocument document = new PDDocument();

        PDPage page = new PDPage(PDRectangle.A4);



        document.addPage( page );
        PDFont font = PDType1Font.HELVETICA;
        PDPageContentStream contentStream = null;
        try {
            contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont( font, 22 );
            //contentStream.moveTextPositionByAmount( 100, 700 );
            //contentStream.drawString( "Hello World" );
            contentStream.newLineAtOffset(70, 770);
            contentStream.showText("Temperaturauswertung: ");
            contentStream.setFont(font, 15);
            contentStream.newLineAtOffset(0, -50);
            contentStream.showText("Temperaturliste:");
            contentStream.newLineAtOffset(0, -22);
            contentStream.setFont(font, 11);
            if (listToArray() != null) {
                for (int i = 0; i<listToArray().length; i++)
                {
                    contentStream.showText(""+arrayToString(i,listToArray()));
                    contentStream.newLineAtOffset(0, -18);
                }
            }

            contentStream.endText();
            contentStream.close();
            document.save( "C:/test/meinPDF.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*
        PDDocument document = new PDDocument();
        document.addPage(new PDPage());
        PDType1Font font = PDType1Font.HELVETICA_BOLD;
        try {

            document.save("C:/test/meinPDF.pdf");
            System.out.println("PDF created");
            document.close();
            File file = new File("C://test//meinPDF.pdf");
            PDDocument doc = document.load(file);
            PDPage page = doc.getPage(1);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            contentStream.beginText();
            contentStream.newLineAtOffset(25, 700);

            contentStream.setFont(font, 12);
            contentStream.showText("text");

            contentStream.endText();
            contentStream.close();
            doc.save("Path");
            doc.close();


        } catch (IOException e) {
            System.out.println("Es ist ein Fehler aufgetreten");
            e.printStackTrace();

        }
*/

    }



}
