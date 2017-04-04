package com.hbl.sandbox1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by hbl on 4/4/2017.
 */

public class MenuListExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> headerList;
    private Map<String, List<String>> groupsList;

    public MenuListExpandableAdapter(Context context, List<String> headerList, Map<String, List<String>> groupsList) {
        this.context = context;
        this.headerList = headerList;
        this.groupsList = groupsList;
    }

    @Override
    public int getGroupCount() {
        return this.headerList.size();
    }

    @Override
    public int getChildrenCount(int pos) {
        return this.groupsList.get(headerList.get(pos)).size();
    }

    @Override
    public Object getGroup(int pos) {
        return headerList.get(pos);
    }

    @Override
    public Object getChild(int gpos, int cpos) {
        return this.groupsList.get(headerList.get(gpos)).get(cpos);
    }

    @Override
    public long getGroupId(int pos) {
        return pos;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (null == convertView) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_menu_group, parent, false);
        }
        ImageView icon = (ImageView) convertView.findViewById(R.id.menu_item_icon);
        TextView titleView = (TextView) convertView.findViewById(R.id.menu_item_text);
        String title = (String) getGroup(groupPosition);
        titleView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (null == convertView) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_menu_child, parent, false);
        }
        TextView titleView = (TextView) convertView.findViewById(R.id.child_item_text);
        String title = (String) getChild(groupPosition, childPosition);
        titleView.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
