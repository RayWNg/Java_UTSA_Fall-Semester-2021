/**
 * @(#)Ng003PA2.java
 * @authors Raymond Ng and William Resendez
 * @version 1.00 2021/10/17 6:37PM
 *
 * PROGRAM PURPOSE: Create a program that accepts
 * a customer's orders for hammocks. The customer
 * gets a discount based on the order total (size).
 * A sales receipt will be generated.
 */
import java.util.Scanner;     //By Raymond Ng: CLASS THAT WILL CAPTURE INPUT.
import java.util.Calendar;    //by Raymond Ng: CLASS TO GET THE DATE AND TIME.

public class NgResendez003PA2 //By Raymond: Class name.
{
  
  private static Scanner input = new Scanner(System.in);      //By Raymond Ng: A Scanner object to process keyboard entries.
  private static Calendar dateTime = Calendar.getInstance();  //By Raymond Ng: Gets local dateTime based on local timezone.
  private static String salesReceipt;                         //By William Resendez: The private static String salesReceipt can be used by all methods inside NgResendez003PA2 class and its data cannot be accessed outside of this class.
  private static String hammockDesc;                          //By William Resendez: The private static String hammockDesc can be used by all methods inside NgResendez003PA2 class and its data cannot be accessed outside of this class.
  private static String colorSelected;                        //By William Resendez: The private static String colorSelected can be used by all methods inside NgResendez003PA2 class and its data cannot be accessed outside of this class.
  private static double price;                                //By William Resendez: The double price variable can be used by all methods of the class NgResendez003PA2, and its data cannot be accessed outside of this class. 
  private static boolean repeat;                              //By William Resendez: The boolean repeat can be used by all methods within the class NgResendez003PA2, its data cannot be accessed by other classes.
  
  public static void Ng003ResendezPA2()  //By William Resendez: Default Constructor.
  {
  }//By William Resendez: END of default Constructor
  
