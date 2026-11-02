import java.util.Scanner;
import java.io.*;

/**
 * Driver class for SalesAnalysis
 *
 * @author Andrew Lam, alam001@student.sdccd.edu
 * @version v1.0
 * @since 11/1/2026
 */
public class SalesAnalysisDemo{
public static void main(String[] args) throws IOException{
    String fileName;
        
    Scanner keyboard = new Scanner(System.in);
        
    System.out.print("Enter the path to the SalesData.txt file: ");
        
    fileName = keyboard.nextLine();
    
    System.out.println();
    
    File file;
        
    file = new File(fileName);
    while (!file.exists()){
            
        System.out.print("Enter the name of the input file (ie input.txt): ");
            

        fileName = keyboard.nextLine();
            

        file = new File(fileName);
            
    }
    //While loop to check if the file exists
    
    SalesAnalysis salesTech = new SalesAnalysis(fileName);
    
    salesTech.processFile();
    salesTech.writeOutput();
}
    
}
