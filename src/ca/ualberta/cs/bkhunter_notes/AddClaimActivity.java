package ca.ualberta.cs.bkhunter_notes;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddClaimActivity extends FragmentActivity {
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
		Toast.makeText(this, "temp button, adds claim", Toast.LENGTH_SHORT).show();
		ClaimController ct = new ClaimController();
		EditText textView = (EditText)findViewById(R.id.claimEditText);
		Claim claim = new Claim(textView.getText().toString());
		ct.addIt(claim);
		
	}
	
	
}
