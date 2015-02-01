package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ViewClaim extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_claim_activity);
		//http://www.androidhive.info/2011/10/android-listview-tutorial/ on 01/26/2015
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		Bundle bundle = getIntent().getExtras();
		int index = bundle.getInt("index");
		
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

}
