package es.deusto.ingenieria.sd.server.gateway;

import java.rmi.RemoteException;

public interface IAuthorization {

	public boolean connect(String email, String password) throws RemoteException;
}
