package BankInfoManager.model.products;

public enum ProductStatus {

    ACTIVE,
    CLOSED,
    SUSPENDED;

    public boolean canOperate() {
        return this == ACTIVE;
    }
}