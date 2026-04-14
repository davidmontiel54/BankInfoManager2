package BankInfoManager;

import BankInfoManager.model.audit.AuditLog;
import BankInfoManager.model.products.BankAccount;
import BankInfoManager.model.users.NaturalPerson;
import BankInfoManager.model.users.SystemRole;
import BankInfoManager.port.CuentaRepositoryPort;
import BankInfoManager.adapter.CuentaRepositoryAdapter;
import BankInfoManager.service.TransactionService;
import BankInfoManager.application.TransferirDineroUseCase;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankApplication {

    public static void main(String[] args) {

        System.out.println("=== BANK INFO MANAGER STARTED ===");

        try {


            NaturalPerson user = new NaturalPerson(
                    "U001",
                    "Carlos",
                    "Lopez",
                    "carlos@mail.com",
                    "1234567890",
                    LocalDate.of(1995, 5, 15),
                    SystemRole.CLIENT
            );


            BankAccount account1 = new BankAccount(
                    "ACC001",
                    user,
                    new BigDecimal("1000")
            );

            BankAccount account2 = new BankAccount(
                    "ACC002",
                    user,
                    BigDecimal.ZERO
            );


            CuentaRepositoryPort repo = new CuentaRepositoryAdapter();
            AuditLog auditLog = new AuditLog();

            repo.guardar(account1);
            repo.guardar(account2);


            TransactionService transactionService =
                    new TransactionService(repo, auditLog);

            TransferirDineroUseCase useCase =
                    new TransferirDineroUseCase(transactionService);


            useCase.ejecutar(
                    "ACC001",
                    "ACC002",
                    new BigDecimal("250")
            );


            System.out.println("Final Balances:");
            System.out.println("Account 1: " + account1.getBalance());
            System.out.println("Account 2: " + account2.getBalance());

        } catch (Exception e) {

            System.out.println("System Error: " + e.getMessage());
        }

        System.out.println("=== SYSTEM FINISHED ===");
    }
}