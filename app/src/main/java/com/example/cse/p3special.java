package com.example.cse;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class p3special extends Fragment {

    public p3special() {
        // Required empty public constructor
    }

    TextView ab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p3special, container, false);

        Bundle bundle = getArguments();
        ab = view.findViewById(R.id.msgAI);
        final int id = bundle.getInt(constants.fa1, 0);

        // Clear the existing text before setting new content
        ab.setText("");

        if (isContentAvailable(id)) {
            ab.setText(getContent(id));
        }

        return view;
    }

    // Check if content is available for the given id
    private boolean isContentAvailable(int id) {
        switch (id) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    // Get content based on id
    private String getContent(int id) {
        switch (id) {
            case 1:
                return constants.sAI;
            case 2:
                return constants.sCL;
            case 3:
                return constants.sDA;
            case 4:
                return constants.sIOT;
            case 5:
                return constants.sCY;
            case 6:
                return constants.sIT;
            case 7:
                return constants.sCN;
            case 8:
                return constants.sBL;
            default:
                return "";
        }
    }
}
