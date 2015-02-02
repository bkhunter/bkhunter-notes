// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

// This class displays the information of a claim.
// It supports editing the claim, changing it's status
// emailing, viewing it's expenses
// and going back to the MainActivity

public class ViewClaim extends Activity {
	
	int ind;
	
	public void setIndex(int s) {
		this.ind = s;
	}
	
	public int getIndex() {
		return this.ind;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_claim_activity);
		ClaimListManager.initManager(this.getApplicationContext());
		
		Bundle bundle = getIntent().getExtras();
		int index = bundle.getInt("index");
		this.setIndex(index);
		
		//This tutorial, and Student Picker helped me get my listview to display
		//http://www.androidhive.info/2011/10/android-listview-tutorial/ on 01/26/2015
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		String name = list.get(index).getName();
		String dateFrom = list.get(index).getDateFGiven();
		String dateTo = list.get(index).getDateTGiven();
		String description = list.get(index).getDescription();
		String status = list.get(index).getStatus();
		
		TextView descr_view = (TextView) findViewById(R.id.descrTextView);
		TextView claim_view = (TextView) findViewById(R.id.selectedClaimTextView);
		TextView date1_view = (TextView) findViewById(R.id.dateFromDisplayTextView);
		TextView date2_view = (TextView) findViewById(R.id.dateToTextView);
		TextView status_view = (TextView) findViewById(R.id.StatusTextView);
		
		claim_view.setText(name);
		date1_view.setText(dateFrom);
		date2_view.setText(dateTo);
		descr_view.setText(description);
		status_view.setText(status);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_claim, menu);
		return true;
	}
	//method to view a claims expenses
	public void viewExpenseAction(View v) {
		Intent intent = new Intent(ViewClaim.this, ExpenseItems.class);
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle); 
		startActivity(intent);
		
	}
	//Edit claim method
	public void editClaimAction(View v) {
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		Claim claim = list.get(this.getIndex());
		
		if (claim.getStatus().equals("Submitted") || (claim.getStatus().equals("Approved")) ) {
			Toast.makeText(this, "This Claim cannot be editted", Toast.LENGTH_SHORT).show();
		} else {
		
			Intent intent = new Intent(ViewClaim.this, EditClaimActiviy.class);
			int position = this.getIndex();
			Bundle bundle = new Bundle();
	    	bundle.putInt("index", position); 
	    	intent.putExtras(bundle); 
			startActivity(intent);
			
		}
		
		
	}
	//Back to MainAcivity
	public void goBack(View v) throws ParseException {
		Intent intent = new Intent(ViewClaim.this, MainActivity.class);
		startActivity(intent);
				
	}
	//Change the status
	public void ChangeStatus(View v) {
		Intent intent = new Intent(ViewClaim.this, ChangeStatus.class);
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle); 
		startActivity(intent);
		
	}
	//Inspired by user fixEdd
	//https://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application on 02/01/2015
	//Emails the claim
	public void EmailAction(View v) {
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		int index = this.getIndex();
		Claim claim = list.get(index);
		
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("message/rfc822");
		i.putExtra(Intent.EXTRA_SUBJECT, "Claim");
		i.putExtra(Intent.EXTRA_TEXT, claim.toEmailString());
		
		try {
		    startActivity(Intent.createChooser(i, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(ViewClaim.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}

}
