package com.hbl.sandbox1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ExpandableListView menuListView;
    FragmentManager manager;
    MenuListExpandableAdapter adapter;

    Map<String, List<String>> map;
    List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuListView = (ExpandableListView) findViewById(R.id.drawer_list);

        populateMap();

        adapter = new MenuListExpandableAdapter(this, titles, map);

        menuListView.setAdapter(adapter);
        menuListView.setOnItemClickListener(this);

        manager = getSupportFragmentManager();
        menuListView.setItemChecked(0, true);

    }

    void populateMap() {
        titles = new ArrayList<>();
        titles.add("Retrofit Recycler");
        titles.add("Volley Recycler");
        titles.add("SQLite Recycler");

        List<String> retro = new ArrayList<>();
        retro.add("blah blah");
        retro.add("blah blah");
        retro.add("blah blah");
        retro.add("blah blah");
        List<String> volley = new ArrayList<>();
        volley.add("blah blah");
        volley.add("blah blah");
        List<String> sqlist = new ArrayList<>();
        sqlist.add("blah blah");
        sqlist.add("blah blah");
        sqlist.add("blah blah");

        map = new HashMap<>();
        map.put("Retrofit Recycler", retro);
        map.put("Volley Recycler", volley);
        map.put("SQLite Recycler", sqlist);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                manager.beginTransaction()
                        .replace(R.id.fragment_container, RetroListFragment.newInstance())
                        .commit();
                break;
            case 1:
                manager.beginTransaction()
                        .replace(R.id.fragment_container, VolleyListFragment.newInstance())
                        .commit();
                break;
            case 2:
                manager.beginTransaction()
                        .replace(R.id.fragment_container, SQListFragment.newInstance())
                        .commit();
        }
        drawerLayout.closeDrawers();
    }
}
