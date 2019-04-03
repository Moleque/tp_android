package com.example.dz1;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ListFragment extends Fragment {
    public static final String TAG = "List";

    private Button addButton;
    private RecyclerView recycler;
    private NumbersAdapter adapter;
    private int numbersCount = 25;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            numbersCount = savedInstanceState.getInt("numbersCount", numbersCount);
        }

        Context context = view.getContext();

        int orientation = context.getResources().getConfiguration().orientation;
        int columnsCount = orientation == Configuration.ORIENTATION_LANDSCAPE ? 4 : 3;

        recycler = (RecyclerView)view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(context, columnsCount));

        adapter = new NumbersAdapter(numbersCount);
        recycler.setAdapter(adapter);

        addButton = (Button)view.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCount = adapter.getItemCount() + 1;
                adapter.setItemCount(numbersCount);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numbersCount", numbersCount);
    }
}
