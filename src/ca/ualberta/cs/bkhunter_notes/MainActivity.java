// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.View;
import android.view.ViewDebug.IntToString;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

// MainActivity supports adding claims, populating a listview
// with clickable items, and dialog prompts that lead to either
// deleting a claim, viewing a claim, and seeing it's currenc totals
public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ClaimListManager.initManager(this.getApplicationContext());
		
		ListView  listView = (ListView)findViewById(R.id.claimListView);
		
		Collection<Claim> claim = ClaimController.getClaimList().getClaims();
		
		final ArrayList<Claim> list = new ArrayList<Claim>(claim);
		
		Collections.sort(list);
		
		//set list view
		final ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		
		listView.setAdapter(claimAdapter);
		
		//Listener allows in-time updates
		ClaimController.getClaimList().addListener(new Listener() {
			
			@Override
			public void update()
			{
				list.clear();
				Collection<Claim> claim = ClaimController.getClaimList().getClaims();
				list.addAll(claim);
				claimAdapter.notifyDataSetChanged();
				
			}
			
		});
		//dialog set-up
		listView.setOnItemClickListener(new OnItemClickListener() {    
		    @Override
		    
		    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		    	
		    	//Toast.makeText(MainActivity.this, "Delete " + list.get(position).toString() + "?",Toast.LENGTH_LONG).show();
		    	
		    	final int pos = position;
		    	
		    	AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
		    	
		    	adb.setMessage(list.get(position).getName() + " Selected");
		    	adb.setCancelable(true);
		    	
		    	adb.setNeutralButton("View", new OnClickListener() {
		    		
		    		public void onClick(DialogInterface dialog, int which)
					{
						
		    			Intent intent = new Intent(MainActivity.this, ViewClaim.class);
				    	Bundle bundle = new Bundle();
				    	bundle.putInt("index", pos); 
				    	intent.putExtras(bundle); 
						startActivity(intent);
						
					}
		    		
		    	});
		    	
		    	
		    	adb.setPositiveButton("Delete", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						
						Claim claim = list.get(pos);
				    	ClaimController.getClaimList().removeClaim(claim);

						// TODO Auto-generated method stub
						
					}
		    		
		    	});
		    	
		    	
		    	adb.setNegativeButton("Currency", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						
		    			Intent intent = new Intent(MainActivity.this, ViewCurrencyActivity.class);
				    	Bundle bundle = new Bundle();
				    	bundle.putInt("index", pos); 
				    	intent.putExtras(bundle); 
						startActivity(intent);
						
					}
					
		    	});
		    	
		    	adb.show();

		    	return;
		    }
		}); 
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//starts the intent to add a claim
	public void addClaim(View v) {
		Intent intent = new Intent(MainActivity.this, AddClaimActivity.class);
		startActivity(intent);
		
	}
	
}

