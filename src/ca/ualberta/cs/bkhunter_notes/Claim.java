package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Claim implements Serializable, Comparable<Claim> {
	
	
	/**
	 * Claim Serializable ID
	 */
	private static final long serialVersionUID = 8828718735747595331L;
	public String name;
	public Date dateFrom;
	public Date dateTo;
	public String description;
	public ArrayList<Expense_Item> eItems;
	public String status = "In Progress";
	public String dateFGiven;
	public String dateTGiven;
	
	public Claim(String n, String dateFGiven, Date dF, Date dT, String description, String dateTGiven) {
		
		this.name = n;
		this.dateFrom = dF;
		this.dateTo = dT;
		this.description = description;
		this.dateFGiven = dateFGiven;
		this.dateTGiven = dateTGiven;
		
		
		this.eItems = new ArrayList<Expense_Item>();
		
	}
	
	
	public String getDateFGiven()
	{
	
		return dateFGiven;
	}

	
	public void setDateFGiven(String dateFGiven)
	{
	
		this.dateFGiven = dateFGiven;
	}

	
	public String getDateTGiven()
	{
	
		return dateTGiven;
	}

	
	public void setDateTGiven(String dateTGiven)
	{
	
		this.dateTGiven = dateTGiven;
	}

	public void addExpense_Item(Expense_Item e) {
		this.eItems.add(e);	
	}
	
	public ArrayList<Expense_Item> getExpenseItems() {
		return this.eItems;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		this.name = s;
	}

	
	public Date getDateFrom(){
	
		return dateFrom;
	}

	
	public void setDateFrom(Date dateFrom){
		
		this.dateFrom = dateFrom;
	}

	
	public Date getDateTo(){
	
		return dateTo;
	}

	
	public void setDateTo(Date dateTo){
	
		this.dateTo = dateTo;
	}

	public String getDescription(){
	
		return description;
	}

	
	public void setDescription(String description){
	
		this.description = description;
	}
	
	public String toString() {
		return (getName() + "    @" + getDateFGiven());
	}
	
	public String toEmailString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getName())
			.append("\n")
			.append(this.getDateFGiven())
			.append(" To ")
			.append(this.getDateTGiven())
			.append("\n")
			.append(this.getDescription())
			.append("\n")
			.append(this.getStatus())
			.append("\n");
	for (Expense_Item item : this.getExpenseItems()) {
		builder.append(item.toEmailString());
		
	}
	
	return builder.toString();
	}
			

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String s) {
		this.status = s;
	}
	
	public int compareTo(Claim other) {
		
	      if (other.getDateFrom() == null) {
	    	  //Log.i("LOL", "uh oh it's null")
		        return 0;
	      }
	      
	      return this.getDateFrom().compareTo(other.getDateFrom());
		
		
	}
	public boolean equals(Object compareClaim) {
		if (compareClaim == null) {
			return false;
		} 
		if (compareClaim.getClass()==this.getClass()) {
			return this.equals((Claim) compareClaim);
		} else {
			return false;
		}
	}
	
	public boolean equals(Claim compareClaim) {
		if (compareClaim == null) {
			return false;
		} 
		return this.getName().equals(compareClaim.getName());
	}
	
	public int hashCode() {
		return ("Claim:"+this.getName()).hashCode();
	}
	
}
