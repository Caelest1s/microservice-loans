package com.caelestis.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoansDto {

    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{11})", message = "Mobile number must be 11 digits")
    private String mobileNumber;

    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits")
    private String loanNumber;

    @NotEmpty(message = "LoanType can not be a null or empty")
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    private Integer totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private Integer amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private Integer outstandingAmount;
}
