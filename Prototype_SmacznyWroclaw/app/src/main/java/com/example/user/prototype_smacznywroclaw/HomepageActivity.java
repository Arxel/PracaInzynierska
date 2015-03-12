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
import android.widget.Button;
import android.widget.ListView;

public class HomepageActivity extends ActionBarActivity {
    private String[] optionsTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Button newsButton, trailButton, viewButton, closeToMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        optionsTitles = getResources().getStringArray(R.array.Functions);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.drawerList);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                R.string.app_name,  /* "open drawer" description */
                R.string.app_name  /* "close drawer" description */
        );

        //Menu
        newsButton = (Button) findViewById(R.id.button);
        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStart(NewsActivity.class);
            }
        });

        trailButton = (Button) findViewById(R.id.button2);
        trailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStart(SelectTrailActivity.class);
            }
        });

        viewButton = (Button) findViewById(R.id.button3);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  ActivityStart(ViewActivity.class);
            }
        });

        closeToMeButton = (Button) findViewById(R.id.button4);
        closeToMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStart(MapsActivity.class);
            }
        });


        drawerList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, optionsTitles));

        drawerLayout.setDrawerListener(mDrawerToggle);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ActivityStart(NewsActivity.class);
                        break;
                    case 1:
                        ActivityStart(SelectTrailActivity.class);
                        break;
                    case 3:
                        ActivityStart(MapsActivity.class);
                        break;
                }

            }
        });
    }

    private void ActivityStart(Class activity){
        Intent newsIntent = new Intent(HomepageActivity.this,activity);
        HomepageActivity.this.startActivity(newsIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_homepage, menu);
        return true;
    }
}
