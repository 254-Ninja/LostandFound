package com.example.myapplication;

import android.content.Context;
import android.location.Geocoder;

import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;

public class Geolocation {

    public static void getAddress(String locationAddress, Context context, Handler handler){

        Thread thread = new Thread(){
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                List addressList = geocoder.getFromLocationName(locationAddress,1);
            }
        }
    }
}
