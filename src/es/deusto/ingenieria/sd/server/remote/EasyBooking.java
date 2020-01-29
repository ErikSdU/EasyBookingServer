package es.deusto.ingenieria.sd.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


import es.deusto.ingenieria.sd.server.data.dto.Assembler;
import es.deusto.ingenieria.sd.server.data.dto.FlightInfoDTO;
import es.deusto.ingenieria.sd.server.data.dto.PassengerDTO;
import es.deusto.ingenieria.sd.server.data.dto.ReservationDTO;
import es.deusto.ingenieria.sd.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.server.data.info.Flight;
import es.deusto.ingenieria.sd.server.data.info.Passenger;
import es.deusto.ingenieria.sd.server.data.info.User;
import es.deusto.ingenieria.sd.server.service.BookService;
import es.deusto.ingenieria.sd.server.service.FlightSearchService;
import es.deusto.ingenieria.sd.server.service.LoginService;
import es.deusto.ingenieria.sd.server.service.RegisterService;


public class EasyBooking extends UnicastRemoteObject implements IEasyBooking{

	private static final long serialVersionUID = 1L;
	private String serverName;
	private BookService bookingservice;
	private LoginService loginservice;
	private FlightSearchService flightSearchservice;
	private RegisterService registrationService;

	public EasyBooking(String serverName) throws RemoteException {
		
		super();
		System.out.println("A");
		this.serverName = serverName;
		System.out.println("B");
		this.bookingservice = new BookService();
		System.out.println("C");
		this.flightSearchservice = new FlightSearchService();
		System.out.println("D");
		this.loginservice = new LoginService();
		System.out.println("E");
		this.registrationService = new RegisterService();
		System.out.println("F");
	}
	
	public List<FlightInfoDTO> getFlights(String airportDeparture, String airportArrival, String dateDeparture,
			int numPeople) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("dato3");
		List<FlightInfoDTO> listflights = new ArrayList<FlightInfoDTO>();

		Assembler assembler = new Assembler();
		
		listflights = assembler.assembleFlights(flightSearchservice.searchFlight(airportDeparture, airportArrival, dateDeparture,
				numPeople));
		System.out.println("dto4");
		return listflights;
	}
	
	@Override
	public UserDTO login(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("log 1");
		loginservice.checkUser(email, password);
		return null;
	}

	@Override
	public UserDTO register(String email, String password, String name, String username, String defaultAirport)
			throws RemoteException {
		System.out.println("r0.2");
		// TODO Auto-generated method stub
		return registrationService.registration(email, password, name, username, defaultAirport);

	}

	@Override
	public ReservationDTO book(ArrayList<FlightInfoDTO> flights, ArrayList<PassengerDTO> passengers, UserDTO user,
			String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	//Booking
}
