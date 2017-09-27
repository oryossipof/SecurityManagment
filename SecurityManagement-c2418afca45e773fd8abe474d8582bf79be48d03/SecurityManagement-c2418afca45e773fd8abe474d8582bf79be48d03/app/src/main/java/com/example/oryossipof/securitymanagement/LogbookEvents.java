package com.example.oryossipof.securitymanagement;

import android.content.Intent;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;

public class LogbookEvents extends AppCompatActivity {

    private Firebase mRef;
    private ListView mListView ;
    private ArrayList<User> mUsersName = new ArrayList<>();
    private  String time,name,des;
    private  String myUsername, myID;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logbook_events);
        Intent intent = getIntent();
        this.myUsername = intent.getStringExtra("myUsername");
        this.myID = intent.getStringExtra("myID");

        mListView = (ListView) findViewById(R.id.lv_msglist);
        final UserListAdapter adapter = new UserListAdapter(this,R.layout.listview_layout,mUsersName);
        mListView.setAdapter(adapter);



        mListView.setSelection(adapter.getCount() - 1);

        mRef = new Firebase("https://securitymanagment-2427a.firebaseio.com/Events");



        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                System.out.println("There are " + dataSnapshot.getChildrenCount() + " children");
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    User people = child.getValue(User.class);


              //  String value = dataSnapshot.getValue(String.class);
                //for (DataSnapshot  d: dataSnapshot.getChildren()) {

                   // User msg = d.getValue(User.class);

                    /*
                        String date =  d.getKey().toString();
                        HashMap hashMap = (HashMap)d.getValue();
                        Log.e("here:" , hashMap.toString());
                        String time = hashMap.get("time").toString();
                        String description = hashMap.get("description").toString();
                        value = hashMap.get("username").toString();       //retrieve all information


*/
                        //mUsersName.add(value);
                    mUsersName.add(new User(people.getDescription(),people.getTime(),people.getUsername()));
                 /*   mUsersName.add(people.getDescription());
                    mUsersName.add(people.getTime());
                    mUsersName.add(people.getUsername());*/
                    adapter.notifyDataSetChanged();
                        mListView.setSelection(adapter.getCount() - 1);

                }


               // String value = dataSnapshot.child("time").getValue(String.class);



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




    }
}


