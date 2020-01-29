package es.deusto.ingenieria.sd.server.dao;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.server.data.info.Reservation;
import es.deusto.ingenieria.sd.server.data.info.User;


public class EasyBookingDAO implements IEasyBookingDAO{
	
	private PersistenceManagerFactory pmf;
	
	public EasyBookingDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing a user: " + user.getName());
	       pm.makePersistent(user);
	       tx.commit();
	       System.out.println("registered");
	       System.out.println("" + user.getEmail()+ " "+user.getPassword()+ " "+user.getName()+ " "+user.getUsername()+ " "+user.getDefaultDepAirport());
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing a user: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	   
	}
	

	@Override
	public void storeReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing a reservation: " + reservation.getCode());
	       pm.makePersistent(reservation);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing a reservation: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	}
	
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		User user = null;
	    
		try {
			System.out.println ("   * Querying a User: " + username);
			
	    	tx.begin();
	    	Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE name == '" + username + "'");
	    	query.setUnique(true);
	    	user = (User)query.execute();	    
 	    	tx.commit();
   	    System.out.println("finish querying");
	     } catch (Exception ex) {
		   	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }
		System.out.println("returning user");
		System.out.println(user);
	    return user;
	}

	@Override
	public List<Reservation> getReservations(User user) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		List<Reservation> reservations = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Reservations.");
			
			tx.begin();			
			Extent<Reservation> extent = pm.getExtent(Reservation.class, true);
			
			for (Reservation reservation : extent) {
				reservations.add(reservation);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return reservations;
	}
}