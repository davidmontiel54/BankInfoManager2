package BankInfoManager.model.audit;

import java.time.LocalDateTime;

public class OperationDetail {

    private final String operationType;
    private final String description;
    private final LocalDateTime timestamp;

    public OperationDetail(String operationType, String description) {

        if (operationType == null || operationType.isBlank()) {
            throw new IllegalArgumentException("Tipo de operación obligatorio");
        }

        this.operationType = operationType;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public String getOperationType() {
        return operationType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
