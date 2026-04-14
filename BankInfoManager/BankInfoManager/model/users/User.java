package BankInfoManager.model.users;

import java.time.LocalDate;

public abstract class User {
    
    private int userId;                
    private String relatedId;          
    private String fullName;          
    private String identificationId;   
    private String email;              
    private String phone;              
    private LocalDate birthDate;       
    private String address;           
    private SystemRole role;           
    private UserStatus status;         

    public User() {
    }


    public boolean isValidEmail() {
    return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }


    public boolean isValidPhone() {
    if (phone == null) return false;
    String digits = phone.replaceAll("\\D", "");
    return digits.length() >= 7 && digits.length() <= 15;
}

    public boolean isActive() {
        return this.status == UserStatus.ACTIVE;
    }


    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getRelatedId() { return relatedId; }
    public void setRelatedId(String relatedId) { this.relatedId = relatedId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getIdentificationId() { return identificationId; }
    public void setIdentificationId(String identificationId) { this.identificationId = identificationId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public SystemRole getRole() { return role; }
    public void setRole(SystemRole role) { this.role = role; }

    public UserStatus getStatus() { return status; }
    public void setStatus(UserStatus status) { this.status = status; }
}