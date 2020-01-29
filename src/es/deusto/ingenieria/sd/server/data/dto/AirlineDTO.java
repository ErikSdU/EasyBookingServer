package es.deusto.ingenieria.sd.server.data.dto;

import java.io.Serializable;

public class AirlineDTO implements Serializable{

	private static final long serialVersionUTD = 1L;
	private String name;
	public AirlineDTO(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
