/**
 * WARNING:  THE CODE IN THIS PROGRAM "CANNOT" BE ALTERED.
 * NO POSTING OF THIS CODE IS ALLOWED ANY WHERE AS IT
 * IS THE INTELLECTUAL PROPERTY OF THE AUTHOR.
 * 
 * @(#)Hammock.java
 * @authors: Linda Shepherd and Raymond Ng
 * @version 1.00 2021/11/08 6:31 AM
 *
 * PROGRAM PURPOSE: Overall program accepts a customer's
 * orders for hammocks. The customer gets a discount
 * based on the order total (size). A sales receipt
 * will be generated. This  particular part of the program
 * will run with the SalesSystem and application (NgResendez003PA3)
 * classes. Hammock class will generate the menus for
 * the selection of hammock options and their color choices
 * for the user/customer to choose from.
 */

import java.util.Scanner; //A simple text scanner which can parse primitive types and strings using regular expressions

public class Hammock 
{     
  private int hammock = 0;   //hammock type number
  private int quantity = 0;  //hammock quantity
  private int color = 0; //hammock selected color number
  private int hammockNo = 0; //current hammock being processed in order
  private String hammockDesc = ""; //Hammock description
  private String colorSelected = ""; //String value of color selected
  private double price = 0.0; //price of hammock
  private boolean repeat = false; 
  private Scanner input = new Scanner(System.in); //Scanner to read from standard input

  /**
   * Comment box by Raymond Ng: Constructor.
   * Method used to create an instance
   * of the class.
   */
  public Hammock()
  {
  }//Line comment by Raymond Ng:END Hammock() constructor

  /**
   * Constructor function with parameters.
   * It also initializes the variables
   * hammock choice, color, and quantity.
   * @param hammock
   * @param color
   * @param quantity
   */
  public Hammock(int hammock, int color, int quantity)
  {
    setHammockChoice(hammock);
    setColorChoice(color);
    setQuantity(quantity);
  }//Line comment by Raymond Ng: END Hammock() constructor

  /**
   * Set Hammock Choice
   * @param hammock
   */
  public final void setHammockChoice(int hammock)
  {
    this.hammock = hammock;
  }//Line comment by Raymond Ng: END setHammockChoice(): void

  /**
   * Set Hammock color
   * @param color
   */
  public final void setColorChoice(int color)
  {
    this.color = color;
  }//Line comment by Raymond Ng: END setColorChoice(): void

