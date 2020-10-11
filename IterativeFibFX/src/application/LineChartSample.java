/*Program: Recursive Fibonaaci Function
 * Author: Jarett Wright
 * Class: Software Development 1
 * Due Date: 10/11/2020
 * Description: This program runs through the first 20 numbers in the Fibonaaci Function using the Iterative
 * method. Then, displays the number and time in nanoseconds using a JavaFX line chart.
 * 
 */


package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class LineChartSample extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Fibonacci Function");
        // Establish X and Y Axis
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Fibonacci Numer");
        yAxis.setLabel("Time in NanoSeconds");
        // Create Chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Iterative Fibonaaci");
        // Define Series for Storing Number and Time
        XYChart.Series series = new XYChart.Series();
        series.setName("Number and Time");
        
        // Populate Data
        int n = 0;  //Starting Number
		for(int i = 0; i < 20; i++)
		{
			System.out.println("n = " + n); // Print Statement to Verify N Input
			System.out.println("Fib Num = " + fib(n)); // Print Statement to Verify Fibonaaci Number
			long startTime = System.nanoTime();
			System.out.println("nano = "+ startTime); // Print Statement to Verify Time
			series.getData().add(new XYChart.Data(fib(n), startTime));  // Populate Results
			n = n + 1;
		}
        
		// Establish GUI Scene Details
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }

// Method to Calculate Fibonaaci Number
    public static int fib(int nNum) {
        //use loop
        int prePreNum, preNum = 0, curNum = 1;

        for (int i = 1; i < nNum ; i++) {
            prePreNum = preNum;
            preNum = curNum;
            curNum = prePreNum + preNum;
        }
        return curNum;
    }}