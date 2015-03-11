package com.example.user.prototype_smacznywroclaw;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomepageActivity extends ActionBarActivity {
    private String[] optionsTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private int selectedPosition;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                R.string.app_name,  /* "open drawer" description */
                R.string.app_name  /* "close drawer" description */
        );

        // Set the drawer toggle as the DrawerListener


        optionsTitles = getResources().getStringArray(R.array.Functions);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.drawerList);

        drawerList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, optionsTitles));

        drawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent newsIntent = new Intent(HomepageActivity.this,NewsActivity.class);
                        HomepageActivity.this.startActivity(newsIntent);
                        break;
                    case 1:
                        Intent trailsIntent = new Intent(HomepageActivity.this,SelectTrailActivity.class);
                        HomepageActivity.this.startActivity(trailsIntent);
                        break;
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
