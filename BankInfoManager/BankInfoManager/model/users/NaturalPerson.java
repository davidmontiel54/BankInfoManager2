package BankInfoManager.model.users;

import java.time.LocalDate;
import java.time.Period;

public class NaturalPerson extends User {

    private String lastName;

    public NaturalPerson(int userId,
                         String relatedId,
                         String fullName,
                         String identificationId,
                         String email,
                         String phone,
                         LocalDate birthDate,
                         String address,
                         SystemRole role,
                         UserStatus status,
                         String lastName) {

        super();

        this.lastName = lastName;

        validateAdult();
    }

    public NaturalPerson(String string, String string2, String string3, String string4, String string5, LocalDate of,
            SystemRole client) {
        //TODO Auto-generated constructor stub
    }

    private void validateAdult() {
        int age = Period.between(getBirthDate(), LocalDate.now()).getYears();
        if (age < 18) {
            throw new IllegalStateException("El cliente debe ser mayor de edad.");
        }
    }

    public String getLastName() {
        return lastName;
    }
}