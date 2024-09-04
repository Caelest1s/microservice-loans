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

    private LoanRepository loansRepository;

    @Override
    public void createLoans(LoansDto loansDto) {
        Loans loans = LoansMapper.mapToLoan(loansDto, new Loans());
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(loansDto.getMobileNumber());
        if (optionalLoans.isPresent()) {
            throw new LoanAlreadyExistsException(
                    "Loans already registered with given mobileNumber: " + loansDto.getMobileNumber());
        }
        loansRepository.save(loans);
    }

    @Override
    public LoansDto fetchLoans(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber)
        );
        return LoansMapper.mapToLoanDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoans(LoansDto loansDto) {
        boolean isUpdated = false;
        if (loansDto != null) {
            Loans loans = loansRepository.findByMobileNumber(loansDto.getMobileNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Loans", "mobileNumber", loansDto.getMobileNumber())
            );
            LoansMapper.mapToLoan(loansDto, loans);
            loansRepository.save(loans);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteLoans(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber)
        );
        loansRepository.delete(loans);
        return true;
    }
}
