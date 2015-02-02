// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

// This is the main starting activity, from which you
// can add claims, view claims and delete claims.
public class AddClaimActivity extends Activity {
	public EditText mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claims);
		ClaimListManager.initManager(this.getApplicationContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
		return true;
	}
	
	
	// This is the OnClick Method to Add a claim, without an expense Item
	public void addClaimAction(View v) {
		ClaimController ct = new ClaimController();
		
		//each of these correspond to the text input in each field
		EditText nameTextView = (EditText)findViewById(R.id.claimText);
		EditText descriptionTextView = (EditText)findViewById(R.id.descrText);
		EditText dateFromTextView = (EditText)findViewById(R.id.dateFromText);
		EditText dateToTextView = (EditText)findViewById(R.id.dateToText);
		
		String name = nameTextView.getText().toString();
		String description = descriptionTextView.getText().toString();
		String date_from = dateFromTextView.getText().toString();
		String date_to = dateToTextView.getText().toString();
		
		
		// The date input is a String, and must be convert to type Date to sort
		// This method inspired by User Korcholis @
		// http://stackoverflow.com/questions/12455905/how-to-convert-string-to-date-in-android on 02/01/2015
		SimpleDateFormat makeFormat = new SimpleDateFormat("yyyy-MM-dd");
		//String datenow="20120917121823";
		
		Date date2 = null;
		Date date3 = null;;
		
		try
		{
			date3 = (Date) makeFormat.parse(date_to);
			date2 = (Date) makeFormat.parse(date_from);
			
			Claim claim = new Claim(name, date_from,date2,date3,description, date_to);
			ct.addIt(claim);
			
			Intent intent = new Intent(AddClaimActivity.this, MainActivity.class);
			startActivity(intent);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Toast.makeText(this, "Pleae enter date in specified format", Toast.LENGTH_LONG).show();
			
		}
		
		
	}
	// This is the method to add a claim with an expense item
	public void addExpenseAction(View v) {
		
		//each of these correspond to the text input in each field
		EditText nameTextView = (EditText)findViewById(R.id.claimText);
		EditText descriptionTextView = (EditText)findViewById(R.id.descrText);
		EditText dateFromTextView = (EditText)findViewById(R.id.dateFromText);
		EditText dateToTextView = (EditText)findViewById(R.id.dateToText);
		
		String name = nameTextView.getText().toString();
		String description = descriptionTextView.getText().toString();
		String date_from = dateFromTextView.getText().toString();
		String date_to = dateToTextView.getText().toString();
		
		// The date input is a String, and must be convert to type Date to sort
		// This method inspired by User Korcholis @
		// http://stackoverflow.com/questions/12455905/how-to-convert-string-to-date-in-android on 02/01/2015
		SimpleDateFormat makeFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date2 = null;
		Date date3 = null;;
		
		try
		{
			date3 = (Date) makeFormat.parse(date_to);
			date2 = (Date) makeFormat.parse(date_from);
			
			Intent intent = new Intent(AddClaimActivity.this, AddExpenseActivity.class);
			
			Bundle bundle = new Bundle();
	    	bundle.putString("name", name);
	    	bundle.putString("desc", description);
	    	bundle.putString("DF", date_from);
	    	bundle.putString("DT",date_to);
	    	
	    	intent.putExtras(bundle);
	    	
			startActivity(intent);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Toast.makeText(this, "Pleae enter date in specified format", Toast.LENGTH_LONG).show();
			
		}
			
	}
	
	
}
