package com.example.oryossipof.securitymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEventAct extends AppCompatActivity {
    private TextView dateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy "/* hh:mm*/);
        String currentDateandTime = sdf.format(new Date());

        dateTxt = (TextView)findViewById(R.id.datetxt);
        dateTxt.setText(currentDateandTime);
    }
}
