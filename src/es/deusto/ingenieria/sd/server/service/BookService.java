package es.deusto.ingenieria.sd.server.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.ingenieria.sd.server.dao.EasyBookingDAO;
import es.deusto.ingenieria.sd.server.dao.IEasyBookingDAO;
import es.deusto.ingenieria.sd.server.data.dto.Assembler;
import es.deusto.ingenieria.sd.server.data.dto.ReservationDTO;
import es.deusto.ingenieria.sd.server.data.info.Flight;
import es.deusto.ingenieria.sd.server.data.info.Passenger;
import es.deusto.ingenieria.sd.server.data.info.Reservation;
import es.deusto.ingenieria.sd.server.data.info.User;
import es.deusto.ingenieria.sd.server.gateway.IberiaGateway;
import es.deusto.ingenieria.sd.server.gateway.LufthansaGateway;
import es.deusto.ingenieria.sd.server.gateway.VisaGateway;


public class BookService {

	private VisaGateway visa;
	private IberiaGateway iberia;
	private LufthansaGateway lufthansa;
	private IEasyBookingDAO dao;
	@SuppressWarnings("unused")
	private Assembler assembler;

	public BookService() {

		System.out.println("AA");
		this.visa = new VisaGateway();

		System.out.println("BB");
		iberia = new IberiaGateway();

		System.out.println("CC");
		lufthansa = new LufthansaGateway();

		System.out.println("DD");
		dao=new EasyBookingDAO();

		System.out.println("EE");
		assembler=new Assembler();

		System.out.println("FF");
	}

	public synchronized ReservationDTO bookFlight(ArrayList<Flight> flights, ArrayList<Passenger> passengers, String cardNumber,
			User user, String password) {
		int numberSeat = passengers.size() + 1;
		Assembler assembler = new Assembler();
		Reservation reservation = new Reservation(""+((int) (Math.random() * 99999999 + 10000000)), (int) (Math.random() * 300 + 100) * numberSeat,
				user, flights, passengers);

		try {
			if (visa.makePayment(cardNumber, password, reservation.getPrice())) {
				lufthansa.notifyAirline(assembler.assembleReservation(reservation));
				iberia.notifyAirline(assembler.assembleReservation(reservation));
				dao.storeReservation(reservation);
				return assembler.assembleReservation(reservation);
			} else {
				return null;
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public synchronized boolean MakePayment(String cardNumber, String password, int price) throws RemoteException {
		return visa.makePayment(cardNumber, password, price);
		
	}
	
	


}
