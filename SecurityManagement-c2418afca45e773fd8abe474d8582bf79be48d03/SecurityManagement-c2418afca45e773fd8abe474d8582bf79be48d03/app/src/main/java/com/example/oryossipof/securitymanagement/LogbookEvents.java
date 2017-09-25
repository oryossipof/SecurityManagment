package com.example.oryossipof.securitymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class LogbookEvents extends AppCompatActivity {

    private Firebase mRef;
    private Button exitBT, addEventBT;
    private ListView mListView ;
    private ArrayList<String> mUsersName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook_events);

        mListView = (ListView) findViewById(R.id.lv_msglist);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsersName);
        mListView.setAdapter(arrayAdapter);


        mListView.setSelection(arrayAdapter.getCount() - 1);
        mRef = new Firebase("https://securitymanagment-2427a.firebaseio.com/Events");

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                mUsersName.add(value);
                arrayAdapter.notifyDataSetChanged();
                mListView.setSelection(arrayAdapter.getCount() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        addEventBT = (Button)findViewById(R.id.addEventBT);
        exitBT = (Button) findViewById(R.id.exitBT);

        exitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addEventBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogbookEvents.this, AddEventAct.class);
                startActivity(intent);
            }
        });


    }
}
