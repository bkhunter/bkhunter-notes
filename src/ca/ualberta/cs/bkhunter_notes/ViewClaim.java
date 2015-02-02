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
		
		Bundle bundle = getIntent().getExtras();
		int index = bundle.getInt("index");
		this.setIndex(index);
		
		//http://www.androidhive.info/2011/10/android-listview-tutorial/ on 01/26/2015
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		String name = list.get(index).getName();
		String dateFrom = list.get(index).getDateFrom();
		String dateTo = list.get(index).getDateTo();
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
	
	public void viewExpenseAction(View v) {
		Intent intent = new Intent(ViewClaim.this, ExpenseItems.class);
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle); 
		startActivity(intent);
		
	}
	
	public void editClaimAction(View v) {
		Intent intent = new Intent(ViewClaim.this, EditClaimActiviy.class);
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle); 
		startActivity(intent);
		
		
	}
	
	public void goBack(View v) throws ParseException {
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		//Intent intent = new Intent(ViewClaim.this, MainActivity.class);
		//startActivity(intent);
		
		Claim claim = list.get(this.getIndex());
		
		String dateFrom = claim.getDateFrom();
		
		//http://stackoverflow.com/questions/12455905/how-to-convert-string-to-date-in-android on 02/01/2015
		SimpleDateFormat makeFormat = new SimpleDateFormat("yyyyMMdd");
		//String datenow="20120917121823";		
		Date date2 = (Date) makeFormat.parse(dateFrom);
		Date date3 = (Date) makeFormat.parse(claim.dateTo);
		
		
			
		
		Toast.makeText(this, Integer.toString(date2.compareTo(date3)), Toast.LENGTH_SHORT).show();
		
	}

}
