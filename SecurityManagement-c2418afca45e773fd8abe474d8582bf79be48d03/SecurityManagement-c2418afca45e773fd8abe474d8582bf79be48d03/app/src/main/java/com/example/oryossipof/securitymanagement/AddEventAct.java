package com.example.oryossipof.securitymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEventAct extends AppCompatActivity {
    private TextView dateTxt ,eventText;
    private Firebase myRef;
    private Button showEventsBtt ,addEventBtClass, cancelBT;
    private String currentDateandTime;
    private String currentDateandTime2;
    private String currentDateandTime3;
    private  String myUsername,myID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Intent intent = getIntent();
        this.myUsername = intent.getStringExtra("myUsername");
        this.myID = intent.getStringExtra("myID");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy "/* hh:mm*/);
        currentDateandTime = sdf.format(new Date());
        dateTxt = (TextView)findViewById(R.id.datetxt);
        dateTxt.setText(currentDateandTime);


        myRef = new Firebase("https://securitymanagment-2427a.firebaseio.com/");

        eventText = (EditText) findViewById(R.id.EventText);

        addEventBtClass =  (Button) findViewById(R.id.addEventBT);
        addEventBtClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mm:ss "/* hh:mm*/);
                currentDateandTime = sdf.format(new Date());
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yy hh:mm "/* hh:mm*/);
                currentDateandTime2 = sdf2.format(new Date());

                String str = eventText.getText().toString();
                if(!str.equals("")) {
                    Log.e("Add event:", "addEventBtClass onClick");
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy"/* hh:mm*/);
                    currentDateandTime3 = sdf3.format(new Date());
                    SimpleDateFormat sdf4 = new SimpleDateFormat("hh:mm:ss");
                    String hour_minutes = sdf4.format(new Date());
                    DataBase.addEventToDataBase(currentDateandTime3, myUsername, str, hour_minutes, currentDateandTime2);
                    setResult(RESULT_OK, null);
                    Toast.makeText(getBaseContext(), "Event successfully registered to the logbook!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddEventAct.this, LogbookEvents.class);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    Toast.makeText(getBaseContext(), "Please enter a description", Toast.LENGTH_LONG).show();
                }


            }
        });

        showEventsBtt = (Button)findViewById(R.id.showEventsBt);
        showEventsBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEventAct.this, LogbookEvents.class);
                intent.putExtra("myID", myID);
                intent.putExtra("myUsername",myUsername);
                startActivity(intent);
            }
        });


        cancelBT = (Button)findViewById(R.id.cancelBT);
        cancelBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
