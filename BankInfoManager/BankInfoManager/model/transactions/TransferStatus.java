package BankInfoManager.model.transactions;

public enum TransferStatus {

    PENDING,
    COMPLETED,
    REJECTED;

    public boolean isFinalState() {
        return this == COMPLETED || this == REJECTED;
    }
}
