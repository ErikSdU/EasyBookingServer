package es.deusto.ingenieria.sd.server.gateway;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.server.data.AuthorizationServer.IAuth;
public class TwitterGateway implements IAuthorization{

	@Override
	public boolean connect(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("log4");
		try {
			System.out.println("log5");
			String name = "//" + "127.0.0.1" + ":" + "1099" + "/" + "Authorization";
			System.out.println("twittergateway print");
			IAuth stubServer = (IAuth) java.rmi.Naming.lookup(name);
			System.out.println("log6");
			return stubServer.connectTwitterService(email, password);
			
		}catch(Exception e) {
			System.out.println("PETA TWTEW");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

}
