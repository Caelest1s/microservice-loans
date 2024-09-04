package com.caelestis.loans.service;

import com.caelestis.loans.dto.LoansDto;

public interface ILoansService {

    void createLoans(LoansDto loansDto);

    LoansDto fetchLoans(String mobileNumber);

    boolean updateLoans(LoansDto loansDto);

    boolean deleteLoans(String mobileNumber);
}
