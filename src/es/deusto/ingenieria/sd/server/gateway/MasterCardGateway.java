package es.deusto.ingenieria.sd.server.gateway;

import java.rmi.RemoteException;

public class MasterCardGateway implements IPayment{


	@Override
	public boolean makePayment(String cardNumber, String cardHolder, int money) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
