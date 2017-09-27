package com.example.oryossipof.securitymanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by or yossipof on 05/09/2017.
 */

public class UserListAdapter extends ArrayAdapter<User> {
    private Context mContext;
    int mResource;
    public UserListAdapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String username = getItem(position).getUsername();
        String time = getItem(position).getTime();
        String description = getItem(position).getDescription();
        User user = new User(username,time,description);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView timeTxt = (TextView)convertView.findViewById(R.id.timeTextView);
        TextView usernameTxt = (TextView)convertView.findViewById(R.id.nameTextView);
        TextView DesTxt = (TextView)convertView.findViewById(R.id.DesTextView);

        timeTxt.setText(time);
        usernameTxt.setText(username);
        DesTxt.setText(description);

        return convertView;


    }
}
