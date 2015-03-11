package com.example.user.prototype_smacznywroclaw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class SelectTrailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trail);

    }

    public void szlakKrasnale(View v) {
        Intent krasnalIntent = new Intent(SelectTrailActivity.this,KrasnalTrailActivity.class);
        SelectTrailActivity.this.startActivity(krasnalIntent);
    }

}
