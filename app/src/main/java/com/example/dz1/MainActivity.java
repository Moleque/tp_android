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
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    private ListFragment listFragment;
    private NumFragment numberFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listFragment = new ListFragment();
//        numberFragment = new NumFragment();

        listFragment = (ListFragment)getSupportFragmentManager().findFragmentByTag(ListFragment.TAG);
        if (listFragment == null) {
            listFragment = new ListFragment();
        }

        numberFragment = (NumFragment)getSupportFragmentManager().findFragmentByTag(NumFragment.TAG);
        if (numberFragment == null) {
            numberFragment = new NumFragment();
        }

        openListFragment();
    }

//    public void onNumClick(View v) {
//        openNumber(number);
//    }
//
    private void openListFragment() {
        if(getSupportFragmentManager().findFragmentByTag(NumFragment.TAG) == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, listFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    private void openNumFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, listFragment)
                .addToBackStack(null)
                .commit();
    }
}
