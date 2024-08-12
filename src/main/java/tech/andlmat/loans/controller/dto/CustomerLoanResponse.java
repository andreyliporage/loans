package tech.andlmat.loans.controller.dto;

import java.util.List;

public record CustomerLoanResponse(
        String customer,
        List<LoanResponse> loans
) {
}
