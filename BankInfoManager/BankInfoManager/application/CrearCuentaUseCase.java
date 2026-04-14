package BankInfoManager.application;

import BankInfoManager.model.products.BankAccount;
import BankInfoManager.port.CuentaRepositoryPort;

public class CrearCuentaUseCase {

    private final CuentaRepositoryPort repository;

    public CrearCuentaUseCase(CuentaRepositoryPort repository) {
        this.repository = repository;
    }

    public BankAccount ejecutar(BankAccount cuenta) {
        return repository.guardar(cuenta);
    }
}