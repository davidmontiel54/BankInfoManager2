package BankInfoManager.model.users;

import java.time.LocalDate;

public class Company extends User {

    private String taxId;  // NIT

    public Company(int userId,
                   String relatedId,
                   String fullName,
                   String identificationId,
                   String email,
                   String phone,
                   LocalDate birthDate,
                   String address,
                   SystemRole role,
                   UserStatus status,
                   String taxId) {

        super();

        this.taxId = taxId;

        validateTaxId();
    }

    private void validateTaxId() {
        if (taxId == null || taxId.length() < 8) {
            throw new IllegalArgumentException("NIT inválido.");
        }
    }

    public String getTaxId() {
        return taxId;
    }
}