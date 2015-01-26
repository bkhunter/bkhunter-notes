package ca.ualberta.cs.bkhunter_notes;

public class Claim {
	
	
	public String name;
	public String dateFrom;
	public String dateTo;
	//public String description;
	public Expense_Item item = null;
	
	public Claim(String n, String dF, String dT) {
		this.name = n;
		this.dateFrom = dF;
		this.dateTo = dT;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		this.name = s;
	}

	
	public String getDateFrom(){
	
		return dateFrom;
	}

	
	public void setDateFrom(String dateFrom){
		
		this.dateFrom = dateFrom;
	}

	
	public String getDateTo(){
	
		return dateTo;
	}

	
	public void setDateTo(String dateTo){
	
		this.dateTo = dateTo;
	}

	
//	public String getDescription(){
//	
//		return description;
//	}
//
//	
//	public void setDescription(String description){
//	
//		this.description = description;
//	}
	

}
