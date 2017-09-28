package com.example.oryossipof.securitymanagement;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import android.net.Uri;
import com.firebase.client.Firebase;

import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by or yossipof on 21/09/2017.
 */

class DataBase {
    private static Firebase myRef;
    private Context context;
    public static boolean flag;


    public DataBase(Context context) {
        this.context = context;

        Firebase.setAndroidContext(this.context);

        this.myRef = new Firebase("https://securitymanagment-2427a.firebaseio.com/");


    }


    public static void signupUser(String id, String name) {

        //Firebase mRefChild = myRef.child("users");
        Firebase mRefChild = myRef.child("users");


        mRefChild.push();
        mRefChild.child(id + "").setValue(id + "");

 mRefChild.child(id + "").child("Name").setValue(name + "");
       // mRefChild.child(id + "").child("N").setValue(name + "");


    }
    //public static void addEventToDataBase(String dateandTime, String myUsername, String description, String hour_minutes, String timetoshow) {
        public static void addEventToDataBase(String dateandTime, String myUsername, String description, String hour_minutes,String timetoshow ,String donwloadImage) {

        Firebase mRefChild = myRef.child("Events");
        mRefChild.push();
        mRefChild.child(dateandTime).child(hour_minutes).child("time").setValue(timetoshow);
        mRefChild.child(dateandTime).child(hour_minutes).child("username").setValue(myUsername);
        mRefChild.child(dateandTime).child(hour_minutes).child("description").setValue(description);
            mRefChild.child(dateandTime).child(hour_minutes).child("urlImage").setValue(donwloadImage);


    }


    public static void removeUser(String id)
    {

        Firebase mRefChild = myRef.child("users");
        mRefChild.child(id).removeValue();

    }
}