  public static void main(String[] args) //By Raymond Ng: Main method
  {
    
    int hammock = 0,   //By William Resendez: int hammock is initialized to 0.
      quantity = 0,    //By William Resendez: int quantity is initialized to 0.
      color = 0,       //By William Resendez: int color is initialized to 0.
      iterations = 1;  //By William Resendez: The int iterations is initialized to 1 in order for the program to cycle at least once for the user.
    
    double itemTotal = 0.0,  //By William Resendez: double itemTotal is initialized to 0.0
      subtotal = 0.0,        //By William Resendez: double subtotal is initialized to 0.0
      discount = 0.0,        //By William Resendez: double discount is initialized to 0.0
      discSubtotal = 0.0,    //By William Resendez: double discSubtotal is initialized to 0.0
      tax = 0.0,             //By William Resendez: double tax is initialized to 0.0
      total = 0.0,           //By William Resendez: double total is initialized to 0.0
      discRate = 0.0;        //By William Resendez: doubble discRate is initialized to 0.0
    
    char morePurchases = 'y';   //By Raymond Ng: char morePurchased is initialized to y
    
    boolean printFinal = false; //By Raymond Ng: boolean printFinal is initialized to false.
    
    salesReceipt = String.format("%n%nSALES RECEIPT"
                               + "%n%nLAZY HAZY DAYS, INC."
                               + "%nHuebner Oaks Mall"
                               + "%nSan Antonio, TX"
                               + "%n%nDate:  %tD"
                               + "%nTime:  %tr%n", dateTime, dateTime);  //By Raymond Ng: intialization of salesReceipt
    
    //By Raymond Ng: beginning of do-while loop//
    do
    {
      do
      {
        hammock = promptHammock();      //By William Resendez: calls the mathod promptHammock to show the user the available hammock choices and propmpts the user to make a choice between int of 1 to 3.
        if(hammock < 1 || hammock > 3)  //By William Resendez: Tests the users response to the prompt for hammock choices, if the response is outside of 1 to 3 range, the following print statement will execute.
        {
          System.out.printf("%nYou entered an invalid hammock choice. "
                          + "Enter 'Y\' to re-enter your choice or 'N\' to exit the program:  ");  //By William Resendez: This statement will alert the user that he entered an invalid choice and prompt the user to re-enter their choice or exit the program.
          
          if(input.next().charAt(0) == 'n')  //By William Resendez: captures users input to the above prompt, and returns 'n' to char at position 0 is user chooses to exit program.
            System.exit(0);                  //By William Resendez: If the user chooses to exit the program, System.exit(0) is executed.
        }
      }while((hammock < 1 || hammock > 3) && Character.toLowerCase(morePurchases) == 'y');  //By William Resendez: this while loops test for the users hammock choice to be between the range of 1 to 3, and if the user enters 'Y', the input is converted to lower case to match correct capitalization of char morePurchases at position 0. The following statement executes.
      
      if(Character.toLowerCase(morePurchases) == 'y')  //By William Resendez: This if statement coverts the users response to lower case and if it matches lower case 'y', the statement below executes.
      {
        setHammockSizePrice(hammock);      //By William Resendez: Calls setHammockSizePrice method and send it the hammock choice made by the user.
        quantity = promptQuantity();       //By William Resendez: Calls promptQuantity method for the user to choose the quantity of hammocks wishing to purchse, saves the users input into the int quatity variable.
        do  //By William Resendez:beginning of do-while loop.
        {
          color = promptColor();        //By William Resendez: calls the promptColor method and saves the users response inside int variable named color.
          if(color < 1 || color > 5)    //By William Resendez: This if statement tests for the users color choice to be within a range of 1 to 5.
          {
            System.out.printf("%nYou entered an invalid color choice. "
                            + "Enter 'Y\' to re-enter your choice or 'N\' to exit the program:  "); //By William Resendez: This print statement executes only if the user inputs a value less than 1 or grater than 5, prompts the user to re-enter to exit the program.
            if(input.next().charAt(0) == 'n')  //By William Resendez: captures the users response from the above prompt, if user enters 'n' then it return n to char at position 0.
              System.exit(0);                  //By William Resendez: exits the program successfully if user has chosen to
          }
        }while((color < 1 || color > 5) && Character.toLowerCase(morePurchases) == 'y');  //By Raymond Ng: repeat if the color is not valid and morePurchases = y
        
        if(Character.toLowerCase(morePurchases) == 'y')  //By Raymond Ng: if the user enters 'Y', the input is converted to lower case to match correct capitalization of char morePurchases at position 0.
        {
          setHammockColor(color);        //By William Resendez: calls setHammockColor method and passes the users color choice to it.
          itemTotal = quantity * price;  //By William Resendez: itemTotal is calculated by multiplying quantity * price.
          subtotal += itemTotal;         //By William Resendez: Subtotal is calculated by adding the right operand to the variable.
        }//By Raymond Ng: END if morePurchases = y set color, calculate itemTotal and subtotal.
        
        
        salesReceipt += String.format("%n%-24s %c %-13s %5s %,7d %4s %s%,14.2f",
                                      hammockDesc, '-', colorSelected, " ",
                                      quantity, " ", iterations > 1 ? " " : "$", itemTotal);  //By William Resendez: adds the hammock to the salesReceipt.
        
        System.out.printf("%nDo you want to purchase another hammock? "
                        + "Enter 'Y\' to continue or 'N\' to exit the program:  ");  //By William Resendez: prompts the user if they wish to purchase another hammock.
        
        morePurchases = input.next().charAt(0);  //By William Resendez: Char at position 0 is set to the users input from the previous prompt.
        
        if(Character.toLowerCase(morePurchases) == 'n')  //By William Resendez: If the user enters 'N', it is converted into lower case, char at position 0 is returned a n. The if statement test for char at position 0 to be n.
        {
          printFinal = true;  //By William Resendez: If char at position 0 is n, boolean print final is set to true, and salesReceipt is generated for the user.
        }//By Raymond Ng: END if morePurchases = n, printFinal is true.
      }//By Raymond Ng: END if morePurchases = y, add to salesReceipt, prompt if user wants to make another purchase.
      
      iterations += 1; //By Raymond Ng: iterations is incremented by 1.
    }while(Character.toLowerCase(morePurchases) == 'y');  //By William Resendez: repeat if user wants to add another hammock.
    
    if(subtotal >= 100000.00)                             //By William Resendez: This if tests for subtotal to be greater than or equal to 100,000.
    {
      discRate = .035;                                    //By William Resendez: if subtotal is greater than or equal to 100,000, the discRate is set to 3.5%
    }
    else                                                  //By William Resendez: This else executes the follwing if subtotal is not greater than or equal to 100,000
    {
      if(subtotal >= 50000.00)                            //By William Resendez: This if tests for subtotal to be greater than or equal to 50,000.00
      {
        discRate = .03;                                   //By William Resendez: if subtotal is greater than or equal to 50,000.00, the discRate is set to 3%
      }
      else                                                //By William Resendez: This else exectues the follwing is subtotal is not greater than or equal to 50,000.00
      {
        if(subtotal >= 10000.00)                          //By William Resendez: tests for subtotal to be greater than or equalt to 10,000.00
        {
          discRate = .025;                                //By William Resendez: if subtotal is greater than or equal to 10,000, the discRate it set to 2.5%
        }
        else                                              //By William Resendez: This else executes the following statement is subtotal is not greater than or equal to 10,000
        {
          if(subtotal >= 5000.00)                         //By William Resendez: this if test for subtotal to be greater than or equal to 5,000
          {
            discRate = .02;                               //By William Resendez: if subtotal is greater than or equal to 5,000 then discRate is set to 2%
          }
          else                                            //By William Resendez: if subtotal is not within the previous ranges the following statement executes.
          {
            discRate = 0.0;                               //By William Resendez: if subtotal is not greater than or equal to 5,000. Then the discRate is 0%
          }//By Raymond Ng: END if subtotal >= 5000 2% discount else discount is 0.
        }//By Raymond Ng: END if subtotal >= 10000 2.5% discount else subtotal >= 5000.
      }//By Raymond Ng: END if subtotal >= 50000 3% discount else subtotal >= 10000.
    }//By Raymond Ng: END if subtotal >= 100000 3.5% discount else subtotal >= 50000.
    
    discount = subtotal * discRate;       //By Raymond Ng: the appropriate discount is found by multiplying the subtotal by the discount rate.
    
    discSubtotal += subtotal - discount;  //By Raymond Ng: the discounted subtotal is found by subtracting the appropriate discount from subtotal.
    
    tax = discSubtotal * .0825;           //By Raymond Ng: the appropriate tax is found by multiplying the discounted subtotal * 8.25%
    
    total = discSubtotal + tax;           //By Raymond Ng: the total is found by adding the appropriate tax to subtotal.
    
    if(printFinal == true)                //By Raymond Ng: This if statement tests for printFinal to be true.
    {
      displaySalesReceipt(subtotal, discount, tax ,total); //By Raymond Ng: displaySalesReceipt method is called and passed the subtotal, discount, tax, and total variables.
    }//By Raymond Ng: END if printFinal is true, display the salesReceipt.
    
    System.exit(0); //By William Resendez: The program is exited and passed a 0.
    
  }//By Raymond Ng: END main()
  
