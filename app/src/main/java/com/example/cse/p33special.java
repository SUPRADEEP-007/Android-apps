package com.example.cse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class p33special extends Fragment {

    private TextView textView1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p33special, container, false);
        textView1 = view.findViewById(R.id.textView3);

        // Retrieve button ID from arguments
        Bundle bundle = getArguments();
        if (bundle != null) {
            int buttonId = bundle.getInt("c", 0);
            if(buttonId==3)
            {
                textView1.setText(constants.sDA);
            }
        }

        return view;
    }
}