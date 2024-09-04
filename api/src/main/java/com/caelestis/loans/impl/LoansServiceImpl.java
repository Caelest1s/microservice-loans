package com.caelestis.loans.impl;

import com.caelestis.loans.dto.LoansDto;
import com.caelestis.loans.entity.Loans;
import com.caelestis.loans.exception.LoanAlreadyExistsException;
import com.caelestis.loans.exception.ResourceNotFoundException;
import com.caelestis.loans.mapper.LoansMapper;
import com.caelestis.loans.repository.LoanRepository;
import com.caelestis.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoanRepository loanRepository;

    @Override
    public void createLoans(LoansDto loansDto) {
        Loans loans = LoansMapper.mapToLoan(loansDto, new Loans());
        Optional<Loans> optionalLoans = loanRepository.findByMobileNumber(loansDto.getMobileNumber());
        if (optionalLoans.isPresent()) {
            throw new LoanAlreadyExistsException(
                    "Loan already registered with given mobileNumber: " + loansDto.getMobileNumber());
        }
        insertLoanLocalAndFunctionary(loans);
        Loans savedLoans = loanRepository.save(loans);
    }

    private void insertLoanLocalAndFunctionary(Loans loans) {
        loans.setCreatedAt(LocalDateTime.now());
        loans.setCreatedBy("Caelestis");
        loans.setUpdatedAt(LocalDateTime.now());
        loans.setUpdatedBy("Caelestis");
    }

    @Override
    public LoansDto fetchLoans(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoansMapper.mapToLoanDto(loans, new LoansDto());
    }
}
