package ca.ualberta.cs.bkhunter_notes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ExpenseItems extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.expense_items_activity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expense_items, menu);
		return true;
	}

}
