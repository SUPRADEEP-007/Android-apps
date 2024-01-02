package com.example.cse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class IStrythis extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String buttonClicked = intent.getStringExtra("buttonClicked");
            int textViewId = intent.getIntExtra("textViewId", 0);

            // Use AsyncTask to perform background tasks
            new MyAsyncTask(this, buttonClicked, textViewId).execute();
        }

        // Return START_NOT_STICKY to ensure the service is not automatically restarted
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, String> {
        private final String buttonClicked;
        private final int textViewId;
        private final Context context;

        public MyAsyncTask(Context context, String buttonClicked, int textViewId) {
            this.context = context;
            this.buttonClicked = buttonClicked;
            this.textViewId = textViewId;
        }

        @Override
        protected String doInBackground(Void... voids) {
            // Perform background tasks
            String myString;
            if (trythis.Constants.BUTTON_1.equals(buttonClicked)) {
                myString = constants.codingexams;
            } else if (trythis.Constants.BUTTON_2.equals(buttonClicked)) {
                myString = constants.cocubes;
            } else if (trythis.Constants.BUTTON_3.equals(buttonClicked)) {
                myString = constants.firstnaukri;
            } else if (trythis.Constants.BUTTON_4.equals(buttonClicked)) {
                myString = constants.govttechjobs;
            } else if (trythis.Constants.BUTTON_5.equals(buttonClicked)) {
                myString = constants.scholorships;
            } else if (trythis.Constants.BUTTON_6.equals(buttonClicked)) {
                myString = constants.higherstudies;
            } else {
                myString = "Default Content";
            }

            return myString;
        }

        @Override
        protected void onPostExecute(String myString) {
            // Update UI using LocalBroadcastManager on the main thread
            Intent broadcastIntent = new Intent("my-event");
            broadcastIntent.putExtra("myString", myString);
            broadcastIntent.putExtra("textViewId", textViewId);
            LocalBroadcastManager.getInstance(context).sendBroadcast(broadcastIntent);
        }
    }
}
