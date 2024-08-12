package tech.andlmat.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tech.andlmat.loans.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {
        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build();

            assertTrue(customer.isIncomeEqualOrLowerThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertFalse(customer.isIncomeEqualOrLowerThan(3000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertTrue(customer.isIncomeEqualOrLowerThan(8000.00));
        }
    }

    @Nested
    class isIncomeEqualOrGreaterThan {
        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build();

            assertTrue(customer.isIncomeEqualOrGreaterThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertTrue(customer.isIncomeEqualOrGreaterThan(3000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertFalse(customer.isIncomeEqualOrGreaterThan(8000.00));
        }
    }

    @Nested
    class isIncomeBetween {
        @Test
        void shouldBeTrueWhenIncomeIsBetween() {
            var customer = CustomerFactory.build();

            assertTrue(customer.isIncomeBetween(3000.00, 8000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualMin() {
            var customer = CustomerFactory.build();

            assertTrue(customer.isIncomeBetween(5000.00, 6500.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualMax() {
            var customer = CustomerFactory.build(8000.00);

            assertTrue(customer.isIncomeBetween(5000.00, 8000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween() {
            var customer = CustomerFactory.build();

            assertFalse(customer.isIncomeBetween(3000.00, 4500.00));
        }
    }

    @Nested
    class isAgeLowerThan {
        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            var customer = CustomerFactory.build(25);

            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsLowerThan() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(22));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualToValue() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {
        @Test
        void shouldBeTrueWhenLocationIsTheSame() {
            var customer = CustomerFactory.build("SP");

            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotTheSame() {
            var customer = CustomerFactory.build("SP");

            assertFalse(customer.isFromLocation("RJ"));
        }
    }
}