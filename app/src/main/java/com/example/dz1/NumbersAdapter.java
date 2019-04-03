package com.example.dz1;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {

    private int numbersCount;
    private Listener listener;

    public NumbersAdapter(int numbersCount, Listener listener) {
        this.numbersCount = numbersCount;
        this.listener = listener;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.number, viewGroup, false);
        return new NumberViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int i) {
        numberViewHolder.bind(i+1);
    }

    @Override
    public int getItemCount() {
        return numbersCount;
    }

    public void setItemCount(int numbersCount) {
        this.numbersCount = numbersCount;
        notifyDataSetChanged();
    }


    class NumberViewHolder extends RecyclerView.ViewHolder {

        private int number;
        private Button numberItem;

        public NumberViewHolder(View itemView, final Listener listener) {
            super(itemView);

            numberItem = itemView.findViewById(R.id.item_number);
            numberItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.openNumFragment(number, getNumColor(number));
                }
            });
        }

        void bind(int number) {
            this.number = number;
            numberItem.setText(String.valueOf(number));
            numberItem.setTextColor(getNumColor(number));
        }

        private int getNumColor(int num) {
            int color = num % 2 == 0 ? Color.RED : Color.BLUE;
            return color;
        }
    }
}
