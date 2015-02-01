package ca.ualberta.cs.bkhunter_notes;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.View;
import android.view.ViewDebug.IntToString;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView  listView = (ListView)findViewById(R.id.claimListView);
		
		Collection<Claim> claim = ClaimController.getClaimList().getClaims();
		
		ArrayList<Claim> list = new ArrayList<Claim>(claim);
		
		ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		
		listView.setAdapter(claimAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {    
		    @Override
		    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		    	
		    	Intent intent = new Intent(MainActivity.this, ViewClaim.class);
		    	Bundle bundle = new Bundle();
		    	bundle.putInt("index", position); 
		    	intent.putExtras(bundle); 
				startActivity(intent);
		    }
		}); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void addClaim(View v) {
		Intent intent = new Intent(MainActivity.this, AddClaimActivity.class);
		startActivity(intent);
		
	}
	
}

