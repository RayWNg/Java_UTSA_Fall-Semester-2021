/**
 * @(#)NgResendez003PA3.java
 * @author Raymond Ng
 * @version 1.00 2021/11/13 9:00AM
 *
 * PROGRAM PURPOSE: This is the application class.
 * Program accepts a customer's orders for hammocks. 
 * The customer gets a discount based on the order
 * total (size). A sales receipt will be generated.
 * Additionally, a hammock sales report will be generated
 * and writes hammock sales records to a file.
 * Further, program will check if records have been written.
 * This portion of the program contains the main(),
 * which will actually run the program. At the end of the
 * this program/class are sample outputs produced when 
 * application is run, per PA3 instructions.
 */

import java.io.IOException;  //By Raymond Ng: Signals that an I/O exception of some sort has occurred

/**
 * By Raymond Ng: This class acts as a the runner of 
 * the program as it contains the main()
 */
public class NgResendez003PA3 
{
    /**
     * By Raymond Ng: Entry point of the application
     * during runtime
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException 
    {
        SalesSystem system = new SalesSystem();  //By Raymond Ng: Creates an instance of SalesSystem class
        
        system.start();  //By Raymond Ng: Calls start method from SalesSystem class
        
        System.exit(0);  //By Raymond Ng: Exits the program
        
    }//By Raymond Ng: END main()
    
}//By Raymond Ng: END NgResendez003PA3




/*
 * SAMPLE OUTPUTS
 * 
 * LAZY HAZY DAYS, INC. 
 *
 * HAMMOCK SALES - LOW QUANTITY
 * 
How many separate Hammock sales will be made? 3
 
LAZY HAZY DAYS, INC. - Hammock 1 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  0
 
You entered an invalid hammock choice!  Try again! 
 
LAZY HAZY DAYS, INC. - Hammock 1 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  4
 
You entered an invalid hammock choice!  Try again! 
 
LAZY HAZY DAYS, INC. - Hammock 1 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  l
 
Re-enter a valid integer or floating-point value:  1
 
Enter the quantity:  Z
 
Re-enter a valid integer or floating-point value:  2
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  0
 
You entered an invalid color choice.  Try again! 
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  6
 
You entered an invalid color choice.  Try again! 
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  4
 
LAZY HAZY DAYS, INC. - Hammock 2 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  2
 
Enter the quantity:  100
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  2
 
LAZY HAZY DAYS, INC. - Hammock 3 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  3
 
Enter the quantity:  50
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  5
 
 
SALES RECEIPT 
LAZY HAZY DAYS, INC. 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:  11/22/21 
Time:  04:29:23 PM 
 
Small - 48 in. x 11 ft.   - Natural                       2 $        200.00 
Large - 55 in. x 13 ft.   - Emerald Green               100       14,000.00 
Deluxe - 60 in. x 13 ft.  - Purple Haze                  50        8,750.00 
 
                                           SUBTOTAL:        $     22,950.00 
                                           DISCOUNT:                 573.75 
                                       TAX @ 8.250%:               1,846.04 
 
                                              TOTAL:        $     24,222.29 
 
Enter the file name for the hammock sales records (WARNING: This will erase a pre-existing file!):  HammockSales
 
Data written to HammockSales.txt file. 
 
Enter the name for the hammock sales records file:  HammockSales
 
Small - 48 in. x 11 ft., Natural, 2, 100.00 
 
 
Large - 55 in. x 13 ft., Emerald Green, 100, 140.00 
 
 
Deluxe - 60 in. x 13 ft., Purple Haze, 50, 175.00 
 *
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * HAMMOCK SALES - LARGE QUANTITY
 * 
How many separate Hammock sales will be made? 3
 
LAZY HAZY DAYS, INC. - Hammock 1 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  1
 
Enter the quantity:  100000
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  4
 
LAZY HAZY DAYS, INC. - Hammock 2 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  2
 
Enter the quantity:  10000
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  1
 
LAZY HAZY DAYS, INC. - Hammock 3 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.   
 
1.  Small - 48 in. x 11 ft. - Good for 1 person    $100.00 
2.  Large - 55 in. x 13 ft. - Good for 2 people    $140.00 
3.  Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  3
 
Enter the quantity:  1000
 
1.  Crimson Red 
2.  Emerald Green 
3.  Indigo Blue 
4.  Natural 
5.  Purple Haze 
 
Enter your choice of colors:  5
 
 
SALES RECEIPT 
LAZY HAZY DAYS, INC. 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:  11/22/21 
Time:  04:32:18 PM 
 
Small - 48 in. x 11 ft.   - Natural                 100,000 $ 10,000,000.00 
Large - 55 in. x 13 ft.   - Crimson Red              10,000    1,400,000.00 
Deluxe - 60 in. x 13 ft.  - Purple Haze               1,000      175,000.00 
 
                                           SUBTOTAL:        $ 11,575,000.00 
                                           DISCOUNT:             405,125.00 
                                       TAX @ 8.250%:             921,514.69 
 
                                              TOTAL:        $ 12,091,389.69 
 
Enter the file name for the hammock sales records (WARNING: This will erase a pre-existing file!):  HammockSales
 
Data written to HammockSales.txt file. 
 
Enter the name for the hammock sales records file:  HammockSales
 
Small - 48 in. x 11 ft., Natural, 100,000, 100.00 
 
 
Large - 55 in. x 13 ft., Crimson Red, 10,000, 140.00 
 
 
Deluxe - 60 in. x 13 ft., Purple Haze, 1,000, 175.00 
 */