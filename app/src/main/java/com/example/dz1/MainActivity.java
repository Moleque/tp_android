package com.example.dz1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ListFragment listFragment;
    private NumFragment numberFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = (ListFragment)getSupportFragmentManager().findFragmentByTag(ListFragment.TAG);
        if (listFragment == null) {
            listFragment = new ListFragment();
        }
        numberFragment = (NumFragment)getSupportFragmentManager().findFragmentByTag(NumFragment.TAG);
        if (numberFragment == null) {
            numberFragment = new NumFragment();
        }
        openListFragment();
//        openNumFragment(10, getColor(R.color.colorAccent));
    }

    private void openListFragment() {
        if(getSupportFragmentManager().findFragmentByTag(ListFragment.TAG) == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, listFragment, ListFragment.TAG)
                    .addToBackStack(ListFragment.TAG)
                    .commit();
        }
    }

    private void openNumFragment(int number, int color) {
        numberFragment.setNumberValue(number, color);
        if(getSupportFragmentManager().findFragmentByTag(NumFragment.TAG) == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, numberFragment, NumFragment.TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
