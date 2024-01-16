package com.example.cse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class p2special extends Fragment {

    TextView cy,it,cn,bl;
    public p2special() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p2special, container, false);

        cy = view.findViewById(R.id.cyber);
        it = view.findViewById(R.id.it);
        cn = view.findViewById(R.id.cn);
        bl = view.findViewById(R.id.block);

        cy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata5(p2special.Cott.CY);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata6(p2special.Cott.IT);
            }
        });

        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata7(p2special.Cott.CN);
            }
        });

        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaces i=(interfaces) getActivity();
                i.senddata8(p2special.Cott.BL);
            }
        });
        return view;
    }
    public static class Cott{
        public static final int CY=5;
        public static final int IT=6;
        public static final int CN=7;
        public static final int BL=8;
    }
}