package com.example.dz1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumFragment extends Fragment {
    public static final String TAG = "Number";

    private int number;
    private int color;
    private TextView numView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        number = bundle.getInt("number");
        color = bundle.getInt("color");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_num, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        numView = view.findViewById(R.id.number_view);
        numView.setText(String.valueOf(number));
        numView.setTextColor(color);
    }

    public void setViewValues(int number, int color) {
        Bundle bundle = new Bundle();
        bundle.putInt("number", number);
        bundle.putInt("color", color);
        setArguments(bundle);
    }
}