  /**
   * Set hammock quantity
   * @param quantity
   */
  public final void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }//Line comment by Raymond Ng: END setQuantity() void

  /**
   * Comment box by Raymond Ng:
   * Display Hammock menu and provide an
   * input to select hammock choice. It also
   * validates the input provided, making sure
   * it's between 1 and 3.
   * @param hammockNo
   */
  public void setHammockChoice(String hammockNo)  
  { 
    do // outer loop check the if hammock chosen is between 1 and 3
    { 
      do
      {
        System.out.printf("%nLAZY HAZY DAYS, INC. - Hammock %s"
                        + "%n%nOur beautiful cotton hammocks sport a "
                        + "traditional look and are very comfortable.  "
                        + "%n%n1.  Small - 48 in. x 11 ft. - Good for 1 "
                        + "person\t\t\t\t$100.00"
                        + "%n2.  Large - 55 in. x 13 ft. - Good for 2 "
                        + "people\t\t\t\t$140.00"
                        + "%n3.  Deluxe - 60 in. x 13 ft. - Good for 2 or "
                        + "more people\t\t\t$175.00"
                        + "%n%nEnter your choice:  ", hammockNo);
        
        validateNumber(!input.hasNextInt());
      }while(repeat);  //Line comment by Raymond Ng: END do
      
      hammock = input.nextInt();          
      input.nextLine();   
      
      if(hammock < 1 || hammock > 3)
      {
        System.out.printf("%nYou entered an invalid hammock choice!  "
                        + "Try again!%n");
      }//Line comment by Raymond Ng: END if
       
    }while(hammock < 1 || hammock > 3);      //Line comment by Raymond Ng: END outer do
   
  }//Line comment by Raymond Ng: END setHammockChoice() void

  /**
   * Set Hammock price based on type
   */
  public void setHammockDescPrice()
  {
    switch(hammock)
    {
      case 1:            
        hammockDesc = "Small - 48 in. x 11 ft.";
        price = 100.00;
        break;
      case 2:   
        hammockDesc = "Large - 55 in. x 13 ft.";
        price = 140.00;
        break;
      case 3:
        hammockDesc = "Deluxe - 60 in. x 13 ft.";
        price = 175.00;       
    } //END switch
  } //END setHammockDescPrice() void

  /**
   * Comment box by Raymond Ng:
   * Display color menu and input to select color.
   * It also validates the input to ensure the range is
   * between 1 and 5.
   */
  public void setColorChoice()
  {
    do
    {
      do
      {
        System.out.printf("%n1.  Crimson Red"
                            + "%n2.  Emerald Green"
                            + "%n3.  Indigo Blue"
                            + "%n4.  Natural"
                            + "%n5.  Purple Haze"
                            + "%n%nEnter your choice of colors:  ");
        
        validateNumber(!input.hasNextInt());  
        
      }while(repeat);   //Line comment by Raymond Ng: END inner do
      
      color = input.nextInt();
      input.nextLine();
      
      if(color < 1 || color > 5)
      {
        System.out.printf("%nYou entered an invalid color choice.  "
                        + "Try again!%n");
        
      }//END if
    }while(color < 1 || color > 5);  //Line comment by Raymond Ng: END outer do
  }//Line comment by Raymond Ng: END setColorChoice() void

  /**
   * Comment box by Raymond Ng:
   * Set color based on input.
   * Set color based on color selected
   * by setColorChoice().
   */
  public void setHammockColor()
  {
    switch(color)  //Line comment by Raymond Ng: switch header that evaluates color
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
        
    }//Line comment by Raymond Ng: END switch
    
  }//Line comment by Raymond Ng: END setHammockColor() void

  /**
   * set the quantity of hammock bought
   */
  public void setQuantity()
  {
    do
    {
      System.out.printf("%nEnter the quantity:  ");      
      
      validateNumber(!input.hasNextInt());  
    }while(repeat);   //Line comment by Raymond Ng: end do
    
    quantity = input.nextInt();      
  }//Line comment by Raymond Ng: END setQuantity() void

  /**
   * Calculate the total price of Hammock
   * @return
   */
  public double calcItemTotal()
  {
    return quantity * price;
  }//Line comment by Raymond Ng: END calcItemTotal() double

  /**
   * Retrieve hammock choice
   * @return
   */
  public int getHammockChoice()
  {
    return hammock;
  }//Line comment by Raymond Ng: END getHammockChoice() int

  /**
   * Retrieve hammock color choice
   * @return
   */
  public int getColorChoice()
  {
    return color;
  }//Line comment by Raymond Ng: END getColorChoice() int

  /**
   * Retrieve hammock description
   * @return
   */
  public String getHammockDesc()
  {
    return hammockDesc;
  }//Line comment by Raymond Ng: END getHammockDesc() String

  /**
   * Retrieve hammock color
   * @return
   */
  public String getHammockColor()
  {
    return colorSelected;
  }//Line comment by Raymond Ng: END getHammockColor() String

  /**
   * Retrieve hammock price
   * @return
   */
  public double getPrice()
  {
    return price;
  }//Line comment by Raymond Ng: END getPrice() double

  /**
   * Retrieve hammock quantity
   * @return
   */
  public int getQuantity()
  {
    return quantity;
  }//Line comment by Raymond Ng: END getQuantity() int

  /**
   * Validate if input is a number
   * @param repeat
   */
  public void validateNumber(boolean repeat)
  {
    if(repeat) 
    { 
      input.next(); 
      System.out.printf("%nRe-enter a valid integer or "
                      + "floating-point value:  ");  
    }//END if
    
  }//END validateNumber() void
  
}//END Hammock class
