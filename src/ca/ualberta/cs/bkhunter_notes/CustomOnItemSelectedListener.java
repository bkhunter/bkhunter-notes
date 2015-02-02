// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.
package ca.ualberta.cs.bkhunter_notes;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

//Comes from Mkyong@
//http://www.mkyong.com/android/android-spinner-drop-down-list-example/ 01/25/2015
//This custom Listener class displays the text in the spinners
public class CustomOnItemSelectedListener implements OnItemSelectedListener {

	public void onItemSelected(AdapterView<?> parent, View vie, int pos, long id) {
		
		Toast.makeText(parent.getContext(), 
				"OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
				Toast.LENGTH_SHORT).show();

		// TODO Auto-generated method stub

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0)
	{

		// TODO Auto-generated method stub

	}

}
