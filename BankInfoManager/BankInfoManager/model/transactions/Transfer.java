package BankInfoManager.model.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import BankInfoManager.model.products.BankAccount;

public class Transfer {

    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private BigDecimal amount;
    private TransferStatus status;
    public Transfer(Long transferId,
                    BankAccount sourceAccount,
                    BankAccount destinationAccount,
                    BigDecimal amount) {

        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.status = TransferStatus.PENDING;
        LocalDateTime.now();

        validateTransfer();
    }

    public Transfer(String string, BankAccount account1, BankAccount account2, int i) {
   
    }

    private void validateTransfer() {

        if (sourceAccount == null || destinationAccount == null) {
            throw new IllegalArgumentException("Cuentas inválidas");
        }

        if (sourceAccount == destinationAccount) {
            throw new IllegalArgumentException("No se puede transferir a la misma cuenta");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
    }

    public void execute() {

        if (status.isFinalState()) {
            throw new IllegalStateException("Transferencia ya procesada");
        }

        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);

        status = TransferStatus.COMPLETED;
    }

    public void reject() {
        status = TransferStatus.REJECTED;
    }

    public TransferStatus getStatus() {
        return status;
    }

    public double getFromBalance() {

        throw new UnsupportedOperationException("Unimplemented method 'getFromBalance'");
    }

    public double getAmount() {

        throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
    }

    public String getId() {

        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public Object getFromAccount() {
      
        throw new UnsupportedOperationException("Unimplemented method 'getFromAccount'");
    }

    public Object getToAccount() {
     
        throw new UnsupportedOperationException("Unimplemented method 'getToAccount'");
    }
}