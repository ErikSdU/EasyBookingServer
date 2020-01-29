package es.deusto.ingenieria.sd.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.server.data.dto.FlightInfoDTO;
import es.deusto.ingenieria.sd.server.data.dto.PassengerDTO;
import es.deusto.ingenieria.sd.server.data.dto.ReservationDTO;
import es.deusto.ingenieria.sd.server.data.dto.UserDTO;

public interface IEasyBooking extends Remote {
	public List<FlightInfoDTO> getFlights(String airportDeparture, String airportArrival, String dateDeparture, int numPeople)throws RemoteException;
	public UserDTO login(String email, String password)throws RemoteException;
	public UserDTO register(String email,String password,String name,String username, String defaultAirport) throws RemoteException;
	public ReservationDTO book(ArrayList<FlightInfoDTO> flights, ArrayList<PassengerDTO> passengers, UserDTO user, String password) throws RemoteException;
}