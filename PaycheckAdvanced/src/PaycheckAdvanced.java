/*
Alex Habbart
0855541
2/23/24
CSC 512
Lab 4
 */

/* This program will calculate the paycheck for a WCUPA employee based on the
   hourlySalary, weeklyTime (working for maximum 40 hours)
   and overtime (working for more than 40 hours) */

import java.util.Scanner;

public class PaycheckAdvanced {

    public static void main(String[] args){

        // Intro message
        System.out.println("Welcome to \"WCUPA HUMAN RESOURCES\"");
        System.out.println();

        // Declare scanner object
        Scanner scanner = new Scanner(System.in);

        // Declare calculation class object
        PaycheckCalc calc = new PaycheckCalc();

        calc.readInputs();
        System.out.println("\t==============================");
        calc.displayInputs();

        calc.displayResults(calc.calcRegPay(calc.calcWorkTimeReg(calc.getWorkHours()), calc.getSalary()),
                calc.calcOTPay(calc.calcWorkTimeOT(calc.getWorkHours()), calc.getSalary()));

        System.out.println("\t==============================");
        System.out.println("Thank you for using \"WCUPA HUMAN RESOURCES\"");
    }
}
