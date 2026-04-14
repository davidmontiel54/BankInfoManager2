package BankInfoManager.model.audit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuditLog {

    private final String auditId;
    private final List<OperationDetail> operations;

    public AuditLog() {
        this.auditId = UUID.randomUUID().toString();
        this.operations = new ArrayList<>();
    }

    public void registerOperation(String type) {
        String description = null;
        OperationDetail detail = new OperationDetail(type, description);
        operations.add(detail);
    }

    public List<OperationDetail> getOperations() {
        return List.copyOf(operations);
    }

    public String getAuditId() {
        return auditId;
    }
}
