package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class upgradeyou extends AppCompatActivity {

    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgradeyou);

        moveto(R.id.dsa,Con.b1);
        moveto(R.id.roadmaps,Con.b2);
        moveto(R.id.studym,Con.b3);
        moveto(R.id.certification,Con.b4);
        moveto(R.id.interview,Con.b5);
        moveto(R.id.intership,Con.b6);
        moveto(R.id.sknow,Con.b7);
        moveto(R.id.ttrend,Con.b8);
    }

    private void moveto(int teid,String b) {
        findViewById(teid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t=findViewById(teid);
                Intent intent=new Intent(upgradeyou.this,Infoupgrade.class);
                intent.putExtra("buttonclicked",b);
                intent.putExtra("texts",t.getText());
                startActivity(intent);
            }
        });
    }

    public static class Con{
        public static final String b1="b1";
        public static final String b2="b2";
        public static final String b3="b3";
        public static final String b4="b4";
        public static final String b5="b5";
        public static final String b6="b6";
        public static final String b7="b7";
        public static final String b8="b8";

    }
}