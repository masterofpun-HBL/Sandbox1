package com.hbl.sandbox1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ListView menuListView;
    FragmentManager manager;

    String titles[] = new String[]
            {"Retrofit Recycler",
                    "Volley Recycler",
                    "SQLite Recycler"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuListView = (ListView) findViewById(R.id.drawer_list);
        menuListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
        menuListView.setOnItemClickListener(this);

        manager = getSupportFragmentManager();
        menuListView.setItemChecked(0, true);

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