  /**
   * By Raymond Ng: promptHammock() presents user with sizes of hammock selections available.
   * promptHammock() tests repeat, and prompts user for the size of the hammock. 
   */
  public static int promptHammock()
  {
    do
    {
      System.out.printf("%nLAZY HAZY DAYS, INC."
                      + "%n%nOur beautiful cotton hammocks sport a "
                      + "traditional look and are very comfortable. "
                      + "%n%n1. Small - 48 in . x 11 ft. - Good for 1 "
                      + "person\t\t\t\t$100.00"
                      + "%n2. Large - 55 in . x 13 ft. - Good for 2 "
                      + "people\t\t\t\t$140.00"
                      + "%n3. Deluxe - 60 in. x 13 ft. - Good for 2 or "
                      + "more people\t\t\t$175.00"
                      + "%n%nEnter your choice:  ");
      
      repeat = !input.hasNextInt();  //By Raymond Ng: AS LONG AS THE INPUT IS "NOT" AN INTEGER.
      
      validateNumber();
    }while(repeat == true);  //By Raymond Ng: END do-while repeat is true.
    
    return input.nextInt();
  }//By Raymond Ng: END promptHammock(): static void
  
  /*
   * By Raymond Ng: setHammockSizePrice() tests hammock to determine the hammockDesc.
   * and price to a switch statement.
   */
  public static void setHammockSizePrice(int hammock)
  {
    switch (hammock)  //By Raymond Ng: switch header that evaluates hammock.
    {
      case 1:
        hammockDesc = "Small - 48 in. x 11ft.";
        price = 100.00;
        break;
      case 2:
        hammockDesc = "Large = 55in. x 13 ft.";
        price = 140.00;
        break;
      case 3:
        hammockDesc = "Deluxe - 60 in. x 13 ft.";
        price = 175.00;
        break;
    }//By Raymond Ng: END switch scope
  }//By Raymond Ng: END setHammockSizePrice(hammock: int): static void
  
