// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

// This is Largely taken from StudentPicker. I tried to use it
// to Serialize, but due lack of Time I don't use it effectively.
public class ClaimListManager {
	
	static final String preferenceFile = "claimList";
	static final String clKey = "claimList";
	
	
	Context context;
	private static ClaimListManager claimlistManager = null;
	
	public static void initManager(Context context) {
		if (claimlistManager == null) {
			if (context == null) {
				throw new RuntimeException("missing context for claimListManager");
			}
			claimlistManager = new ClaimListManager(context);		
		}
	}
	
	public ClaimListManager(Context context) {
		
		this.context = context;
	}
	
	public static ClaimListManager getManager() {
		if (claimlistManager == null) {
			throw new RuntimeException("Did not initialize Manager");
		}
		return claimlistManager;
	}
	
	public ClaimList loadClaimList() throws ClassNotFoundException, IOException {
		SharedPreferences settings = context.getSharedPreferences(preferenceFile, context.MODE_PRIVATE);
		String ClaimListData = settings.getString(clKey, "");
		if (ClaimListData.equals("")) {
			return new ClaimList();
		} else {
			return claimListFromString(ClaimListData);
		}
		
	}

	public ClaimList claimListFromString(String claimListData) throws ClassNotFoundException, IOException {
		
		ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(claimListData, Base64.DEFAULT));
		ObjectInputStream is = new ObjectInputStream(bi);
		
		return (ClaimList) is.readObject();
	}

	public void saveClaimList(ClaimList cl) throws IOException {
		SharedPreferences settings = context.getSharedPreferences(preferenceFile, context.MODE_PRIVATE);
		Editor editor = settings.edit();
		editor.putString(clKey,claimListToString(cl));
		editor.commit();
		
	}

	public String claimListToString(ClaimList cl) throws IOException {
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		
		ObjectOutputStream os = new ObjectOutputStream(ba);
		os.writeObject(cl);
		os.close();
		byte bytes[] = ba.toByteArray();
		
		return Base64.encodeToString(bytes, Base64.DEFAULT);
	}
}
