package com.example.cse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class p1special extends Fragment {

    TextView ai, cloud, data, iot;

    public p1special() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p1special, container, false);

        ai = view.findViewById(R.id.ai);
        cloud = view.findViewById(R.id.cloud);
        data = view.findViewById(R.id.da);
        iot = view.findViewById(R.id.iot);

        ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata1(Cot.AI);
            }
        });

        cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata2(Cot.cl);
            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata3(Cot.dat);
            }
        });

        iot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata4(Cot.iot);
            }
        });

        return view;
    }

    public static class Cot{
        public static final int AI=1;
        public static final int cl=2;
        public static final int dat=3;
        public static final int iot=4;
    }

}
