package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class specializations extends AppCompatActivity implements interfaces {

    TextView t1, t2;
    FragmentManager manager = getSupportFragmentManager();
    Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specializations);

        t1 = findViewById(R.id.pag1);
        t2 = findViewById(R.id.pag2);

        p1special ps1 = new p1special();
        p2special ps2 = new p2special();

        activeFragment = ps1;

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container1,ps1, "p1special");
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
        FragmentTransaction transaction = manager.beginTransaction();


        transaction.hide(activeFragment);

        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.container1, fragment, tag);
        }

        transaction.commit();

        activeFragment = fragment;
    }

    @Override
    public void senddata(int a)
    {
        p3special ps3 = new p3special();

        FragmentTransaction transaction = manager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putInt("c",a);

        ps3.setArguments(bundle);

        transaction.add(R.id.container3,ps3, "p3special");

        transaction.commitNow();
    }
}
