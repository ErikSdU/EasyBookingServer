package es.deusto.ingenieria.sd.server.EasyBooking;


import java.rmi.Naming;

import es.deusto.ingenieria.sd.server.remote.IEasyBooking;
import es.deusto.ingenieria.sd.server.remote.EasyBooking;

public class EasyBookingServer {
	
	
	
	
	

		public static void main(String[] args) {
			if (args.length != 3) {
				System.exit(0);
			}

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}

			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

			try {			
				
				IEasyBooking EBData = new EasyBooking(name);
				Naming.rebind(name, EBData);
				System.out.println("* EasyBooking Service '" + name + "' active and waiting...");
				
			} catch (Exception e) {
				System.err.println("$ EasyBooking exception: " + e.getMessage());
				e.printStackTrace();
			}
		}
	
//	public static void main(String[] args) {
//		System.out.println("1");
//		if (args.length != 4) {
//			System.exit(0);
//		}
//		System.out.println("2");
//		
//		if (System.getSecurityManager() == null) {
//			System.setSecurityManager(new SecurityManager());
//		}
//		System.out.println("3");
//		
//		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
//		System.out.println("4");
//		
//		try {			
//			IEasyBooking EBData = new EasyBooking(name);
//			System.out.println("5");
//			
//			Naming.rebind(name, EBData);
//			System.out.println("6");
//			
//			System.out.println("* EasyBooking Service '" + name + "' active and waiting...");
//		} catch (Exception e) {
//			System.err.println("$ EasyBooking exception: " + e.getMessage());
//			e.printStackTrace();
//		}
//	}
}
