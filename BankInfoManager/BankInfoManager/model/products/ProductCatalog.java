package BankInfoManager.model.products;

public class ProductCatalog {

    public boolean isEligibleForLoan(double creditScore) {
        return creditScore >= 650;
    }

    public String getAccountTypeDescription(String type) {
        switch (type) {
            case "SAVINGS":
                return "Cuenta de Ahorros";
            case "CHECKING":
                return "Cuenta Corriente";
            default:
                return "Producto desconocido";
        }
    }
}