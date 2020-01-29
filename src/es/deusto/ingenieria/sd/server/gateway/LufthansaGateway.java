package es.deusto.ingenieria.sd.server.gateway;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.server.data.AirlineServer.ILufthansa;
import es.deusto.ingenieria.sd.server.data.dto.FlightInfoDTO;
import es.deusto.ingenieria.sd.server.data.dto.ReservationDTO;

public class LufthansaGateway implements IAirlineGateway {

	@Override
	public List<FlightInfoDTO> getFlight(String airportDeparture, String airportArrival, String departureDate,
			int numPeople) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("dato7");
		try {
		String name = "//" + "127.0.0.1" + ":" + "1099" + "/" + "Lufthansa";
		ILufthansa stubServer = (ILufthansa) java.rmi.Naming.lookup(name);
		
		List<FlightInfoDTO> l = stubServer.getFlight(airportDeparture, airportArrival, departureDate, numPeople);
		return l;
		}catch (Exception e) {
			System.out.println("PETA LUFTANSA");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean notifyAirline(ReservationDTO reservation) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String name = "//" + "127.0.0.1" + ":" + "1099" + "/" + "Lufthansa";
			ILufthansa stubServer = (ILufthansa) java.rmi.Naming.lookup(name);
			return true;
			//return stubServer.notifyAirline(reservation.getFlight().get(0), reservation.getUser(), reservation.getPassengerList());
			}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
				
		return false;
	}
	
	
}