  /*
   * By Raymond Ng: setHammockColor() presents user with colors of hammocks available,
   * setHammockColor() tests color to determine the colorSelected to a switch statement.
   */
  public static void setHammockColor(int color)
  {
    switch (color)  //By Raymond Ng: switch header that evaluates color.
    {
      case 1:
        colorSelected = "Crimson Red";
        break;
      case 2:
        colorSelected = "Emerald Green";
        break;
      case 3:
        colorSelected = "Indigo Blue";
        break;
      case 4:
        colorSelected = "Natural";
        break;
      case 5:
        colorSelected = "Purple Haze";
        break;
    }//By Raymond Ng: END switch scope.
  }//By Raymond Ng: END setHammockColor(color: int): static void
  
  /**
   * By Raymond Ng: promptQuanity() tests repeat, and prompts user to enter quantity
   * of hammocks.
   */
  public static int promptQuantity()
  {
    do
    {
      System.out.printf("%nEnter the quantity:  ");
      
      repeat = !input.hasNextInt();  //By Raymond Ng: AS LONG AS THE INPUT IS "NOT" AN INTEGER.
      
      validateNumber();  //By Raymond Ng: Test the validity of quantity.
    }while(repeat == true);  //By Raymond Ng: END do-while repeat is true.
    
    return input.nextInt();
  }//By Raymond Ng: END promptQuantity(): static int
  
  /*
   * By Raymond Ng: promptColor() tests repeat, and prompts 
   * user for the color of the hammock
   */
  public static int promptColor()
  {
    do
    {
      System.out.printf("%n1. Crimson Red"
                      + "%n2. Emerald Green"
                      + "%n3. Indigo Blue"
                      + "%n4. Natural"
                      + "%n5. Purple Haze"
                      + "%n%nEnter your choice of colors:  ");
      
      repeat = !input.hasNextInt();
      
      validateNumber(); //By William Resendez: tests the validity of the number.
    }while(repeat == true);
    
    return input.nextInt();
  }//By Raymond Ng: END promptColor(): static int
  
  /*
   * By Raymond Ng: validateNumber() tests a number entered to see if it is either a valid integer or
   * floating-point.
   */
  public static void validateNumber()
  {
    if(repeat == true) //By Raymond Ng: AS LONG AS THE INPUT IS "NOT" AN INTEGER OR DOUBLE.
    {
      input.next(); //By Raymond Ng: CONSUME NON-NUMERIC VALUE.
      System.out.printf("%nYou must enter a valid integer or floating-point value!%n");
    }//By Raymond Ng: END if repeat is true
  }//By Raymond Ng: END validateNumber(): static void
  
