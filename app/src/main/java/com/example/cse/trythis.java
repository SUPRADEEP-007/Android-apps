package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class trythis extends AppCompatActivity {
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trythis);

        setupButton(R.id.button1, Constants.BUTTON_1, R.id.contentView1);
        setupButton(R.id.button2, Constants.BUTTON_2, R.id.contentView2);
        setupButton(R.id.button3, Constants.BUTTON_3, R.id.contentView3);
        setupButton(R.id.button4, Constants.BUTTON_4, R.id.contentView4);
        setupButton(R.id.button5, Constants.BUTTON_5, R.id.contentView5);
        setupButton(R.id.button6, Constants.BUTTON_6, R.id.contentView6);
    }

    private void setupButton(int buttonId, String buttonTag, int contentViewId) {
        findViewById(buttonId).setOnClickListener(view -> toggleContent(buttonTag, contentViewId));
    }

    private void toggleContent(String buttonTag, int contentViewId) {
        TextView textbox = findViewById(contentViewId);

        // Move the service-related operations to a background thread
        new Thread(() -> {
            Intent serviceIntent = new Intent(this, IStrythis.class);
            serviceIntent.putExtra("buttonClicked", buttonTag);
            serviceIntent.putExtra("textViewId", contentViewId);
            startService(serviceIntent);

            // Update the UI on the main thread
            runOnUiThread(() -> {
                if (textbox.getVisibility() == View.VISIBLE) {
                    textbox.setVisibility(View.GONE);
                    textbox.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrowdown, 0);
                } else {
                    textbox.setVisibility(View.VISIBLE);
                    textbox.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrowup, 0);


                    receiver = new BroadcastReceiver() {
                        @Override
                        public void onReceive(Context context, Intent intent) {
                            String myString = intent.getStringExtra("myString");
                            int updatedTextViewId = intent.getIntExtra("textViewId", 0);
                            TextView updatedTextView = findViewById(updatedTextViewId);
                            if (updatedTextView != null) {
                                updatedTextView.setText(myString);
                            }

                            Intent stopServiceIntent = new Intent(context, IStrythis.class);
                            stopService(stopServiceIntent);
                        }
                    };

                    IntentFilter filter = new IntentFilter("my-event");
                    LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
                }
            });
        }).start();
    }

    @Override
    protected void onDestroy() {
        if (receiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
            receiver = null;
        }
        super.onDestroy();
    }

    public static class Constants {
        public static final String BUTTON_1 = "button1";
        public static final String BUTTON_2 = "button2";
        public static final String BUTTON_3 = "button3";
        public static final String BUTTON_4 = "button4";
        public static final String BUTTON_5 = "button5";
        public static final String BUTTON_6 = "button6";
    }
}
