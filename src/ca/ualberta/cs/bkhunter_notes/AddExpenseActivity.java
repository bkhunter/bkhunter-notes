// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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


// Again the spinners were guided by Mkyong@
//http://www.mkyong.com/android/android-spinner-drop-down-list-example/ 01/25/2015

// This activity adds an expense Item after the user adds a claim from the start menu
public class AddExpenseActivity extends Activity implements Serializable
{
	
	
	//Spinners are the drop down lists
	private Spinner categorySpinner, currencySpinner;
	private Button addSingleButton;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_expense);
		ClaimListManager.initManager(this.getApplicationContext());
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
				Toast.makeText(AddExpenseActivity.this,
						"OnClickListener : " + "\nSpinner 1 : "
								+ String.valueOf(currencySpinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
			}
		});
		addSingleButton = (Button) findViewById(R.id.addSingleButton);
		addSingleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(AddExpenseActivity.this,
						"OnClickListener : " + "\nSpinner 1 : "
								+ String.valueOf(categorySpinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
			}
		});
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_expense, menu);
		return true;
	}
	
	
	public void addOneExpense(View v) throws ParseException{
		//each of these correspond to the text input in each field
		
		//Get all needed fields for claim construction via bundle
		Bundle bundle = getIntent().getExtras();
		String name = bundle.getString("name");
		String description = bundle.getString("desc");
		String date_from = bundle.getString("DF");
		String date_to = bundle.getString("DT");
		
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
		
		// The date input is a String, and must be convert to type Date to sort
		// This method inspired by User Korcholis @
		// http://stackoverflow.com/questions/12455905/how-to-convert-string-to-date-in-android on 02/01/2015
		SimpleDateFormat makeFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date2 = (Date) makeFormat.parse(date_from);
		Date date3 = (Date) makeFormat.parse(date_to);
		
		if (!item.equals("") && !desc.equals("")) {
			ClaimController ct = new ClaimController();
			Claim claim = new Claim(name, date_from, date2, date3, description, date_to);
			Expense_Item e = new Expense_Item(item, date, category, desc, amt, currency);
			
			claim.addExpense_Item(e);
			ct.addIt(claim);
			Intent intent = new Intent(AddExpenseActivity.this, MainActivity.class);
			startActivity(intent);
		} else {
			Toast.makeText(this,"Please fill out all fields", Toast.LENGTH_SHORT).show();
		}
	}
}
