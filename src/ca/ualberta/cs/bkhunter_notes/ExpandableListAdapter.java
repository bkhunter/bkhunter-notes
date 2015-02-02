// Copyright (c) 2015 Ben Hunter
// See LICENSE.txt for copying permission.

package ca.ualberta.cs.bkhunter_notes;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

//I tried to get an expandable list view earlier on, but dedcided against it.
//I don't think I need this class at all, but am afraid at this point to remove it

//**Note try remove this class after submission

public class ExpandableListAdapter extends BaseExpandableListAdapter
{

	@Override
	public Object getChild(int groupPosition, int childPosition)
	{

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition)
	{

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent)
	{

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildrenCount(int groupPosition)
	{

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getGroup(int groupPosition)
	{

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount()
	{

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getGroupId(int groupPosition)
	{

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent)
	{

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasStableIds()
	{

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition)
	{

		// TODO Auto-generated method stub
		return false;
	}

}
