package ca.ualberta.cs.bkhunter_notes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EditClaimActiviy extends Activity
{

	int index;
	
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
		setContentView(R.layout.edit_claim_activity);
		
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
		getMenuInflater().inflate(R.menu.edit_claim_activiy, menu);
		return true;
	}
	
	public void updateAction(View v) throws ParseException {
		
		int pos = this.getIndex();
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
    	
		Claim claim = list.get(pos);
		
		EditText descriptionEditText = (EditText) findViewById(R.id.descrText);
		EditText nameEditText = (EditText) findViewById(R.id.claimText);
		EditText dfEditText = (EditText) findViewById(R.id.DFText);
		EditText dtEditText = (EditText) findViewById(R.id.DTtext);
		
		String date_from = dfEditText.getText().toString();
		String date_to = dtEditText.getText().toString();
		
		claim.setName(nameEditText.getText().toString());
		claim.setDescription(descriptionEditText.getText().toString());
		claim.setDateFGiven(date_from);
    	claim.setDateTGiven(date_to);
    	
		SimpleDateFormat makeFormat = new SimpleDateFormat("yyyy-MM-dd");	
		Date date2 = (Date) makeFormat.parse(date_from);
		Date date3 = (Date) makeFormat.parse(date_to);
		
		claim.setDateFrom(date2);
		claim.setDateTo(date3);
		
		Intent intent = new Intent(EditClaimActiviy.this, ViewClaim.class); 
		
		Bundle bundle = new Bundle();
    	bundle.putInt("index", pos); 
    	intent.putExtras(bundle); 
   
		startActivity(intent);
		
	}

}
