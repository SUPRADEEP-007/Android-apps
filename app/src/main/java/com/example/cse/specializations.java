package com.example.cse;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class specializations extends AppCompatActivity implements interfaces {

    TextView t1, t2;
    FragmentManager manager1 = getSupportFragmentManager();
    FragmentManager manager2 = getSupportFragmentManager();
    Fragment activeFragment;
    Fragment activeFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specializations);

        t1 = findViewById(R.id.pag1);
        t2 = findViewById(R.id.pag2);

        p1special ps1 = new p1special();
        p2special ps2 = new p2special();

        activeFragment = ps1;

        FragmentTransaction transaction = manager1.beginTransaction();
        transaction.replace(R.id.container1, ps1, "p1special");
        transaction.commit();

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activeFragment != ps1) {
                    switchFragment(ps1, "p1special");
                }
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activeFragment != ps2) {
                    switchFragment(ps2, "p2special");
                }
            }
        });
    }

    private void switchFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = manager1.beginTransaction();


        transaction.hide(activeFragment);

        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.container1, fragment, tag);
        }

        transaction.commit();

        activeFragment = fragment;
    }

    private void switchFragments(Fragment fragment, String tag, int x) {
        FragmentTransaction transaction = manager2.beginTransaction();

        try {
            if (activeFragment2 != null) {
                transaction.hide(activeFragment2);
            }

            Bundle bundle = new Bundle();
            bundle.putInt("c", x);

            fragment.setArguments(bundle);

            if (fragment.isAdded()) {
                transaction.show(fragment);
            } else {
                transaction.add(R.id.container3, fragment, tag);
            }

            transaction.commit();

            activeFragment2 = fragment;
        } catch (Exception e) {
            Log.e(TAG, "Error in switchFragments", e);
        }
    }


    @Override
    public void senddata1(int a) {
        p3special ps3 = new p3special();

        switchFragments(ps3,"ps3special",a);

    }

    @Override
    public void senddata2(int a) {
        p32special ps32 = new p32special();

        switchFragments(ps32,"ps32special",a);

    }

    @Override
    public void senddata3(int a) {
        p33special ps33 = new p33special();

        switchFragments(ps33,"ps33special",a);
    }

    @Override
    public void senddata4(int a) {
        p34special ps34 = new p34special();

        switchFragments(ps34,"ps33special",a);
    }

    @Override
    public void senddata5(int a) {
        p35special ps35 = new p35special();

        switchFragments(ps35,"ps33special",a);
    }

    @Override
    public void senddata6(int a) {
        p36special ps36 = new p36special();

        switchFragments(ps36,"ps33special",a);
    }

    @Override
    public void senddata7(int a) {
        p37special ps37 = new p37special();

        switchFragments(ps37,"ps33special",a);
    }

    @Override
    public void senddata8(int a) {
        p38special ps38 = new p38special();

        switchFragments(ps38,"ps33special",a);
    }


}