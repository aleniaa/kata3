public class Kata3 {
        
    public static void main(String[] args){
    
    Histogram<String> histogram= new Histogram<>();
    histogram.increment("gmail.com");
    histogram.increment("gmail.com");
    histogram.increment("hotmail.com");
    histogram.increment("gmail.com");
    histogram.increment("ulpgc.es");
    new HistogramDisplay(histogram).execute();
    }
}
