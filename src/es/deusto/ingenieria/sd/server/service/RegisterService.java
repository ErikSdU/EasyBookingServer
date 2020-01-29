package es.deusto.ingenieria.sd.server.service;

import es.deusto.ingenieria.sd.server.dao.EasyBookingDAO;
import es.deusto.ingenieria.sd.server.dao.IEasyBookingDAO;
import es.deusto.ingenieria.sd.server.data.dto.Assembler;
import es.deusto.ingenieria.sd.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.server.data.info.User;

public class RegisterService {
	private IEasyBookingDAO dao;
	private Assembler assembler;
	
	public RegisterService() {
		dao=new EasyBookingDAO();
		assembler=new Assembler();
	}
	
	public UserDTO registration (String email, String password, String name, String username, String defaultAirport) {
		System.out.println("r1");
		User user=new User(email, password, name, username, defaultAirport);
		System.out.println("r2");
		dao.registerUser(user);
		System.out.println("r3");
		return assembler.assembleUsers(user);
		
	}
}
