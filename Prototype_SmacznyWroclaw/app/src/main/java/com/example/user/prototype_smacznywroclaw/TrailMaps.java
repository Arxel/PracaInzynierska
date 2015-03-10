package com.example.user.prototype_smacznywroclaw;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class TrailMaps extends Activity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
/*
        LatLng remontBar = new LatLng(51.111502, 17.058568);
        LatLng laDonna = new LatLng(51.111691, 17.061808);
        LatLng bazylia = new LatLng(51.107224, 17.059366);
        LatLng cynamonBar = new LatLng(51.111939, 17.065588);
*/

        LatLng przystan = new LatLng(51.114901, 17.032545);
        LatLng panorama = new LatLng(51.117285, 17.035851);
        LatLng karczmaMlynska = new LatLng(51.116007, 17.040783);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(przystan, 13));

/*
        map.addMarker(new MarkerOptions().position(remontBar).snippet("Najlepszy bar we Wrocławiu").title("Remont Bar"));
        map.addMarker(new MarkerOptions().position(laDonna).snippet("Najlepsza restauracja we Wrocławiu").title("La Donna Cannone"));
        map.addMarker(new MarkerOptions().position(bazylia).snippet("Jedyny taki studencki bar we Wrocławiu").title("Bazylia"));
        map.addMarker(new MarkerOptions().position(cynamonBar).snippet("Bar z licencją na włoskie gotowanie").title("Cynamon Bar"));
*/

        map.addMarker(new MarkerOptions().position(przystan).snippet("Kuchnia śródziemnomorska").title("Karczma Przystań"));
        map.addMarker(new MarkerOptions().position(panorama).snippet("Restauracja hotelu").title("Restauracja Panorama"));
        map.addMarker(new MarkerOptions().position(karczmaMlynska).snippet("Restauracja w hotelu Tumskim").title("Karczma Młyńska"));


        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(przystan)
                .add(panorama)
                .add(karczmaMlynska)
        );

        map.setMyLocationEnabled(true);

    }
}