package ca.ualberta.cs.bkhunter_notes;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class ClaimList implements Serializable {
	
	
	/**
	 * claimList serialization ID
	 */
	private static final long serialVersionUID = -5279760708764549823L;
	
	protected ArrayList<Claim> claimList = null;
	protected transient ArrayList<Listener> listeners = null;
	
	public ClaimList() {
		
		this.claimList = new ArrayList<Claim>();
		this.listeners = new ArrayList<Listener>();
		
	}
	private ArrayList<Listener> getListeners() {
		if (listeners == null) {
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	public Collection<Claim> getClaims() {
		
		return this.claimList;
		
	}
	
	public void addClaim(Claim c) {
	
		this.claimList.add(c);
	}
	
	public void removeClaim(Claim c) {
	
		this.claimList.remove(c);
		notifyListeners();
	}
	
	public int size() {
		return claimList.size();
	}
	
	public boolean contains(Claim c) {
		return false;
	}
	
	public void notifyListeners() {
		
		for (Listener listener : getListeners())
		{
			listener.update();
		}

		
	}
	
	public void addListener(Listener L) {
		
		this.getListeners().add(L);
	}
	
	public void removeListener(Listener L) {
		this.getListeners().remove(L);
	}
	
}
