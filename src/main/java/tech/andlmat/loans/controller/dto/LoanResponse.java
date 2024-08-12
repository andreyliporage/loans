package tech.andlmat.loans.controller.dto;

import tech.andlmat.loans.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}
