package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;


public class ClaimList {
	
	
	protected ArrayList<Claim> claimList;
	
	public ClaimList() {
		
		this.claimList = new ArrayList<Claim>();
		
	}
	
	public Collection<Claim> getClaims() {
		
		return this.claimList;
		
	}
	
	public void addClaim(Claim c) {
	
		this.claimList.add(c);
	}
	
	public void removeClaim(Claim c) {
	
		this.claimList.remove(c);
	}
	
	public int size() {
		return claimList.size();
	}
	
	public boolean contains(Claim c) {
		return false;
	}
}
