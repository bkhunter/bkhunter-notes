package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ExpenseItems extends Activity implements Serializable{

	private int index;
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
		setContentView(R.layout.expense_items_activity);
		
		//Intent intent_prev = getIntent();
		//Claim claim = (Claim) intent_prev.getSerializableExtra("claim");
		
		Bundle bundle = getIntent().getExtras();
		int index = bundle.getInt("index");
		this.setIndex(index);
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		 
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		Claim claim = list.get(index);
		
		final ArrayList<Expense_Item> list2 = claim.getExpenseItems();
		 
		int s = list2.size();
	    this.setIndex(s);
		
		final ListView  listView = (ListView)findViewById(R.id.expenseItemsListView);
				
		final ArrayAdapter<Expense_Item> adapter = new ArrayAdapter<Expense_Item>(this,android.R.layout.simple_list_item_1, list2);
		
		listView.setAdapter(adapter);
		
//		
//		Collection<Expense_Item> eitems = claim.getExpenseItems();
//		
//		ArrayList<Expense_Item> list = new ArrayList<Expense_Item>(eitems);
//		
//		ArrayAdapter<Expense_Item> eAdapter = new ArrayAdapter<Expense_Item>(this, android.R.layout.activity_list_item, list);
//		
//		listView.setAdapter(eAdapter);
		
//		listView.setOnItemClickListener(new OnItemClickListener() {    
//		    @Override
//		    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//		    	
//	//		    	Intent intent = new Intent(ExpenseItems.this, ViewClaim.class);
//	//		    	Bundle bundle = new Bundle();
//	//		    	bundle.putInt("index", position); 
//	//		    	intent.putExtras(bundle); 
//	//				startActivity(intent);
//		    	
//			    	Toast.makeText(this,"Please fill out all fields", Toast.LENGTH_SHORT).show();	    }
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expense_items, menu);
		return true;
	}
	
	public void testToast(View v) {
		int i = getIndex();
		String b = Integer.toString(i);
		Toast.makeText(this,b, Toast.LENGTH_SHORT).show();
	}

}
