package es.deusto.ingenieria.sd.server.data.info;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Flight {
	@PrimaryKey
	private String flightNumber;
	private String timeDeparture;
	private String timeArrival;
	private int totalSeats;
	private int availableSeats;
	private String airportDepart;
	private String airportArriv;
	@Persistent(defaultFetchGroup = "true")
	private Airline Airline;
	public Flight(String flightNumber, String timeDeparture, String timeArrival, int totalSeats, int availableSeats,
			String airportDepart, String airportArriv, Airline airline) {
		super();
		this.flightNumber = flightNumber;
		this.timeDeparture = timeDeparture;
		this.timeArrival = timeArrival;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.airportDepart = airportDepart;
		this.airportArriv = airportArriv;
		this.Airline = airline;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getTimeDeparture() {
		return timeDeparture;
	}
	public void setTimeDeparture(String timeDeparture) {
		this.timeDeparture = timeDeparture;
	}
	public String getTimeArrival() {
		return timeArrival;
	}
	public void setTimeArrival(String timeArrival) {
		this.timeArrival = timeArrival;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getAirportDepart() {
		return airportDepart;
	}
	public void setAirportDepart(String airportDepart) {
		this.airportDepart = airportDepart;
	}
	public String getAirportArriv() {
		return airportArriv;
	}
	public void setAirportArriv(String airportArriv) {
		this.airportArriv = airportArriv;
	}
	public Airline getAirline() {
		return Airline;
	}
	public void setAirline(Airline airline) {
		Airline = airline;
	}
	
	
}
