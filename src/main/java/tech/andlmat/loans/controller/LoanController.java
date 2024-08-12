package tech.andlmat.loans.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.andlmat.loans.controller.dto.CustomerLoanRequest;
import tech.andlmat.loans.controller.dto.CustomerLoanResponse;
import tech.andlmat.loans.service.LoanService;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest loanRequest) {
        var loanResponse = loanService.checkAvailability(loanRequest);

        return ResponseEntity.ok(loanResponse);
    }
}
