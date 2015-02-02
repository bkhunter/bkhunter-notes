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
import android.widget.TextView;

//This class supports viewing the information of a single
//Expense_Item

//From here you can edit/delete it or go back
public class ViewExpenseItemActivity extends Activity {
	
	int c_ind;
	int e_ind;
	
	public void setIndex(int s) {
		this.c_ind = s;
	}
	
	public int getIndex() {
		return this.c_ind;
	}
	
	public void setEIndex(int s) {
		this.e_ind = s;
	}
	
	public int getEIndex() {
		return this.e_ind;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_expense_item_activity);
		ClaimListManager.initManager(this.getApplicationContext());
		
		Bundle bundle = getIntent().getExtras();
		int ex_index = bundle.getInt("index");
		int c_index = bundle.getInt("c_index");
		this.setIndex(c_index);
		this.setEIndex(ex_index);
		
		//Again, Listview Inspiration from Student picker and 
		//http://www.androidhive.info/2011/10/android-listview-tutorial/ on 01/26/2015
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		Expense_Item e = list.get(c_index).getExpenseItems().get(ex_index);
		
		String item = e.getItem();
		String date = e.getDate();
		String category = e.getCategory();
		String currency = e.getCurrency();
		String description = e.getDescription();
		int amount = e.getAmount();
		
		TextView descr_view = (TextView) findViewById(R.id.descView);
		TextView item_view = (TextView) findViewById(R.id.titleTextView);
		TextView date_view = (TextView) findViewById(R.id.expenseDateView);
		TextView cat_view = (TextView) findViewById(R.id.catView);
		TextView curr_view = (TextView) findViewById(R.id.CurrencyTExt);
		TextView amt = (TextView) findViewById(R.id.amount);
		
		item_view.setText(item);
		descr_view.setText(description);
		date_view.setText(date);
		cat_view.setText(category);
		curr_view.setText(currency);
		amt.setText(Float.toString(amount));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_expense_item, menu);
		return true;
	}
		
		public void editExpenseClaimAction(View v) {
			Intent intent = new Intent(ViewExpenseItemActivity.this, EditExpenseActivity.class);
			
			Bundle bundle = new Bundle();
	    	bundle.putInt("index", this.getEIndex());
	    	bundle.putInt("c_index", this.getIndex());
	    	intent.putExtras(bundle); 
	    	
			startActivity(intent);
			
			
		}
		
		public void returnAction(View v) {
			Intent intent = new Intent(ViewExpenseItemActivity.this, ExpenseItems.class);
			Bundle bundle = new Bundle();
	    	bundle.putInt("index", this.getIndex()); 
	    	intent.putExtras(bundle);
			startActivity(intent);
					
		}
	

	}

