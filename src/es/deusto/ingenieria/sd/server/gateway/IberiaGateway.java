package es.deusto.ingenieria.sd.server.gateway;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.ingenieria.sd.server.data.dto.FlightInfoDTO;
import es.deusto.ingenieria.sd.server.data.dto.ReservationDTO;
import es.deusto.ingenieria.sd.server.data.dto.Assembler;

public class IberiaGateway implements IAirlineGateway{

	private Assembler as;
	private String d;
	
	public IberiaGateway() {
		as = new Assembler();
	}
	
	
	public List<FlightInfoDTO> getFlight(String airportDeparture, String airportArrival, String departureDate, int numPeople) throws RemoteException{
		Socket socket;
		DataOutputStream dos;
		DataInputStream din;
		System.out.println("dato 7");
		try {
			socket = new Socket("0.0.0.0", 35600);
			System.out.println("Connected");
			din = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
//			System.out.println("dato 10");
//			dos.writeUTF("get");
//			String output = airportDeparture + "#" + airportArrival + "#" + departureDate + "#" + numPeople;
//			dos.writeUTF(output);
//			dos.flush();
//			System.out.println("dato 11");
//			List<FlightInfoDTO> list = (List<FlightInfoDTO>) ois.readObject();
//			socket.close();
//			System.out.println("dato 8");
//			return list;
			String data = din.readUTF();
			d = data;
			System.out.println(" - TCPSocketClient: Received data from '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + d + "'");
		}catch (EOFException e) {
			System.out.println("dato 9, EOF");
			e.printStackTrace();
			
		}catch (UnknownHostException e) {
			System.out.println("dato 9, Socket");
			e.printStackTrace();
		
		}catch (IOException e) {
			System.out.println("dato 9, IO");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public boolean notifyAirline(ReservationDTO reservation) throws RemoteException {
//		Socket socket;
//		ObjectOutputStream oos;
//		DataInputStream dis;
//		try {
//			socket = new Socket("localhost", 35600);
//			System.out.println("Connected");
//			oos = new ObjectOutputStream(socket.getOutputStream());
//			dis = new DataInputStream(socket.getInputStream());
//			
//			oos.writeUTF("ntf");
//			oos.writeObject(reservation);
//			oos.flush();
//			
//			return dis.readBoolean();
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		return false;
		
	}
	
	
	
}
