package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

//http://www.mkyong.com/android/android-spinner-drop-down-list-example/ 01/25/2015

public class AddExpenseActivity extends Activity
{
	//Spinners are the drop down lists
	private Spinner categorySpinner, currencySpinner;
	private Button addSingleButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_expense);
	
	}
	
	public void addItemsOnSpinner() {
		categorySpinner = (Spinner)findViewById(R.id.categorySpinner);
		List<String> list = new ArrayList<String>();
		list.add("list 1");
		list.add("list 2");
		list.add("list 3");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter);
		
	}
	
	public void addItemsOnSpinner2() {
		currencySpinner = (Spinner)findViewById(R.id.currencySpinner);
		List<String> list = new ArrayList<String>();
		list.add("list 1");
		list.add("list 2");
		list.add("list 3");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		currencySpinner.setAdapter(adapter);
	}
	
	public void addListenerOnSpinnerItemSelection() {
		categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
		categorySpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}
	
	public void addListenerOnSpinnerItemSelection2() {
		currencySpinner = (Spinner) findViewById(R.id.currencySpinner);
		currencySpinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}
	
	public void addListenerOnButton() {
		
		categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
		currencySpinner = (Spinner) findViewById(R.id.currencySpinner);
		
		addSingleButton = (Button) findViewById(R.id.addSingleButton);
		addSingleButton.setOnClickListener(new OnClickListener() {
	 
		 public void onClick(View v) {
			 Toast.makeText(AddExpenseActivity.this,
					 "OnClickListener : " + "\nSpinner 1 : "
					 + String.valueOf(currencySpinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
		  }
		 
		});
		
		addSingleButton = (Button) findViewById(R.id.addSingleButton);
		addSingleButton.setOnClickListener(new OnClickListener() {
	 
		 public void onClick(View v) {
			 Toast.makeText(AddExpenseActivity.this,
					 "OnClickListener : " + "\nSpinner 1 : "
					 + String.valueOf(categorySpinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
		  }
		 
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_expense, menu);
		return true;
	}

}
