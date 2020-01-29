package es.deusto.ingenieria.sd.server.gateway;

import java.rmi.RemoteException;

public interface IPayment {

	public boolean makePayment(String cardNumber, String cardHolder, int money) throws RemoteException;
}
