package com.example.dz1;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {

    private int numbersCount;

    public NumbersAdapter(int numbersCount) {
        this.numbersCount = numbersCount;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.number, viewGroup, false);

        NumberViewHolder viewHolder = new NumberViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int i) {
        numberViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return numbersCount;
    }


    class NumberViewHolder extends RecyclerView.ViewHolder {

        private Button numberItem;

        public NumberViewHolder(View itemView) {
            super(itemView);
            numberItem = itemView.findViewById(R.id.item_number);
        }

        void bind(int number) {
            numberItem.setText(String.valueOf(number));
            numberItem.setTextColor(getNumColor(number));
        }

        private int getNumColor(int num) {
            int color = (num % 2 == 0) ? Color.RED : Color.BLUE;
            return color;
        }
    }
}
