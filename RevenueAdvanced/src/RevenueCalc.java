/*
This class will host the methods that display prompts for user input and the resulting
output, as well as the associated variables needed to calculate the output
 */

import java.util.Scanner;

public class RevenueCalc {
    public float itemPrice;

    public int itemQuant;

    public float subTotal;

    public float discountRate;

    public float total;

    // Declaring min and max prices here and making them final will prevent
    // them from changing and allow us to modify them if conditions change
    public final float itemPriceMin = (float) 0.25, itemPriceMax = (float) 100;

    Scanner scanner = new Scanner(System.in);

    // This method will display the prompts for the user, read input, and verify
    // input if it is outside the specified bounds
    public void readInput() {
        System.out.print("Enter item price: ");
        itemPrice = scanner.nextFloat();
        // This boolean will check that the price is between two bounds set in
        // the global variables, and end the program early if not within them
        if (itemPrice < itemPriceMin || itemPrice > itemPriceMax) {
            System.out.println("\tThis is not a valid item price.\n" +
                    "\tPlease run the program again.");
            System.out.println("\nThank You for using \"WCUPA\" store");
            System.exit(0);
        }

        System.out.print("Enter quantity: ");
        itemQuant = scanner.nextInt();
        if (itemQuant < 0) {
            System.out.println("\tThis is not a valid quantity order.\n" +
                    "\tPlease run the program again");
            System.out.println("\nThank You for using \"WCUPA\" store");
            System.exit(0);
        }
        //catch (Exception exception)
    }

    // These methods will allow us to call the appropriate variables
    public float getItemPrice() {
        return itemPrice;
    }

    public int getItemQuant() {
        return itemQuant;
    }

    // Calculate the subtotal, before any discount
    public float calcSubTotal() {
        subTotal = getItemPrice() * getItemQuant();
        return subTotal;
    }

    // Determine the discount rate, based off the quantity purchased
    public float calcDiscountRate() {
        discountRate = 0;
        if (itemQuant >= 150)
            discountRate = (float) .25;
        else if (itemQuant >= 100)
            discountRate = (float) .15;
        else if (itemQuant >= 50)
            discountRate = (float) .1;


        return (discountRate);
    }

    // More methods to call these variables to the main
    public float getSubTotal() {
        return subTotal;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    // Calculate the total cost, including discounts
    public float calcTotal() {
        total = getSubTotal() * (1 - getDiscountRate());
        return total;
    }

    // Method to call the total
    public float getTotal() {
        return total;
    }

    // Display both the inputs and the resulting breakdown of cost and discount
    /*
    Note: While different from the instructions, I elected to format the dollar
    amounts to go to 2 decimal places and the percent discount to 0 decimal places,
    since dollar amounts typically include 2 spaces for coins and the percentage
    is always an integer value in this program.
     */
    public void displayResults() {
        System.out.println("\tThe item price is: $" + String.format("%.2f",getItemPrice()));
        System.out.println("\tThe order is: " + getItemQuant() + " item(s)");
        System.out.println("\tThe cost is: $" + String.format("%.2f", getSubTotal()));
        System.out.println("\tThe discount is: " + String.format("%.0f",
                (100 * getDiscountRate())) + "%");
        System.out.println("\tThe discount amount is: $" +
                String.format("%.2f", (getDiscountRate() * getSubTotal())));
        System.out.println("\tThe total is: $" + String.format("%.2f", getTotal()));
    }
}
