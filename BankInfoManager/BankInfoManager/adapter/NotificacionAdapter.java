package BankInfoManager.adapter;

import BankInfoManager.port.NotificacionPort;

public class NotificacionAdapter implements NotificacionPort {

    @Override
    public void enviar(String mensaje) {
        System.out.println("NOTIFICACIÓN: " + mensaje);
    }
}