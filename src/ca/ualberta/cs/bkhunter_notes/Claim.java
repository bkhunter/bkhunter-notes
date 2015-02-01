package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.ArrayList;

public class Claim implements Serializable{
	
	
	public String name;
	public String dateFrom;
	public String dateTo;
	public String description;
	public ArrayList<Expense_Item> eItems = null;
	public String status = "In Progress";
	
	public Claim(String n, String dF, String dT, String description) {
		this.name = n;
		this.dateFrom = dF;
		this.dateTo = dT;
		this.description = description;
	}
	
	public void addExpense_Item(Expense_Item e) {
		this.eItems.add(e);
		
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

	
	public String getDescription(){
	
		return description;
	}

	
	public void setDescription(String description){
	
		this.description = description;
	}
	
	public String toString() {
		return getName();
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String s) {
		this.status = s;
	}
	
}
