package BankInfoManager.application;

import java.math.BigDecimal;

import BankInfoManager.service.TransactionService;

public class TransferirDineroUseCase {

    private final TransactionService transactionService;


    public TransferirDineroUseCase(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    public void ejecutar(String origen, String destino, BigDecimal monto) {

        validarMonto(monto);

        transactionService.realizarTransferencia(origen, destino, monto);
    }


    public void ejecutar(String origen, String destino, double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }

        ejecutar(origen, destino, BigDecimal.valueOf(monto));
    }


    private void validarMonto(BigDecimal monto) {

        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
    }
}