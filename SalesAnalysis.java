import java.util.Scanner;
import java.io.*;

/**
 * An object SalesAnalysis with a file with sales data to process and 
 * analyze the totals and averages for the weeks
 *
 * @author Andrew Lam, alam001@student.sdccd.edu
 * @version v1.0
 * @since 11/1/2026
 */
public class SalesAnalysis
{
    private static final int WEEKS_IN_MONTH = 4;
    private double[] weeklyNumber;
    private String inputFile;
    private int lineNumber = 0;

    /**
     * Create an object SalesAnalysis with inputted file name
     * 
     * @param userFile Name of the file to open
     */
    public SalesAnalysis(String userFile)
    {
        inputFile = userFile;
        weeklyNumber = new double[WEEKS_IN_MONTH];
        
    }

    /**
     * Reads and processes the sales data from the sales file
     *
     */
    public void processFile() throws IOException
    {
        String fileInfo;
        String[] tokens;
        
        File salesFile = new File(inputFile);
        Scanner scanFile = new Scanner(salesFile);
        
        while(scanFile.hasNextLine()){
            
            fileInfo = scanFile.nextLine();
            
            tokens = fileInfo.split(",");
            
            setArrayElement(tokens);
            
        }
        
        scanFile.close();
        
    }

    /**
     * Find the total for each week and set that to its respective index in
     * weeklyNumber. Index 0 is week 1, index 1 is week 2, etc.
     *
     * @param  inArray Double array from sales file for one week
     */
    private void setArrayElement(String[] inArray)
    {
        double total = 0;
        
        for (String i : inArray){
            
            total += Double.parseDouble(i);
            
        }
        
        weeklyNumber[lineNumber] = total;
        
        lineNumber++;
        
    }
    
    /**
     * Prints output to the screen about the total and average for each week
     * and the entire total, average, min, and max for all of the weeks
     *
     */
    public void writeOutput()
    {
        double min = weeklyNumber[0];
        double max = weeklyNumber[0];
        int minWeek = 0, maxWeek = 0;
        double totalSales = 0; 
        double averageSales;
        
        for (int i = 0; i < WEEKS_IN_MONTH; i++){
            
            totalSales += weeklyNumber[i];
    
            if (weeklyNumber[i] < min){
                min = weeklyNumber[i];
                minWeek = i+1;
            }
            
            if (weeklyNumber[i] > max){
                max = weeklyNumber[i];
                maxWeek = i+1;
            }
        
            System.out.printf("Week%d Info\n", (i+1));
            System.out.printf("Total Sales: $%.2f\n", weeklyNumber[i]);
            
            averageSales = weeklyNumber[i] / 7.0;
            
            System.out.printf("Avg Daily Sales for Week: $%.2f\n", averageSales);
            
            System.out.println();
            
            
        }
        
        System.out.printf("Total Sales for all Weeks: $%.2f\n", totalSales);
        averageSales = totalSales / (double) WEEKS_IN_MONTH;
        
        System.out.printf("Avg Weekly Sales: $%.2f\n", averageSales);
        System.out.printf("Week%d had the highest amount of sales\n", maxWeek);
        System.out.printf("Week%d had the lowest amount of sales", minWeek);
        
        
        
    }
    
}