package BankInfoManager.model.products;

import java.math.BigDecimal;
import java.time.LocalDate;

import BankInfoManager.model.users.User;

public class Loan {

    private BigDecimal amount;
    private double interestRate;
    private int termInMonths;
    private ProductStatus status;
    public Loan(Long loanId,
                User borrower,
                BigDecimal amount,
                double interestRate,
                int termInMonths) {

        this.amount = amount;
        this.interestRate = interestRate;
        this.termInMonths = termInMonths;
        this.status = ProductStatus.SUSPENDED;

        validateLoan();
    }

    private void validateLoan() {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Monto inválido");
        }

        if (interestRate <= 0) {
            throw new IllegalArgumentException("Tasa inválida");
        }

        if (termInMonths <= 0) {
            throw new IllegalArgumentException("Plazo inválido");
        }
    }

    public void approve() {
        this.status = ProductStatus.ACTIVE;
        LocalDate.now();
    }

    public BigDecimal calculateTotalPayment() {
        BigDecimal interest = amount.multiply(BigDecimal.valueOf(interestRate));
        return amount.add(interest);
    }

    public ProductStatus getStatus() {
        return status;
    }
}