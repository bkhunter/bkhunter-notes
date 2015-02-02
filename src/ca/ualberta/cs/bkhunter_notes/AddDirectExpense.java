// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddDirectExpense extends Activity
{
	
	int index;

	
	public int getIndex()
	{
	
		return index;
	}

	
	public void setIndex(int index)
	{
	
		this.index = index;
	}

	private Spinner categorySpinner, currencySpinner;
	private Button addSingleButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_direct_expense_activity);
		ClaimListManager.initManager(this.getApplicationContext());
		
		Bundle bundle = getIntent().getExtras();
		int index = bundle.getInt("index");
		this.setIndex(index);
	}
	
	public void addItemsOnSpinner() {
		categorySpinner = (Spinner)findViewById(R.id.categorySpinner);
		List<String> list = new ArrayList<String>();
		list.add("list 1");
		list.add("list 2");
		list.add("list 3");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter);
		
	}
	
	public void addItemsOnSpinner2() {
		currencySpinner = (Spinner)findViewById(R.id.currencySpinner);
		List<String> list = new ArrayList<String>();
		list.add("list 1");
		list.add("list 2");
		list.add("list 3");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		currencySpinner.setAdapter(adapter);
	}
	
	public void addListenerOnSpinnerItemSelection() {
		categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
		categorySpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}
	
	public void addListenerOnSpinnerItemSelection2() {
		currencySpinner = (Spinner) findViewById(R.id.currencySpinner);
		currencySpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}
	
	public void addListenerOnButton() {
		
		categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
		currencySpinner = (Spinner) findViewById(R.id.currencySpinner);
		
		addSingleButton = (Button) findViewById(R.id.addSingleButton);
		addSingleButton.setOnClickListener(new OnClickListener() {
	 
		 public void onClick(View v) {
			 Toast.makeText(AddDirectExpense.this,
					 "OnClickListener : " + "\nSpinner 1 : "
					 + String.valueOf(currencySpinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
		  }
		 
		});
		
		addSingleButton = (Button) findViewById(R.id.addSingleButton);
		addSingleButton.setOnClickListener(new OnClickListener() {
	 
		 public void onClick(View v) {
			 Toast.makeText(AddDirectExpense.this,
					 "OnClickListener : " + "\nSpinner 1 : "
					 + String.valueOf(categorySpinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
		  }
		 
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_direct_expense, menu);
		return true;
	}
	
	public void finishAction(View v) {
		
		EditText itemTextView = (EditText)findViewById(R.id.itemEditText);
		EditText descTextView = (EditText)findViewById(R.id.descrText);
		EditText amountTextView = (EditText)findViewById(R.id.amountView);
		EditText dateTextView = (EditText)findViewById(R.id.dateEditText);
		Spinner categorySpinner=(Spinner) findViewById(R.id.categorySpinner);
		Spinner currencySpinner=(Spinner) findViewById(R.id.currencySpinner);


		String item = itemTextView.getText().toString();
		String date = dateTextView.getText().toString();
		String desc = descTextView.getText().toString();
		String category = categorySpinner.getSelectedItem().toString();
		String currency = currencySpinner.getSelectedItem().toString();
		int amt = Integer.valueOf(amountTextView.getText().toString());
		
		if (!item.equals("") && !desc.equals("")) {	
			
			Collection<Claim> c = ClaimController.getClaimList().getClaims();
			 
			ArrayList<Claim> list = new ArrayList<Claim>(c);
			
			Claim claim = list.get(this.getIndex());
			
			Expense_Item e = new Expense_Item(item,date, category, desc, amt, currency);
			
			claim.addExpense_Item(e);
		
			Intent intent = new Intent(AddDirectExpense.this, ExpenseItems.class);
			
			Bundle bundle = new Bundle();
	    	bundle.putInt("index", this.getIndex()); 
	    	intent.putExtras(bundle);
	    	
			startActivity(intent);
			
		} else {
			Toast.makeText(this,"Please fill out all fields", Toast.LENGTH_SHORT).show();
		}
		
		//Toast.makeText(this,"test", Toast.LENGTH_SHORT).show();
	}

}
