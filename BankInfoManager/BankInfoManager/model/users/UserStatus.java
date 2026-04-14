package BankInfoManager.model.users;

public enum UserStatus {

    ACTIVE,
    INACTIVE,
    BLOCKED;

    public boolean canOperate() {
        return this == ACTIVE;
    }
}