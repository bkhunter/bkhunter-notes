// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

// This is the class that corresponds to editing an Expense Activity
// Similarly to editing a claim it first sets the textviews with the
// old data, and allows the user to change it

// Also It allows delete expense_items is done here.
public class EditExpenseActivity extends Activity
{
	
	public int index;
	public int e_index;

	public int getE_index() {
		return e_index;
	}

	public void setE_index(int e_index) {
		this.e_index = e_index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_expense_activity);
		ClaimListManager.initManager(this.getApplicationContext());
		
		Bundle bundle = getIntent().getExtras();
		int ex_index = bundle.getInt("index");
		int c_index = bundle.getInt("c_index");
		
		this.setIndex(c_index);
		this.setE_index(ex_index);
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		Expense_Item eItem = list.get(c_index).getExpenseItems().get(e_index);
		
		String item = eItem.getItem();
		String currency = eItem.getCurrency();
		String category = eItem.getCategory();
		int amount = eItem.getAmount();
		String description = eItem.getDescription();
		String date = eItem.getDate();
		
		EditText itemTextView = (EditText)findViewById(R.id.itemEditText);
		EditText descTextView = (EditText)findViewById(R.id.descrText);
		EditText amountTextView = (EditText)findViewById(R.id.amountView);
		EditText dateTextView = (EditText)findViewById(R.id.dateEditText);
		
		Spinner categorySpinner=(Spinner) findViewById(R.id.categorySpinner);
		Spinner currencySpinner=(Spinner) findViewById(R.id.currencySpinner);
		
		itemTextView.setText(item);
		descTextView.setText(description);
		amountTextView.setText(Integer.toString(amount));
		dateTextView.setText(date);

		int catPosition = 0;
		int curPosition = 0;
		// This is a litle loop to find which spinner item was chosen and
		// display it upon creation
		for (int i = 0; i< 8; i++) {
			if (categorySpinner.getItemAtPosition(i).toString() == category) {
				catPosition = i;
			}
		}
		
		for (int i = 0; i< 5; i++) {
			if (currencySpinner.getItemAtPosition(i).toString() == currency) {
				curPosition = i;
			}
		}
		
		currencySpinner.setSelection(curPosition);
		categorySpinner.setSelection(catPosition);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_expense, menu);
		return true;
	}
	
	//Udates the instance with the new entries
	public void editAction(View v) {
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
    	
		Claim claim = list.get(this.getIndex());
		
		Expense_Item e = claim.getExpenseItems().get(this.getE_index());
		
		EditText itemTextView = (EditText)findViewById(R.id.itemEditText);
		EditText descTextView = (EditText)findViewById(R.id.descrText);
		EditText amountTextView = (EditText)findViewById(R.id.amountView);
		EditText dateTextView = (EditText)findViewById(R.id.dateEditText);
		
		Spinner categorySpinner=(Spinner) findViewById(R.id.categorySpinner);
		Spinner currencySpinner=(Spinner) findViewById(R.id.currencySpinner);
		
		String item = itemTextView.getText().toString();
		String desc = descTextView.getText().toString();
		String category = categorySpinner.getSelectedItem().toString();
		String currency = currencySpinner.getSelectedItem().toString();
		String date = dateTextView.getText().toString();
		
		int amt = Integer.valueOf(amountTextView.getText().toString());
		
		e.setAmount(amt);
		e.setCategory(category);
		e.setCurrency(currency);
		e.setDate(date);
		e.setDescription(desc);
		e.setItem(item);
		
		Intent intent = new Intent(EditExpenseActivity.this, ViewExpenseItemActivity.class);
		
		Bundle bundle = new Bundle();
    	bundle.putInt("c_index", this.getIndex());
    	bundle.putInt("e_index", this.getE_index());
    	intent.putExtras(bundle); 
    	
		startActivity(intent);
		
		
	}
	//deletes the entry and returns to expense_item view
	public void deleteAction(View v) {
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
    	
		Claim claim = list.get(this.getIndex());
		Expense_Item e = claim.getExpenseItems().get(this.getE_index());
		
		claim.getExpenseItems().remove(e);
		
		Intent intent = new Intent(EditExpenseActivity.this, ExpenseItems.class);
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle); 
    	
		startActivity(intent);
	}

}
