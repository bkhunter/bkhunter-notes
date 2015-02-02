package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

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
		int pos = bundle.getInt("index");
		
		this.setIndex(pos);
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		String name = list.get(index).getName();
		String description = list.get(index).getDescription();
		String DateFrom = list.get(index).getDateFGiven();
		String DateTo = list.get(index).getDateTGiven();
		
		EditText descriptionEditText = (EditText) findViewById(R.id.descrText);
		EditText nameEditText = (EditText) findViewById(R.id.claimText);
		EditText dfEditText = (EditText) findViewById(R.id.DFText);
		EditText dtEditText = (EditText) findViewById(R.id.DTtext);
		
		
		nameEditText.setText(name);
		descriptionEditText.setText(description);
		dfEditText.setText(DateFrom);
		dtEditText.setText(DateTo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_expense, menu);
		return true;
	}

}
