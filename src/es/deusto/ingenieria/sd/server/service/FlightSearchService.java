package es.deusto.ingenieria.sd.server.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.ingenieria.sd.server.data.dto.FlightInfoDTO;
import es.deusto.ingenieria.sd.server.data.info.Airline;
import es.deusto.ingenieria.sd.server.data.info.Flight;
import es.deusto.ingenieria.sd.server.gateway.IberiaGateway;
import es.deusto.ingenieria.sd.server.gateway.LufthansaGateway;

public class FlightSearchService {

	private IberiaGateway iberia;
	private LufthansaGateway lufthansa;

	public FlightSearchService() {
		
		iberia = new IberiaGateway();
		lufthansa = new LufthansaGateway();
	}

	public synchronized ArrayList<Flight> searchFlight(String airportDeparture, String airportArrival,
			String departureDate, int numPeople) {
		ArrayList<Flight> flights = new ArrayList<>();
		try {
			System.out.println("dato5");
			ArrayList<FlightInfoDTO> flights1 = (ArrayList<FlightInfoDTO>) iberia.getFlight(airportDeparture,
					airportArrival, departureDate, numPeople);
			for (FlightInfoDTO f : flights1) {
				flights.add(new Flight(f.getFlightNumber(), f.getTimeDeparture(), f.getTimeArrival(), f.getTotalSeats(), f.getAvailableSeats(),
						f.getAirportDepart(), f.getAirportArriv(),
						new Airline(f.getAirline())));
			}
			System.out.println("dato6");
			ArrayList<FlightInfoDTO> flights2 = (ArrayList<FlightInfoDTO>) lufthansa.getFlight(airportDeparture,
					airportArrival, departureDate, numPeople);
			for (FlightInfoDTO f : flights2) {
				flights.add(new Flight(f.getFlightNumber(), f.getTimeDeparture(), f.getTimeArrival(), f.getTotalSeats(), f.getAvailableSeats(),
						f.getAirportDepart(), f.getAirportArriv(),
						new Airline(f.getAirline())));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return flights;

	}
}
