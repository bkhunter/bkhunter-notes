// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

//This class sums up and shows the total currency amounts 
//for each expense item in a claim

public class ViewCurrencyActivity extends Activity {
	
	public int usd = 0;
	public int cad = 0;
	public int gbr = 0;
	public int eur = 0;
	public int other = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_currency_activity);
		
		Bundle bundle = getIntent().getExtras();
		int index = bundle.getInt("index");
		
		Collection<Claim> c = ClaimController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(c);
		
		Claim claim = list.get(index);
		
		for (Expense_Item item : claim.getExpenseItems()) {
			if (item.getCurrency().equals("USD")) {
				this.usd += item.getAmount();
			}else if (item.getCurrency().equals("CAD")) {
				this.cad += item.getAmount();	
			}else if (item.getCurrency().equals("GBR")) {
				this.gbr += item.getAmount();
			}else if (item.getCurrency().equals("EUR")) {
				this.eur += item.getAmount();
			}else {
				this.other += item.getAmount();
				
			}
		}
			
		TextView usd_view = (TextView) findViewById(R.id.usd);
		TextView cad_view = (TextView) findViewById(R.id.cad);
		TextView gbr_view = (TextView) findViewById(R.id.gbr);
		TextView eur_view = (TextView) findViewById(R.id.eur);
		TextView other_view = (TextView) findViewById(R.id.other);
		
		usd_view.setText(Integer.toString(this.usd));
		cad_view.setText(Integer.toString(this.cad));
		gbr_view.setText(Integer.toString(this.gbr));
		eur_view.setText(Integer.toString(this.eur));
		other_view.setText(Integer.toString(this.other));
		
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_currency, menu);
		return true;
	}

}
