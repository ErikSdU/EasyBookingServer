package es.deusto.ingenieria.sd.server.gateway;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.server.data.PaymentServer.IPay;
public class VisaGateway implements IPayment {


	public boolean makePayment(String cardNumber, String cardHolder, int money) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String name = "//" + "127.0.0.1" + ":" + "1099" + "/" + "Visa";
			IPay stubServer = (IPay) java.rmi.Naming.lookup(name);
			return stubServer.makePaymentVisa(cardNumber, cardHolder, money);
			
		}catch(Exception e) {
			System.out.println("PETA VISA");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	
}
