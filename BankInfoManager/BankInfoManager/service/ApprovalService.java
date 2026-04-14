package BankInfoManager.service;

import BankInfoManager.model.audit.AuditLog;
import BankInfoManager.model.products.Loan;
import BankInfoManager.model.transactions.Transfer;

public class ApprovalService {

    private final AuditLog auditLog;

    public ApprovalService(AuditLog auditLog) {
        this.auditLog = auditLog;
    }

    public void approveLoan(Loan loan) {

        loan.approve(); 

        auditLog.registerOperation(
                "LOAN_APPROVAL"
        );
    }

    public boolean approveTransfer(Transfer transfer) {
        
        throw new UnsupportedOperationException("Unimplemented method 'approveTransfer'");
    }
}
