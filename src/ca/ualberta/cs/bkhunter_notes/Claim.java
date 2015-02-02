// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

// this is the main claim class for the travel claim app.
// It holds all the various information such as claim name,
// description, etc. Each claim has an ArrayList of Expense Items.
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
	// This method is called to display select information about a claim in a listview
	public String toString() {
		return (getName() + "    @" + getDateFGiven());
	}
	
	// This method is called to convert necessary information from a claim to a string
	// which is sent to email app
	public String toEmailString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Claim Report :")
			.append("\n")
			.append("\n")
			.append(this.getName())
			.append("\n")
			.append("\n")
			.append(this.getDateFGiven())
			.append("\n")
			.append(" To ")
			.append("\n")
			.append(this.getDateTGiven())
			.append("\n")
			.append("\n")
			.append(this.getDescription())
			.append("\n")
			.append("\n")
			.append("Status : ")
			.append(this.getStatus())
			.append("\n")
			.append("\n")
			.append("Expense Items : \n");
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
	// Code from here down was from my trying to implement serialization
	// I do not end up using it, but I think it could be useful down the line
	
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
	
	
	public ArrayList<Expense_Item> getClaims() {
		
		return this.getExpenseItems();
		
	}
	

	
}
