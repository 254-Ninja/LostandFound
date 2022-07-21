package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class LostForm extends AppCompatActivity {

    EditText etPlace;
    Button btSubmit;
    Button submitData;
    TextView tvAddress;

    private TextInputEditText GeneralDescription;

    // Volley variables
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_form);

        etPlace = findViewById(R.id.et_place);
        btSubmit = findViewById(R.id.bt_submit);
        submitData = findViewById(R.id.submitData);
        tvAddress = findViewById(R.id.tv_address);
        GeneralDescription = findViewById(R.id.GeneralDescription);


        btSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String address = etPlace.getText().toString();
                Geolocation geoLocation = new Geolocation();
                geoLocation.getAddress(address,getApplicationContext(), new GeoHandler());
            }
        });

    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    private class GeoHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String address;
            switch (msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    address = bundle.getString("address");
                    break;
                default:
                    address = null;
            }
            tvAddress.setText(address);
        }
    }
}