package es.deusto.ingenieria.sd.server.gateway;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.server.data.dto.FlightInfoDTO;
import es.deusto.ingenieria.sd.server.data.dto.ReservationDTO;

public interface IAirlineGateway {
	
	public List<FlightInfoDTO> getFlight(String airportDeparture, String airportArrival, String departureDate, int numPeople) throws RemoteException;
	public boolean notifyAirline(ReservationDTO reservation) throws RemoteException;
}
