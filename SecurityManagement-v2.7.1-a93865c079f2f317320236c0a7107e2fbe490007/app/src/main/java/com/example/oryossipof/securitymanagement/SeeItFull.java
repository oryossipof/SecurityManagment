package com.example.oryossipof.securitymanagement;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static com.example.oryossipof.securitymanagement.Application.getContext;

public class SeeItFull extends AppCompatActivity {

    private String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_it_full);
        Intent intent = getIntent();
        this.uri = intent.getStringExtra("uri");
        ImageView imageView = (ImageView) findViewById(R.id.seeitfull);
        Uri uristring;
        String stringUri;
        uristring = Uri.parse(uri);



        //Picasso.with(getContext()).load(uri).into(imageView);
        Picasso.with(getContext()).load(uri).into(imageView);
    }
}
