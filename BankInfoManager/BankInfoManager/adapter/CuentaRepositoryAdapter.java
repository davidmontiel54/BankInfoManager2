package BankInfoManager.adapter;

import BankInfoManager.model.products.BankAccount;
import BankInfoManager.port.CuentaRepositoryPort;

import java.util.ArrayList;
import java.util.List;

public class CuentaRepositoryAdapter implements CuentaRepositoryPort {

    private List<BankAccount> cuentas = new ArrayList<>();

    @Override
    public BankAccount guardar(BankAccount cuenta) {
        cuentas.add(cuenta);
        return cuenta;
    }

    @Override
    public BankAccount buscarPorNumero(String numero) {
        return cuentas.stream()
                .filter(c -> c.getAccountNumber().equals(numero))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BankAccount> listarTodas() {
        return cuentas;
    }
}