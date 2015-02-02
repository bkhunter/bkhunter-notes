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

// This class implements changing a Claim's status (submitted, returned, etc.)
public class ChangeStatus extends Activity
{
	
	public int index;

	
	public int getIndex()
	{
	
		return index;
	}

	
	public void setIndex(int index)
	{
	
		this.index = index;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_status_activity);
		ClaimListManager.initManager(this.getApplicationContext());
		
		Bundle bundle = getIntent().getExtras();
		int index = bundle.getInt("index");
		this.setIndex(index);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.change_status, menu);
		return true;
	}
	
	
	/* What follows is a separate function for each status
	 type, each correspond to the appropriate button. They
	 Each change the status and return.
	 */

	
	public void InProgAction(View v) {
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		Claim claim = list.get(this.getIndex());
		
		claim.setStatus("In Progress");
		
		Intent intent = new Intent(ChangeStatus.this, ViewClaim.class);
		
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle);
    	
		startActivity(intent);
	}
	
	public void SubmittedAction(View v) {
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		Claim claim = list.get(this.getIndex());
		
		claim.setStatus("Submitted");
		
		Intent intent = new Intent(ChangeStatus.this, ViewClaim.class);
		
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle);
    	
		startActivity(intent);
	}
	
	public void ApprovedAction(View v) {
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		Claim claim = list.get(this.getIndex());
		
		claim.setStatus("Approved");
		
		Intent intent = new Intent(ChangeStatus.this, ViewClaim.class);
		
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle);
    	
		startActivity(intent);
	}
	
	public void ReturnedAction(View v) {
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		Claim claim = list.get(this.getIndex());
		
		claim.setStatus("Returned");
		
		Intent intent = new Intent(ChangeStatus.this, ViewClaim.class);
		
		int position = this.getIndex();
		Bundle bundle = new Bundle();
    	bundle.putInt("index", position); 
    	intent.putExtras(bundle);
    	
		startActivity(intent);
	}
	

}
