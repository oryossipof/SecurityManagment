package com.example.oryossipof.securitymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LostAndFoundsActivity extends AppCompatActivity {

    private String myID,myUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_and_founds);
        Intent intent = getIntent();
        this.myUsername = intent.getStringExtra("myUsername");
        this.myID = intent.getStringExtra("myID");
    }
}
