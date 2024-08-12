package tech.andlmat.loans.service;

import org.springframework.stereotype.Service;
import tech.andlmat.loans.controller.dto.CustomerLoanRequest;
import tech.andlmat.loans.controller.dto.CustomerLoanResponse;
import tech.andlmat.loans.controller.dto.LoanResponse;
import tech.andlmat.loans.domain.Loan;
import tech.andlmat.loans.domain.LoanType;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkAvailability(CustomerLoanRequest loanRequest) {

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsignmentLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(loanRequest.name(), loans);
    }
}
