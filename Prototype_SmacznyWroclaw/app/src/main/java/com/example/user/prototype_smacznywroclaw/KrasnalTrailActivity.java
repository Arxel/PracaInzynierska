package com.example.user.prototype_smacznywroclaw;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class KrasnalTrailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krasnal_trail);
    }

    public void szlakKrasnale(View v) {
        Intent krasnalIntent = new Intent(KrasnalTrailActivity.this,TrailMaps.class);
        KrasnalTrailActivity.this.startActivity(krasnalIntent);
    }

    public void objectMap(View v) {
        Intent krasnalIntent = new Intent(KrasnalTrailActivity.this,ObjectMapActivity.class);
        KrasnalTrailActivity.this.startActivity(krasnalIntent);
    }
}
