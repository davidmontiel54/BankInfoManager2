package BankInfoManager.service;

import java.math.BigDecimal;

import BankInfoManager.model.audit.AuditLog;
import BankInfoManager.model.products.BankAccount;
import BankInfoManager.port.CuentaRepositoryPort;

public class TransactionService {

    private final CuentaRepositoryPort cuentaRepository;
    private final AuditLog auditLog;


    public TransactionService(CuentaRepositoryPort cuentaRepository, AuditLog auditLog) {
        this.cuentaRepository = cuentaRepository;
        this.auditLog = auditLog;
    }


    public void realizarTransferencia(String origen, String destino, BigDecimal monto) {


        BankAccount cuentaOrigen = cuentaRepository.buscarPorNumero(origen);
        BankAccount cuentaDestino = cuentaRepository.buscarPorNumero(destino);

 
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("Cuenta de origen no encontrada.");
        }

        if (cuentaDestino == null) {
            throw new IllegalArgumentException("Cuenta de destino no encontrada.");
        }

        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }

        if (cuentaOrigen.getBalance().compareTo(monto) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }


        cuentaOrigen.withdraw(monto);
        cuentaDestino.deposit(monto);


        cuentaRepository.guardar(cuentaOrigen);
        cuentaRepository.guardar(cuentaDestino);


        auditLog.registerOperation(
                "TRANSFERENCIA: " + origen + " -> " + destino + " MONTO: " + monto
        );
    }
}