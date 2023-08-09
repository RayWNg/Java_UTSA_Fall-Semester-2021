/**
 * @(#)SalesSystem.java
 * @author Raymond Ng
 * @version 1.00 2021/11/13 9:00AM
 *
 * PROGRAM PURPOSE: Program accepts a customer's
 * orders for hammocks. The customer gets a discount
 * based on the order total (size). A sales receipt
 * will be generated. Additionally, a hammock sales
 * report will be generated and writes hammock sales
 * records to a file. This portion of the program
 * contains the logic of SalesSystem. Starts by
 * calling processSales() which requests inputs
 * and displays receipt. Once an order is processed
 * it is saved on a text file which can be retrieved.
 */


import java.util.Scanner;     //By Raymond Ng: Scanner for accessing standard input
import java.util.Calendar;    //By Raymond Ng: Calendar to provide date functions
import java.util.ArrayList;   //By Raymond Ng: Resizeable array
import java.io.File;          //By Raymond Ng: provides an abstract representation of files and directories
import java.io.PrintWriter;   //By Raymond Ng: Prints formatted representations of objects to a text-output stream.
import java.io.IOException;   //By Raymond Ng: Signals that an I/O exception of some sort has occurred


/**
  * By Raymond Ng: This class contains the logic of SalesSystem.
  * Begins by calling processSales(), requesting inputs and
  * displays receipt. Once an order is processed it is saved on
  * a text file which can be retrieved.
  */
public class SalesSystem 
{
    private Hammock hammmockSales[];  //By Raymond Ng: store hammock sales records
    private Scanner scanner;  //By Raymond Ng: used to access standard input
    private Calendar dateTime = Calendar.getInstance();  //By Raymond Ng: get current date and time
    private ArrayList<String> hammockReport = new ArrayList<>() ;  //By Raymond Ng: create an empty Arraylist for hammock report
    private String fileName;  //By Raymond Ng: name of file to save report
    private char cont = 'y';  //By Raymond Ng: used to check if the receipt should be written to a file
    private double subtotal;  //By Raymond Ng: subtotal of purchased hammocks
    private double discount;  //By Raymond Ng: discount on subtotal

    /**
     * By Raymond Ng: Starts the ordering process. It
     * calls the processSales() and writes hammock
     * records to a file then reads the file.
     * @throws IOException
     */
    public void start() throws IOException
    {
        this.processSales();  //By Raymond Ng: start processing a sale
        
        if(this.cont == 'y')
        {
            this.writeHammockRecords();  //By Raymond Ng: save records to file
            this.checkInputFile();  //By Raymond Ng: retrieve records from file
        }//By Raymond Ng: END if
        
    }//By Raymond Ng: END start(): void

    
    /**
     * By Raymond Ng: Process sales and displays receipt.
     * Main driver method which calls the other methods.
     */
    public void processSales() 
    {
        double itemTotal,     //By Raymond Ng: variable to hold item total (itemTotal)
               tax,           //By Raymond Ng: variable to hold tax
               discSubtotal,  //By Raymond Ng: variable to hold discounted subtotal (discSubtotal)
               total,         //By Raymond Ng: variable to hold total
               discRate;      //By Raymond Ng: variable to hold discount rate (discRate)
        
        String salesReceipt = " ";  //By Raymond Ng: string to store hammock sale to receipt
        
        int size;  //By Raymond Ng: number of separate Hammock sales
        
        scanner = new Scanner(System.in);  //By Raymond Ng: string to store user input
        
        System.out.printf("%nHow many separate Hammock sales will be made? ");
        
        while (true) 
        {
            String input = scanner.nextLine();  //By Raymond: string to store user input
            
            try
            {
                size = Integer.parseInt(input);  //By Raymond Ng: convert string to integer
                break;  //By Raymond Ng: stop loop
            }//By Raymond Ng: END try
            catch (Exception e)  //By Raymond Ng: in case of any error in conversion display error message
            {
                System.out.printf("Invalid integer! Re-enter the number of hammock sales to be made: !%n");
            }//By Raymond Ng: END catch
        }//By Raymond Ng: END while
        
        hammmockSales = new Hammock[size];  //By Raymond Ng: an array to hold all the hammock sales made per order
        
        for (int i = 0; i < size; i++)
        {
            Hammock hammock = new Hammock();  //By Raymond Ng: an instance of hammock
            hammock.setHammockChoice(Integer.toString(i + 1));
            hammock.setHammockDescPrice();
            hammock.setQuantity();
            hammock.setColorChoice();
            hammock.setHammockColor();
            hammmockSales[i] = hammock;
            itemTotal = hammock.calcItemTotal();
            subtotal += itemTotal;  //By Raymond Ng: add itemTotal to subtotal
            
            /**
             * By Raymond Ng: Add a dollar sign on the first hammock
             * in salesReceipt
             */
            if (i == 0)
            {
                salesReceipt = String.format("%-25s - %-20s %,10d %s%,14.2f",
                                             hammock.getHammockDesc(), 
                                             hammock.getHammockColor(), 
                                             hammock.getQuantity(), "$", 
                                             hammock.getPrice() * hammock.getQuantity());
            }//By Raymond Ng: END if
            /**
              * By Raymond Ng: else do not add a dollar sign
              */
            else
            {
                salesReceipt = String.format("%-25s - %-20s %,10d %s%,14.2f",
                                             hammock.getHammockDesc(), 
                                             hammock.getHammockColor(), 
                                             hammock.getQuantity(), " ", 
                                             hammock.getPrice() * hammock.getQuantity());
            }//END else
            
            hammockReport.add(salesReceipt);  //By Raymond Ng: add receipt to sales report ArrayList
            
        }//By Raymond Ng: END for loop
        
        determineDiscount();  //By Raymond Ng: calls determineDiscount() to calculate discount        
        discSubtotal = subtotal - discount;  //By Raymond Ng: discounted subtotal   
        tax = 0.0825 * discSubtotal;  //By Raymond Ng: calculate tax
        total = discSubtotal + tax;  //By Raymond Ng: calculate total
        discRate = discount / subtotal * 100;  //By Raymond Ng: calculate discRate
        
        System.out.printf("%n%nSALES RECEIPT"
                          + "%nLAZY HAZY DAYS, INC."
                          + "%nHuebner Oaks Mall"
                          + "%nSan Antonio, TX"
                          + "%n%nDate:  %tD"
                          + "%nTime:  %tr%n%n", dateTime, dateTime);  //By Raymond Ng: show receipt header
        
        int i = 0;
        
        for (String record: hammockReport) 
        {
            if(i < hammockReport.size() - 1)
            {
                System.out.println(record);
            }//END if
            
            i++;
            
        }//By Raymond Ng: END for
        
        System.out.printf("%s"
                          + "%n%n%52s %-6s $%,14.2f"
                          + "%n%52s %-7s %,14.2f"
                          + "%n%52s %-7s %,14.2f"
                          + "%n%n%52s %-6s $%,14.2f%n", 
                          salesReceipt, "SUBTOTAL:", "  ",
                          subtotal, "DISCOUNT:", "  ",
                          discount, "TAX @ 8.250%:",
                          "  ", tax, "TOTAL:", "  ", total);
        
    }//By Raymond Ng: END processSales(): void

