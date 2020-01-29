package es.deusto.ingenieria.sd.server.service;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.server.dao.EasyBookingDAO;
import es.deusto.ingenieria.sd.server.dao.IEasyBookingDAO;
import es.deusto.ingenieria.sd.server.data.dto.Assembler;
import es.deusto.ingenieria.sd.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.server.data.info.User;
import es.deusto.ingenieria.sd.server.gateway.GoogleGateway;
import es.deusto.ingenieria.sd.server.gateway.TwitterGateway;


public class LoginService {

//	private GoogleGateway googlegateway;
	private TwitterGateway twittergateway;
	private IEasyBookingDAO ebDAO;
	private Assembler assembler;
	private User user;
	public LoginService() {
		//this.googlegateway = new GoogleGateway();
		this.twittergateway = new TwitterGateway();
		this.ebDAO=new EasyBookingDAO();
	}

	public UserDTO checkUser(String email, String password) {
		System.out.println("log2");
		
		try {
			user = new User("ruben@gmail.com", "1234", "ruben", "ruben", "bilbao");
			ebDAO.registerUser(user);
			if (twittergateway.connect(email, password)) {
				System.out.println("log3");
				return assembler.assembleUsers(ebDAO.getUser(email));
//			} else if(googlegateway.connect(email, password)){
//				return assembler.assembleUsers(ebDAO.getUser(email));
			}else {
				System.out.println("log in failed");
				return null;
			}

		} catch (RemoteException e) {
			System.out.println("log no");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
