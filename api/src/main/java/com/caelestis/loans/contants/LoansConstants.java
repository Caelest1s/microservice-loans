package com.caelestis.loans.contants;

public class LoansConstants {

    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Loans created successfully";
    public static final String STATUS_417 = "417";
    public static final String MESSAGE_417_UPDATE = "Update operation failed. Please try again or contact Dev team";
    public static final String MESSAGE_417_DELETE = "Delete operation failed. Please try again or contact Dev team";
    // public static final String  STATUS_500 = "500";
    // public static final String  MESSAGE_500 = "An error occurred. Please try again or contact Dev team";

    public static final String  HOME_LOAN = "Home Loan";
    public static final int  NEW_LOAN_LIMIT = 1_00_000;

    public static final String ERR_MESSAGE_MOBILE = "Mobile number must be 11 digits";
    public static final String VALID_MOBILE_NUMBER = "(^$|[0-9]{11})";

    private LoansConstants() {

    }
}
