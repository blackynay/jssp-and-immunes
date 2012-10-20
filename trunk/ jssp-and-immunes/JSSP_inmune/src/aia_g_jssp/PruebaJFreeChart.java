package aia_g_jssp;

import java.awt.Color;
import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class PruebaJFreeChart {
 
    private static Color COLOR_SERIE_1 = new Color(255, 128, 64);
 
    private static Color COLOR_SERIE_2 = new Color(28, 84, 140);
 
    private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);
 
    private static Color COLOR_FONDO_GRAFICA = Color.white;
 
    public JFreeChart crearGrafica(XYSeriesCollection dataset) {
 
        final JFreeChart chart = ChartFactory.createXYLineChart("Tiempos de entrenamientos", "Vuelta", "Tiempo (segundos)",
                dataset,
                PlotOrientation.VERTICAL,
                true, // uso de leyenda
                false, // uso de tooltips 
                false // uso de urls
                );
        // color de fondo de la gráfica
        chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);
 
        final XYPlot plot = (XYPlot) chart.getPlot();
        configurarPlot(plot);
 
        final NumberAxis domainAxis = (NumberAxis)plot.getDomainAxis();
        configurarDomainAxis(domainAxis);
         
        final NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
        configurarRangeAxis(rangeAxis);
 
        final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        configurarRendered(renderer);
 
        return chart;
    }
     
    // configuramos el contenido del gráfico (damos un color a las líneas que sirven de guía)
    private void configurarPlot (XYPlot plot) {
        plot.setDomainGridlinePaint(COLOR_RECUADROS_GRAFICA);
        plot.setRangeGridlinePaint(COLOR_RECUADROS_GRAFICA);
    }
     
    // configuramos el eje X de la gráfica (se muestran números enteros y de uno en uno)
    private void configurarDomainAxis (NumberAxis domainAxis) {
        domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        domainAxis.setTickUnit(new NumberTickUnit(1));
    }
     
    // configuramos el eje y de la gráfica (números enteros de dos en dos y rango entre 120 y 135)
    private void configurarRangeAxis (NumberAxis rangeAxis) {
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setTickUnit(new NumberTickUnit(2));
        rangeAxis.setRange(120, 135);
    }
     
    // configuramos las líneas de las series (añadimos un círculo en los puntos y asignamos el color de cada serie)
    private void configurarRendered (XYLineAndShapeRenderer renderer) {
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesPaint(0, COLOR_SERIE_1);
        renderer.setSeriesPaint(1, COLOR_SERIE_2);
    }
    public static final int ANCHO_GRAFICA = 400;
    
    public static final int ALTO_GRAFICA = 300;
     
    public static void main(String args[]) {
     
        final XYSeries serie1 = new XYSeries("Fernando Alonso");
        serie1.add(1, 131.78);
        serie1.add(2, 129.95);
        serie1.add(3, 128.16);
        serie1.add(4, 125.91);
        serie1.add(5, 130.44);
         
        final XYSeries serie2 = new XYSeries("Jaime Alguersuari");
        serie2.add(1, 133.16);
        serie2.add(2, 132.32);
        serie2.add(3, 129.86);
        serie2.add(4, 128.02);
        serie2.add(5, 132.45);
         
        final XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(serie1);
        collection.addSeries(serie2);
         
        try {
            final PruebaJFreeChart prueba = new PruebaJFreeChart();
            final JFreeChart grafica = prueba.crearGrafica(collection);
            ChartUtilities.saveChartAsPNG(new File("tiempos-entrenamientos.png"), grafica, ANCHO_GRAFICA, ALTO_GRAFICA);
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }
     
}