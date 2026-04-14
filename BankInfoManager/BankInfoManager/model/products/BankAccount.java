package BankInfoManager.model.products;

import java.math.BigDecimal;
import java.time.LocalDate;

import BankInfoManager.model.users.User;

public class BankAccount {

    private String accountNumber;
    private User owner;
    private BigDecimal balance;
    private ProductStatus status;
    private LocalDate creationDate;

    // =========================
    // CONSTRUCTOR CORRECTO
    // =========================
    public BankAccount(String accountNumber, User owner, BigDecimal initialBalance) {

        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Número de cuenta inválido");
        }

        if (owner == null) {
            throw new IllegalArgumentException("El propietario no puede ser nulo");
        }

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance != null ? initialBalance : BigDecimal.ZERO;
        this.status = ProductStatus.ACTIVE;
        this.creationDate = LocalDate.now();

        validateInitialBalance(this.balance);
    }

    // =========================
    // VALIDACIÓN INICIAL
    // =========================
    private void validateInitialBalance(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Saldo inicial no puede ser negativo");
        }
    }

    // =========================
    // RETIRAR DINERO
    // =========================
    public void withdraw(BigDecimal amount) {
        validateActive();
        validatePositiveAmount(amount);

        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Fondos insuficientes");
        }

        balance = balance.subtract(amount);
    }

    // =========================
    // DEPOSITAR DINERO (CORREGIDO)
    // =========================
    public void deposit(BigDecimal amount) {
        validateActive();
        validatePositiveAmount(amount);

        balance = balance.add(amount);
    }

    // =========================
    // CERRAR CUENTA
    // =========================
    public void closeAccount() {
        if (balance.compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalStateException("No se puede cerrar con saldo disponible");
        }
        status = ProductStatus.CLOSED;
    }

    // =========================
    // VALIDACIONES INTERNAS
    // =========================
    private void validateActive() {
        if (!status.canOperate()) {
            throw new IllegalStateException("La cuenta no está activa");
        }
    }

    private void validatePositiveAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
    }

    // =========================
    // GETTERS
    // =========================
    public BigDecimal getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}