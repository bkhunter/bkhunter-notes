package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditExpenseActivity extends Activity
{
	
	public int index;
	public int e_index;

	public int getE_index() {
		return e_index;
	}

	public void setE_index(int e_index) {
		this.e_index = e_index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_expense_activity);
		ClaimListManager.initManager(this.getApplicationContext());
		
		Bundle bundle = getIntent().getExtras();
		int ePos = bundle.getInt("index");
		int cPos = bundle.getInt("c_index");
		
		this.setIndex(cPos);
		this.setE_index(ePos);
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		Expense_Item eItem = list.get(cPos).getExpenseItems().get(ePos);
		
		String item = eItem.getItem();
		String currency = eItem.getCurrency();
		String category = eItem.getCategory();
		int amount = eItem.getAmount();
		String description = eItem.getDescription();
		String date = eItem.getDate();
		
		EditText itemTextView = (EditText)findViewById(R.id.itemEditText);
		EditText descTextView = (EditText)findViewById(R.id.descrText);
		EditText amountTextView = (EditText)findViewById(R.id.amountView);
		EditText dateTextView = (EditText)findViewById(R.id.dateEditText);
		
		Spinner categorySpinner=(Spinner) findViewById(R.id.categorySpinner);
		Spinner currencySpinner=(Spinner) findViewById(R.id.currencySpinner);
		
		itemTextView.setText(item);
		descTextView.setText(description);
		amountTextView.setText(Integer.toString(amount));
		dateTextView.setText(date);

		int catPosition = 0;
		int curPosition = 0;
		
		for (int i = 0; i< 8; i++) {
			if (categorySpinner.getItemAtPosition(i).toString() == category) {
				catPosition = i;
			}
		}
		
		for (int i = 0; i< 5; i++) {
			if (currencySpinner.getItemAtPosition(i).toString() == currency) {
				curPosition = i;
			}
		}
		
		
		currencySpinner.setSelection(curPosition);
		categorySpinner.setSelection(catPosition);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_expense, menu);
		return true;
	}
	
	public void editAction(View v) {
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
    	
		Claim claim = list.get(this.getIndex());
		
		Expense_Item e = claim.getExpenseItems().get(this.getE_index());
		
		EditText itemTextView = (EditText)findViewById(R.id.itemEditText);
		EditText descTextView = (EditText)findViewById(R.id.descrText);
		EditText amountTextView = (EditText)findViewById(R.id.amountView);
		EditText dateTextView = (EditText)findViewById(R.id.dateEditText);
		
		Spinner categorySpinner=(Spinner) findViewById(R.id.categorySpinner);
		Spinner currencySpinner=(Spinner) findViewById(R.id.currencySpinner);
		
		String item = itemTextView.getText().toString();
		String desc = descTextView.getText().toString();
		String category = categorySpinner.getSelectedItem().toString();
		String currency = currencySpinner.getSelectedItem().toString();
		String date = dateTextView.getText().toString();
		
		int amt = Integer.valueOf(amountTextView.getText().toString());
		
		e.setAmount(amt);
		e.setCategory(category);
		e.setCurrency(currency);
		e.setDate(date);
		e.setDescription(desc);
		e.setItem(item);
		
		Intent intent = new Intent(EditExpenseActivity.this, ViewExpenseItemActivity.class);
		
		Bundle bundle = new Bundle();
    	bundle.putInt("c_index", this.getIndex());
    	bundle.putInt("e_index", this.getE_index());
    	intent.putExtras(bundle); 
    	
		startActivity(intent);
		
		
		
	}

}
