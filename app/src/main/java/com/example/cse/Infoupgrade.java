package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class Infoupgrade extends AppCompatActivity {

    TextView te1,te2;
    private BroadcastReceiver dataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.example.cse.DATA_LOADED".equals(intent.getAction())) {
                String loadedData = intent.getStringExtra("loadedData");

                // Update the TextView with the loaded data
                te2.setText(loadedData);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoupgrade);

        te1=findViewById(R.id.headin);
        te2 = findViewById(R.id.tv);

        // Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter("com.example.cse.DATA_LOADED");
        registerReceiver(dataReceiver, filter);

        // Get the button clicked value
        Intent intent = getIntent();
        String id = intent.getStringExtra("buttonclicked");
        String Heading=intent.getStringExtra("texts");

        te1.setText(Heading);

        // Start the IntentService to fetch data based on the button clicked
        startIntentService(id);
    }

    @Override
    protected void onDestroy() {
        // Unregister the BroadcastReceiver when the activity is destroyed
        unregisterReceiver(dataReceiver);
        super.onDestroy();
    }

    private void startIntentService(String buttonClicked) {
        // Call the IntentService to perform the action Foo
        IntentInfoupgrageyou.startActionFoo(this, buttonClicked);
    }
}