    /**
     * By Raymond Ng: Contains the test that calculates the discount
     * based on the subtotal
     */
    public void determineDiscount() 
    {
        if(subtotal >= 100000)
        {
            discount = 0.035 * subtotal;
        }//By Raymond Ng: END if subtotal >= 100000 3.5% discount
        else if (subtotal >= 50000)
        {
            discount = 0.03 * subtotal;
        }//By Raymond Ng: END else if subtotal >= 50000 3% discount
        else if(subtotal >= 10000)
        {
            discount = 0.025 * subtotal;
        }//By Raymond Ng: END else if subtotal >= 10000 2.5% discount
        else if (subtotal >= 5000)
        {
            discount = 0.02 * subtotal;
        }//By Raymond Ng: END else if subtotal >= 5000 2% discount
        
    }//By Raymond Ng: END determineDiscount(): void
    
    /**
      * By Raymond Ng: Creates a text file with sales reports
      * @throws IOException
      */
    public void writeHammockRecords() throws IOException 
    {
        System.out.printf("%nEnter the file name for the hammock sales records " 
                          + "(WARNING: This will erase a pre-existing file!):  ");
        
        scanner = new Scanner(System.in);
        
        fileName = scanner.nextLine() + ".txt"; //By Raymond Ng: append txt prefix to filename
        
        PrintWriter outputFile = new PrintWriter(fileName);
        
        for(int i = 0; i < hammmockSales.length; i++)
        {//By Raymond Ng: loop through sales to create a saved txt file
            String record = String.format("%n%s, %s, %,d, %.2f%n", 
                                          hammmockSales[i].getHammockDesc(), 
                                          hammmockSales[i].getHammockColor(), 
                                          hammmockSales[i].getQuantity(), 
                                          hammmockSales[i].getPrice());
            
            outputFile.println(record);
            
        }//By Raymond Ng: END for loop
        
        outputFile.close();
        
        System.out.printf("%nData written to " + fileName + " file.%n");
        
    }//By Raymond Ng: END writeHammockRecords(): void
    
    /**
      * By Raymond Ng: Opens and displays a text file with sales report
      * @throws IOException
      */
    public void checkInputFile() throws IOException 
    {
        System.out.printf("%nEnter the name for the hammock sales records file:  ");
        
        String name = scanner.nextLine() + ".txt";  //By Raymond Ng: show prompt to input file name
        
        File file = new File(name);  //By Raymond Ng: File object containing the opened file
        
        Scanner inputFile = new Scanner(file);  //By Raymond Ng: read file using scanner
        
        while(inputFile.hasNext())
        { //By Raymond Ng: loop through the file printing new lines
          
            String fileRecord = inputFile.nextLine();
            
            System.out.println(fileRecord);
            
        }//By Raymond Ng: END while loop
        
        scanner.close(); //By Raymond Ng: close scanner stream
        
    }//END checkInputFile(): void
    
}//END SalesSystem()
