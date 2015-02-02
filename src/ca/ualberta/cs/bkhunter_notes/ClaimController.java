package ca.ualberta.cs.bkhunter_notes;

import java.io.IOException;


public class ClaimController {
	
	private static ClaimList claimList = null;
	
	static public ClaimList getClaimList() {
		if (claimList == null) {
			try {
				claimList = ClaimListManager.getManager().loadClaimList();
				claimList.addListener(new Listener() {
					
					@Override
					public void update() {
						saveClaimList();
						
					}
				});
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("could not deserialize");
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("could not deserialize");
			}
			claimList = new ClaimList();
		} 
		
		return claimList;
	}
	
	static public void saveClaimList() {
		try {
			ClaimListManager.getManager().saveClaimList(getClaimList());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("could not deserialize");
		}
		claimList = new ClaimList();
	} 
		
	
	public void addIt(Claim c) {
		if (claimList == null) {
			claimList = new ClaimList();
		}
		
		claimList.addClaim(c);
	}

}
