package BankInfoManager.model.users;

public enum SystemRole {

    ADMIN,
    CLIENT,
    MANAGER,
    AUDITOR;

    public boolean isAdmin() {
        return this == ADMIN;
    }
}