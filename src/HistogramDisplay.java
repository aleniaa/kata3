
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.ui.ApplicationFrame;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class HistogramDisplay extends ApplicationFrame {

    final private Histogram<String> histogram; 
    
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram=histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
       ChartPanel chartPanel= new ChartPanel(createChart(createDataset())); 
       setPreferredSize(new Dimension(500,400));
       return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart= ChartFactory.createBarChart("Histograma JFreeChart","Dominios email","Nº de emails",
                dataSet,PlotOrientation.VERTICAL,false,false,rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet= new DefaultCategoryDataset();
        /*dataSet.addValue(10,"","ulpgc.es");
        dataSet.addValue(3,"","gmail.com");
        dataSet.addValue(5,"","yahoo.com");
        dataSet.addValue(7,"","boh.com");*/
        
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key),"",key);
            
        }
        
        return dataSet;
    }
}
