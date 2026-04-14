package BankInfoManager.port;

import java.util.List;

import BankInfoManager.model.products.BankAccount;

public interface CuentaRepositoryPort {

    BankAccount guardar(BankAccount cuenta);

    BankAccount buscarPorNumero(String numero);

    List<BankAccount> listarTodas();
}
