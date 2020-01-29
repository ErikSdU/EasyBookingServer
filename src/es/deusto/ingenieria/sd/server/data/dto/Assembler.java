package es.deusto.ingenieria.sd.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.server.data.info.Passenger;
import es.deusto.ingenieria.sd.server.data.info.Airline;
import es.deusto.ingenieria.sd.server.data.info.Flight;
import es.deusto.ingenieria.sd.server.data.info.Reservation;
import es.deusto.ingenieria.sd.server.data.info.User;

public class Assembler {
	
	public List<FlightInfoDTO> assembleFlights(List<Flight> flights) {
		List<FlightInfoDTO> flightsDTO = new ArrayList<>();
		
		for(Flight t : flights){
			flightsDTO.add(new FlightInfoDTO(t.getFlightNumber(), t.getTimeDeparture(), t.getTimeArrival(), t.getTotalSeats(),
					t.getAvailableSeats(),
					t.getAirportDepart(),
					t.getAirportArriv(), assembleAirline(t.getAirline())));
		}
		System.out.println("*Assembling Flights...");
		return flightsDTO;
	}
	
	public UserDTO assembleUsers(User u) {
		System.out.println("log u");
		UserDTO usersDTO;
		
		usersDTO = new UserDTO(u.getEmail(), u.getPassword(), u.getName(), u.getUsername(), u.getDefaultDepAirport());
		
		System.out.println("Assemble Users...");
		return usersDTO;
		
	}
	
	
	public ReservationDTO assembleReservation (Reservation r) {
		ReservationDTO reservationDTO;
		ArrayList<FlightInfoDTO> listflights = new ArrayList<>();
		listflights = (ArrayList<FlightInfoDTO>) assembleFlights(r.getFlight());
		reservationDTO = new ReservationDTO(r.getCode(), r.getPrice(), assembleUsers(r.getUser()), listflights,
				assemblePassengers(r.getPassengers()));
		
		System.out.println("Assembling Reservations...");
		return reservationDTO;
	}
	
	public ArrayList<PassengerDTO> assemblePassengers(List<Passenger> passengers) {
		ArrayList<PassengerDTO> passengerDTO = new ArrayList<>();

		for (Passenger p : passengers) {
			passengerDTO.add(new PassengerDTO(p.getUsername(), p.getName()));
		}

		System.out.println("Assembling Passengers ...");

		return passengerDTO;
	}
	
	public String assembleAirline(Airline airline) {
		String airlineDTO;
		airlineDTO = airline.getName();
		
		System.out.println("Assembling Airports...");
		return airlineDTO;
	}
}