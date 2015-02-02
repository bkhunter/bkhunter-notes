// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

// This class displays the expense_items. It supports an add button, a
// back to claim button, and a clickable listview, with a dialog prompt

public class ExpenseItems extends Activity implements Serializable{

	private int claim_index;
	private String title;
	
	
	
	
	public String getT()
	{
	
		return title;
	}
	
	public void setTitle(String title)
	{
	
		this.title = title;
	}

	public int getIndex()
	{
	
		return claim_index;
	}

	
	public void setIndex(int index)
	{
	
		this.claim_index = index;
	}

	@Override
	//Sets list view, and makes items clickable
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.expense_items_activity);
		ClaimListManager.initManager(this.getApplicationContext());

		
		Bundle bundle = getIntent().getExtras();
		final int c_index = bundle.getInt("index");
		this.setIndex(c_index);
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		 
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		final Claim claim = list.get(c_index);
		
		final ArrayList<Expense_Item> list2 = claim.getExpenseItems();
		
		final ListView  listView = (ListView)findViewById(R.id.expenseItemsListView);
				
		final ArrayAdapter<Expense_Item> adapter = new ArrayAdapter<Expense_Item>(this,android.R.layout.simple_list_item_1, list2);
		
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {    
			
		    @Override
		    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		    	
		    	final int pos = position;
		    	
		    	AlertDialog.Builder adb = new AlertDialog.Builder(ExpenseItems.this);
		    	
		    	adb.setMessage(list2.get(pos).getItem() + " Selected");
		    	adb.setCancelable(true);
		    	
		    	adb.setPositiveButton("View", new OnClickListener() {
		    		
		    		public void onClick(DialogInterface dialog, int which)
					{
						
		    			Intent intent = new Intent(ExpenseItems.this, ViewExpenseItemActivity.class);
				    	Bundle bundle = new Bundle();
				    	bundle.putInt("index", pos);
				    	bundle.putInt("c_index", c_index);
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
		getMenuInflater().inflate(R.menu.expense_items, menu);
		return true;
	}
	//add Expense_Item method
	public void addDirExpense(View v) {
		Intent intent = new Intent(ExpenseItems.this, AddDirectExpense.class);
		Bundle bundle = new Bundle();
    	bundle.putInt("index", this.getIndex()); 
    	intent.putExtras(bundle); 
		startActivity(intent);
	}
	//Goes back to Claim activity
	public void backAction(View v) {
		Intent intent = new Intent(ExpenseItems.this, ViewClaim.class);
		Bundle bundle = new Bundle();
    	bundle.putInt("index", this.getIndex()); 
    	intent.putExtras(bundle); 
		startActivity(intent);
	}

}
