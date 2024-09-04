package com.caelestis.loans.controller;

import com.caelestis.loans.contants.LoansConstants;
import com.caelestis.loans.dto.LoansDto;
import com.caelestis.loans.dto.ResponseDto;
import com.caelestis.loans.service.ILoansService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class LoansController {

    private ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoans(@Valid @RequestBody LoansDto loansDto) {
        iLoansService.createLoans(loansDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(
            @RequestParam
            @Pattern(regexp = LoansConstants.VALID_MOBILE_NUMBER, message = LoansConstants.ERR_MESSAGE_MOBILE)
            String mobileNumber)
    {
        LoansDto loansDto = iLoansService.fetchLoans(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoans(@Valid @RequestBody LoansDto loansDto) {
        boolean isUpdated = iLoansService.updateLoans(loansDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoans(
            @RequestParam
            @Pattern(regexp = LoansConstants.VALID_MOBILE_NUMBER, message = LoansConstants.ERR_MESSAGE_MOBILE)
            String mobileNumber) {
        boolean isDeleted = iLoansService.deleteLoans(mobileNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
                        new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
        }
    }
}
