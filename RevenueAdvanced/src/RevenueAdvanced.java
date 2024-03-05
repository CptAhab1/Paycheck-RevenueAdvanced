/*
Alex Habbart
0855541
2/23/24
CSC 512
Lab 4
 */

/* This program will calculate the revenue from a sale based on
the unit price and quantity of a product input by the user. */

import java.util.Scanner;

public class RevenueAdvanced {

    public static void main(String[] args){

        // Intro message
        System.out.println("Welcome to \"WCUPA\" store");
        System.out.println();

        // Declare scanner object
        Scanner scanner = new Scanner(System.in);

        // Declare calculation class object
        RevenueCalc calc = new RevenueCalc();

        // All calculations occur in the RevenueCalc class
        calc.readInput();
        calc.calcSubTotal();
        calc.calcDiscountRate();
        calc.calcTotal();
        calc.displayResults();

        System.out.println("\nThank You for using \"WCUPA\" store");
    }
}
