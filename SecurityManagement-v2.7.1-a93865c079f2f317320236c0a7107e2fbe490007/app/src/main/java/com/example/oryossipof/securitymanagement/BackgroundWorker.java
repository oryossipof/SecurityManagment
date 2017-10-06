package com.example.oryossipof.securitymanagement;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by or yossipof on 06/10/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

       // String login_url = "http://10.0.2.2/security/fcm_insert.php";
        String login_url = "http://securitymanagementapp.000webhostapp.com/fcm_insert.php";
        String notification_url = "http://securitymanagementapp.000webhostapp.com//send_notiofication.php";
        if (type.equals("login")) {

            try {
                String fcm_token = params[1];
                // String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");

                /*********/
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                /************/

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_date = URLEncoder.encode("fcm_token", "UTF-8") + "=" + URLEncoder.encode(fcm_token, "UTF-8");

                bufferedWriter.write(post_date);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else   //for sending notifications
        {


            try {
                String title = params[1];
                String message = params[2];

                URL url = new URL(notification_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");

                /*********/
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                /************/

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_date = URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8")+"&"
                        + URLEncoder.encode("message", "UTF-8") + "=" + URLEncoder.encode(message, "UTF-8");

                bufferedWriter.write(post_date);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }










        }
            return null;

        }


        @Override
        protected void onPreExecute () {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("eli kelev");


        }

        @Override
        protected void onPostExecute (String result){
            //alertDialog.setMessage(result);
            Log.e("result", result);
            // alertDialog.show();
        }

        @Override
        protected void onProgressUpdate (Void...values){
            super.onProgressUpdate(values);
        }
    }

