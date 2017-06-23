package com.gjuan.mapas;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
       mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
        map.setMapType(googleMap.MAP_TYPE_NORMAL);//PERMITE ELEGIR EL TIPO DE MAPA
        map.getUiSettings().setZoomControlsEnabled(true); //permite controlar el zoo desde el mapa
        LatLng babahoyo=new LatLng(-1.8005421,-79.5119214);
        LatLng montalvo=new LatLng(-1.767123852532876,-79.25660228255617);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(babahoyo,7));

        MarkerOptions UNIVERSIDAD= new MarkerOptions().title("UTB-FAFI").position(babahoyo);
        MarkerOptions miubic= new MarkerOptions().title("Residencia-Moltalvo").position(montalvo);


        map.addMarker(UNIVERSIDAD);
        map.addMarker(miubic);



    }

    }

