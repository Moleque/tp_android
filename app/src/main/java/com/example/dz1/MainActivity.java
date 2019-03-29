package com.example.dz1;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListFragment listFragment;
    private NumFragment numberFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listFragment = new ListFragment();
        numberFragment = new NumFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, listFragment);
        transaction.commit();
    }

//    public void onNumClick(View v) {
//        openNumber(number);
//    }
//
//    public void openNumber(View v) {
//        Fragment fragment = new NumFragment();
//
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.frame, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
