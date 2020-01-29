package es.deusto.ingenieria.sd.server.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.*; 


public class ReservationDTO implements Serializable{

	
	private String code;
	private int price;
	private UserDTO user;
	private ArrayList<FlightInfoDTO> flight;
	private ArrayList<PassengerDTO> passengers;
	
	public ReservationDTO(String code, int price, UserDTO user, ArrayList<FlightInfoDTO> flight, ArrayList<PassengerDTO> passengers) {
		super();
		this.code = code;
		this.price = price;
		this.user = user;
		this.flight = flight;
		this.passengers = passengers;
	}


	@Override
	public String toString() {
		return "ReservationDTO [code=" + code + ", price=" + price + ", user=" + user + ", flights=" + flight + "]";
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public ArrayList<FlightInfoDTO> getFlight() {
		return flight;
	}


	public void setFlights(ArrayList<FlightInfoDTO> flight) {
		this.flight = flight;
	}
	
	public ArrayList<PassengerDTO> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<PassengerDTO> passengers) {
		this.passengers = passengers;
	}
	
	public List<PassengerDTO> getPassengerList(){
		return passengers;
	}
	
}
