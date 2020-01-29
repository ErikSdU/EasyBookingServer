package es.deusto.ingenieria.sd.server.data.info;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")

public class Airline {

	@PrimaryKey
	private String name;
	
	public Airline(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Airline [name=" + name + "]";
	}
	
}
