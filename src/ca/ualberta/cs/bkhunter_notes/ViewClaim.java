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
		
		String name = list.get(0).getName();
		String dateFrom = list.get(0).getDateFrom();
		String dateTo = list.get(0).getDateTo();
		
		TextView view = (TextView) findViewById(R.id.selectedClaimTextView);
		view.setText(name);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_claim, menu);
		return true;
	}

}
