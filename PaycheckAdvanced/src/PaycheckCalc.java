/*
This class contains all the necessary variables that the user will input and
that the program will output, as well as the functions which will calculate
the paystub metrics and display the results.
 */

import java.util.Scanner;

public class PaycheckCalc {

    public double employeeNumber;
    public float salary;
    public float workHours;
    public float workHoursReg;
    public float workHoursOT;
    public float regPay;
    public float otPay;

    public float maxWorkHours = 60;

    public float minWage = (float)7.25;

    // This value is set here in case one wants to change overtime pay rate
    public final float otRate = (float) 1.5;
    public float netPay;

    // Similar as above
    public final int fullTimeHours = 40;

    Scanner scanner = new Scanner(System.in);

    public void readInputs() {
        System.out.print("\tEnter Employee Number: ");
        employeeNumber = scanner.nextDouble();
        String employeeNumberString = String.format("%d", (int)employeeNumber);
        // The below booleans check if the number entered by the user has exactly 9 characters,
        // does not have a leading 0, is a non-negative number, and has no decimal values,
        // and ends the program if any of the above are false
        if (employeeNumberString.length() != 9 || employeeNumberString.charAt(0) == 0
                || employeeNumber < 0 || employeeNumber%1 != 0) {
            System.out.println("\tThis is not a valid Employee Number.\n" +
                    "\tPlease run the program again.");
            System.out.println("\nThank you for using \"WCUPA HUMAN RESOURCES\"");
            System.exit(0);
        }

        System.out.print("\tEnter Hourly Salary: ");
        salary = scanner.nextFloat();
        // This boolean checks to make sure the user is making the legal minimum wage,
        // and ends the program early if not
        if (salary < minWage) {
            System.out.println("\tThis is not a valid hourly salary amount.\n" +
                    "\tPlease run the program again.");
            System.out.println("\nThank you for using \"WCUPA HUMAN RESOURCES\"");
            System.exit(0);
        }

        System.out.print("\tEnter Weekly Time: ");
        workHours = scanner.nextFloat();
        // This boolean checks to make sure the user is working at all,
        // and caps at maxWorkHours (60 at present),
        // and ends the program early if not
        if (workHours < 0 || workHours > maxWorkHours) {
            System.out.println("\tThis is not a valid weekly time.\n" +
                    "\tPlease run the program again.");
            System.out.println("\nThank you for using \"WCUPA HUMAN RESOURCES\"");
            System.exit(0);
        }
    }

    public void displayInputs() {
        System.out.println("\tEmployee #: " + employeeNumber);
        System.out.println("\tHourly Salary: $" + salary);
        System.out.println("\tWeekly Time: " + workHours);
    }

    public double getEmployeeNumber() {
        return (employeeNumber);
    }

    public float getSalary() {
        return (salary);
    }

    public float getWorkHours() {
        return (workHours);
    }


    public float calcWorkTimeReg(float workHours) {
        if (workHours > fullTimeHours) {
            workHoursReg = fullTimeHours;
        } else {
            workHoursReg = workHours;
        }
        return (workHoursReg);
    }

    public float calcWorkTimeOT(float workHours) {
        if (workHours > fullTimeHours) {
            workHoursOT = workHours - fullTimeHours;
        } else {
            workHoursOT = 0;
        }
        return (workHoursOT);
    }

    public float calcRegPay(float workHoursReg, float salary) {
        regPay = workHoursReg * salary;
        return regPay;
    }

    public float calcOTPay(float workHoursOT, float salary) {
        otPay = workHoursOT * (salary * otRate);
        return otPay;
    }

    public void displayResults(float regPay, float otPay) {
        System.out.println("\tRegular Pay: $" + regPay);
        System.out.println("\tOvertime Pay: $" + otPay);
        System.out.println("\tNet Pay: $" + (regPay + otPay));
    }


}
