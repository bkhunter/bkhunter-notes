// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.Calendar;

// This class represents an Expense item.
// An instance of this class holds various
// information about an expense such as
// What it was, When it happened, how much
// it cost etc.
public class Expense_Item implements Serializable
{
	public String item;
	public String date;
	public String category;
	public String description;
	public int amount;
	public String currency;
	
	public Expense_Item(String item, String date, String category,
			String description, int amount, String currency)
	{

		super();
		this.item = item;
		this.date = date;
		this.category = category;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		
	}

	//Getters and Setter for each attribute
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getItem()
	{
	
		return item;
	}

	
	public void setItem(String item)
	{
	
		this.item = item;
	}

	
	public String getCategory()
	{
	
		return category;
	}

	
	public void setCategory(String category)
	{
	
		this.category = category;
	}

	
	public String getDescription()
	{
	
		return description;
	}

	
	public void setDescription(String description)
	{
	
		this.description = description;
	}

	
	public int getAmount()
	{
	
		return amount;
	}

	
	public void setAmount(int amount)
	{
	
		this.amount = amount;
	}

	
	public String getCurrency()
	{
	
		return currency;
	}

	
	public void setCurrency(String currency)
	{
	
		this.currency = currency;
	}
	
	// This is used for listview output
	public String toString() {
		return getItem() + "       @" + getDate();
	}
	
	// This is used for converting necessary
	// expense item information into and 
	// email ready string.
	public String toEmailString() {
		
		String amt = Integer.toString(this.getAmount());
	
		StringBuilder builder = new StringBuilder();
		builder.append("  " + this.getItem())
			.append("\n")
			.append("   $"+amt)
			.append(" in ")
			.append(this.getCurrency())
			.append("\n")
			.append("  " + this.getDescription())
			.append("\n")
			.append("\n");
		
		return builder.toString();
	}


}
