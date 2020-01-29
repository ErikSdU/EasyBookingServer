package es.deusto.ingenieria.sd.server.dao;

import java.util.List;

import es.deusto.ingenieria.sd.server.data.info.Reservation;
import es.deusto.ingenieria.sd.server.data.info.User;

public interface IEasyBookingDAO {

	public void registerUser(User user);
	public void storeReservation(Reservation reservation);
	public User getUser(String username);
	public List<Reservation> getReservations(User user);
	
}
