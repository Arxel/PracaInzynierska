package com.example.user.prototype_smacznywroclaw;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebViewFragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomepageActivity extends ActionBarActivity {
    private String[] optionsTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        optionsTitles = getResources().getStringArray(R.array.Functions);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.drawerList);

        drawerList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, optionsTitles));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        Intent trailsIntent = new Intent(HomepageActivity.this,TrailMaps.class);
                        HomepageActivity.this.startActivity(trailsIntent);
                    case 3:
                        Intent mapIntent = new Intent(HomepageActivity.this, MapsActivity.class);
                        HomepageActivity.this.startActivity(mapIntent);
                        break;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_homepage, menu);

        return true;
    }
}
