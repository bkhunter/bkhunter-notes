package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;


public class ClaimList {
	
	
	protected ArrayList<Claim> claimList;
	protected ArrayList<Listener> listeners;
	
	public ClaimList() {
		
		this.claimList = new ArrayList<Claim>();
		this.listeners = new ArrayList<Listener>();
		
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
		
		for (Listener listener : listeners)
		{
			listener.update();
		}

		
	}
	
	public void addListener(Listener L) {
		
		this.listeners.add(L);
	}
	
	public void removeListener(Listener L) {
		this.listeners.remove(L);
	}
	
}
