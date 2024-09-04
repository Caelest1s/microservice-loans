package com.caelestis.loans.controller;

import com.caelestis.loans.contants.LoanConstants;
import com.caelestis.loans.dto.LoansDto;
import com.caelestis.loans.dto.ResponseDto;
import com.caelestis.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoansController {

    private ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoans(@RequestBody LoansDto loansDto) {
        iLoansService.createLoans(loansDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber){
        LoansDto loansDto = iLoansService.fetchLoans(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }
}
