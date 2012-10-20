package aia_g_jssp;


/*
 * GraficoSimpleLin.java
 *
 * Created on 3 de noviembre de 2008, 8:11
 */
import org.jfree.data.xy.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import java.awt.image.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import java.io.File;
import org.jfree.chart.plot.*;
import java.io.*;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author  Roberto Leon Cruz
 */
public class GraficoSimpleLin extends java.awt.Frame {

    BufferedImage grafica = null;

    //constructor
    public GraficoSimpleLin() {
        super("Makespan a lo largo de las generaciones ");
       
    }

   

    public BufferedImage creaImagen(int [] vector_datos)
    {
        //XYSeries es una clase que viene con el paquete JFreeChart
        //funciona como un arreglo con un poco mas de posibilidades
       
        XYSeries series = new XYSeries("titulo de la serie");
        //como su nombre lo indica el primer valor sera asignado al eje X
        //y el segundo al eje Y
        series.add(1, 23);
        series.add(2, 34);
        series.add(3, 51);
        series.add(4, 67);
        series.add(5, 89);
        series.add(6, 121);
        series.add(7, 137);
        //se crea un objeto XYDataset requerido mas adelante por el metodo que grafica
        XYDataset juegoDatos= new XYSeriesCollection(series);
       
                /*aqui se hace la instancia de la nueva grafica invocando al metodo de ChartFactory
                que nos dibujara una grafica de lineas este metodo como casi todos los demas
                recibe los siguientes argumentos:
               
                tipo              valor
                String            nombre de la grafica , aparecera en la parte superior centro
                String            tutulo del eje X
                String            titulo del eje Y
                XYDataset         el conjunto de datos X y Y del tipo XYDataset (aqui cambian el parametro
                                  dependiendo del tipo de grafica que se quiere pueden ver todos los parametros
                                  en la documentacion aqui <a href="http://www.jfree.org/jfreechart/api/javadoc/index.html
" title="http://www.jfree.org/jfreechart/api/javadoc/index.html
">http://www.jfree.org/jfreechart/api/javadoc/index.html
</a>                              iremos notando los cambios mas adelante..
                 PlotOrientation  la orientacion del grafico puede ser PlotOrientation.VERTICAL o PlotOrientation.HORIZONTAL
                 boolean                  muestra u oculta leyendas    
                 boolean                  muestra u oculta tooltips
                 boolean                  muestra u oculta urls (esta opcion aun no la entiendo del todo)
               
                generalmente solo necesitaremos cambiar los primeros 3 parametros lo demas puede quedarse asi
               
                */
        JFreeChart chart = ChartFactory.createXYLineChart        ("Makespan vs Generaciones",
        "Eje X","Eje Y",juegoDatos,PlotOrientation.VERTICAL,
        false,
        false,
        true                // Show legend
        );

        //donde guardaremos la imagen?? pues en un bufer jeje
        BufferedImage image = chart.createBufferedImage(400,400);
       
        return image;
    }

        //supongo que esto es demaciado obvio pero sino entienden pregunten...
    public void paint(java.awt.Graphics g) {
        //super.paint(g);

        if(grafica == null)
        {
            grafica = this.creaImagen();
        }
        g.drawImage(grafica,30,30,null);
    }

        /**
     * @param args the command line arguments
     *
     *solo nos resta invocar a nuestra grafica
     */
    public static void main(String args[]) {

        GraficoSimpleLin miventana = new GraficoSimpleLin();
        miventana.setSize(450,450);
        miventana.show();
    }

}
