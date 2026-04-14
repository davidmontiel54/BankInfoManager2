package BankInfoManager.port;

import BankInfoManager.model.transactions.Transfer;

public interface TransferenciaPort {

    Transfer guardarTransferencia(Transfer transfer);
}
