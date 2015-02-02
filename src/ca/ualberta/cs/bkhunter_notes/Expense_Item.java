package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.Calendar;


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
	
	public String toString() {
		return getItem();
	}
	
	public String toEmailString() {
	
		StringBuilder builder = new StringBuilder();
		builder.append(this.getItem())
			.append("\n")
			.append(this.toString())
			.append(" in ")
			.append(this.getCurrency())
			.append("\n")
			.append(this.getDescription())
			.append("\n");
		
		return builder.toString();
	}


}
