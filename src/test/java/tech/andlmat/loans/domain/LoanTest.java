package tech.andlmat.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.andlmat.loans.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLessThan3k() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00, 5000.00);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGuaranteedLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLessThan3k() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00, 5000.00);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isGuaranteedLoanAvailable());
        }
    }

    @Nested
    class isConsignmentLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5k() {
            doReturn(true).when(customer).isIncomeEqualOrGreaterThan(5000.00);

            assertTrue(loan.isConsignmentLoanAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsEqualTo4k() {
            doReturn(false).when(customer).isIncomeEqualOrGreaterThan(5000.00);

            assertFalse(loan.isConsignmentLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {
        @Test
        void shouldTheInterestRateBe4() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.00);

            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }
}