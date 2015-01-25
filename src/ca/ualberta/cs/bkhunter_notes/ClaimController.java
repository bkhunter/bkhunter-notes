package ca.ualberta.cs.bkhunter_notes;


public class ClaimController {
	
	private static ClaimList claimList = null;
	
	static public ClaimList getClaimList() {
		if (claimList == null) {
			claimList = new ClaimList();
		} 
		
		return claimList;
	}
	
	public void addIt(Claim c) {
		if (claimList == null) {
			claimList = new ClaimList();
		}
		
		claimList.addClaim(c);
	}

}
