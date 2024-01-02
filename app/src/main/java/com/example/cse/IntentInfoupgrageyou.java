package com.example.cse;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

public class IntentInfoupgrageyou extends IntentService {

    private static final String ACTION_FOO = "com.example.cse.action.FOO";
    private static final String EXTRA_BUTTON_CLICKED = "com.example.cse.extra.BUTTON_CLICKED";

    public IntentInfoupgrageyou() {
        super("IntentInfoupgrageyou");
    }

    public static void startActionFoo(Context context, String buttonClicked) {
        Intent intent = new Intent(context, IntentInfoupgrageyou.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_BUTTON_CLICKED, buttonClicked);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String buttonClicked = intent.getStringExtra(EXTRA_BUTTON_CLICKED);
                handleActionFoo(buttonClicked);
            }
        }
    }

    private void handleActionFoo(String buttonClicked) {
        // Simulate loading data based on the button clicked
        String loadedData = null;
        if (upgradeyou.Con.b1.equals(buttonClicked)) {
            loadedData = constants.Cdsa;
        } else if (upgradeyou.Con.b2.equals(buttonClicked)) {
            loadedData=constants.roadmaps;
        }else if (upgradeyou.Con.b3.equals(buttonClicked)) {
            loadedData=constants.materials;
        }else if (upgradeyou.Con.b4.equals(buttonClicked)) {
            loadedData=constants.certif;
        }else if (upgradeyou.Con.b5.equals(buttonClicked)) {
            loadedData=constants.inter;
        }else if (upgradeyou.Con.b6.equals(buttonClicked)) {
            loadedData=constants.intern;
        }else if (upgradeyou.Con.b7.equals(buttonClicked)) {
            loadedData=constants.should;
        }else if (upgradeyou.Con.b8.equals(buttonClicked)) {
            loadedData=constants.tre;
        }

        // Broadcast the loaded data
        Intent broadcastIntent = new Intent("com.example.cse.DATA_LOADED");
        broadcastIntent.putExtra("loadedData", loadedData);
        sendBroadcast(broadcastIntent);
    }
}