  /*
   * By Raymond Ng: displaySalesReceipt() calculates the discSubtotal, tax, and total and print the
   * salesReceipt with the subtotal, discount, tax, and total.
   */
  public static void displaySalesReceipt(double subtotal, 
                                         double discount, 
                                         double tax, 
                                         double total)
  {
    salesReceipt += String.format("%n%n%52s %-6s $%,14.2f"
                                + "%n%52s %-7s %,14.2f"
                                + "%n%52s %-7s %,14.2f"
                                + "%n%n%52s %-6s $%,14.2f%n","SUBTOTAL:","  ",
                                  subtotal, "DISCOUNT:", "  ", discount, "TAX @ 8.250%:",
                                  "  ", tax, "TOTAL:", "  ", total);
    System.out.println(salesReceipt); //By Raymond Ng: Prints the salesReceipt for the user.
  }//By Raymond Ng: END displaySalesReceipt(subtotal: double, discount: double, tax: double, total: double): static void
  
}//By Raymond Ng: END APPLICATION CLASS NgResendez003PA2.



/*
 * SAMPLE OUTPUTS
 * 
 * LAZY HAZY DAYS, INC. 
 *
 * HAMMOCK SALES - LOW QUANTITY
 * 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  l
 
You must enter a valid integer or floating-point value! 
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  4
 
You entered an invalid hammock choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  1
 
Enter the quantity:  Z
 
You must enter a valid integer or floating-point value! 
 
Enter the quantity:  2
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  6
 
You entered an invalid color choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  y
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  6
 
You entered an invalid color choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  y
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  4
 
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  2
 
Enter the quantity:  100
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  2
 
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  3
 
Enter the quantity:  50
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  5
 
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  n
 
 
SALES RECEIPT 
 
LAZY HAZY DAYS, INC. 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:  10/22/21 
Time:  02:27:38 PM 
 
Small - 48 in. x 11ft.   - Natural                   2      $        200.00 
Large = 55in. x 13 ft.   - Emerald Green           100            14,000.00 
Deluxe - 60 in. x 13 ft. - Purple Haze              50             8,750.00 
 
                                           SUBTOTAL:        $     22,950.00 
                                           DISCOUNT:                 573.75 
                                       TAX @ 8.250%:               1,846.04 
 
                                              TOTAL:        $     24,222.29 
                                              
 *
 * 
 * HAMMOCK SALES - LARGE QUANTITY
 * 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  1
 
Enter the quantity:  100000
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  4
 
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  2
 
Enter the quantity:  10000
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  1
 
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  y
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  3
 
Enter the quantity:  1000
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  5
 
Do you want to purchase another hammock? Enter 'Y' to continue or 'N' to exit the program:  n
 
 
SALES RECEIPT 
 
LAZY HAZY DAYS, INC. 
Huebner Oaks Mall 
San Antonio, TX 
 
Date:  10/22/21 
Time:  02:30:11 PM 
 
Small - 48 in. x 11ft.   - Natural             100,000      $ 10,000,000.00 
Large = 55in. x 13 ft.   - Crimson Red          10,000         1,400,000.00 
Deluxe - 60 in. x 13 ft. - Purple Haze           1,000           175,000.00 
 
                                           SUBTOTAL:        $ 11,575,000.00 
                                           DISCOUNT:             405,125.00 
                                       TAX @ 8.250%:             921,514.69 
 
                                              TOTAL:        $ 12,091,389.69 
 *
 * 
 * ERROR MESSAGES
 * 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  4
 
You entered an invalid hammock choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  n
 
LAZY HAZY DAYS, INC. 
 
Our beautiful cotton hammocks sport a traditional look and are very comfortable.  
 
1. Small - 48 in . x 11 ft. - Good for 1 person    $100.00 
2. Large - 55 in . x 13 ft. - Good for 2 people    $140.00 
3. Deluxe - 60 in. x 13 ft. - Good for 2 or more people   $175.00 
 
Enter your choice:  3
 
Enter the quantity:  0
 
1. Crimson Red 
2. Emerald Green 
3. Indigo Blue 
4. Natural 
5. Purple Haze 
 
Enter your choice of colors:  7
 
You entered an invalid color choice. Enter 'Y' to re-enter your choice or 'N' to exit the program:  n
 */