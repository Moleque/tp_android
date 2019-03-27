package com.example.dz1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment list = new ListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, list);
        transaction.commit();

//        for (int i = 0; i < 100; i++) {
//            addNewNumber(i);
//        }
    }

    public void addNewNumber(int num) {
        LinearLayout numbers = findViewById(R.id.num_layout);

        Button button = new Button(MainActivity.this);
        numbers.addView(button);
    }

    public void Open(View v) {
        Fragment fragment = new NumFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
