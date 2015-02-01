package ca.ualberta.cs.bkhunter_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

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

public class AddClaimActivity extends Activity {
	public EditText mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claims);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
		return true;
	}
	
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
		
		if (!name.equals("") && !date_to.equals("") && !date_from.equals("")) {
			Claim claim = new Claim(name, date_from, date_to, description);
			ct.addIt(claim);
			
			//Expense_Item e = new Expense_Item("Test", "test", "description", (float) 5.0, "currency");
			//claim.addExpense_Item(e);
			
			Intent intent = new Intent(AddClaimActivity.this, MainActivity.class);
			startActivity(intent);
		} else {
			Toast.makeText(this,"Please fill out all fields", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	public void addExpenseAction(View v) {
		
		//ClaimController ct = new ClaimController();
		
		//each of these correspond to the text input in each field
		EditText nameTextView = (EditText)findViewById(R.id.claimText);
		EditText descriptionTextView = (EditText)findViewById(R.id.descrText);
		EditText dateFromTextView = (EditText)findViewById(R.id.dateFromText);
		EditText dateToTextView = (EditText)findViewById(R.id.dateToText);
		
		String name = nameTextView.getText().toString();
		String description = descriptionTextView.getText().toString();
		String date_from = dateFromTextView.getText().toString();
		String date_to = dateToTextView.getText().toString();
		
		if (!name.equals("") && !date_to.equals("") && !date_from.equals("")) {
			//Claim claim = new Claim(name, date_from, date_to, description);
			//ct.addIt(claim);
			Intent intent = new Intent(AddClaimActivity.this, AddExpenseActivity.class);
			//intent.putExtra("claim", claim);
			
			Bundle bundle = new Bundle();
	    	bundle.putString("name", name);
	    	bundle.putString("desc", description);
	    	bundle.putString("DF", date_from);
	    	bundle.putString("DT",date_to);
	    	
	    	intent.putExtras(bundle);
	    	
			startActivity(intent);
		} else {
			Toast.makeText(this,"Please fill out all fields", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	
}
