package com.example.cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private final List<CardItem> cardItemList;

    public CardAdapter(List<CardItem> cardItemList) {
        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardItem cardItem = cardItemList.get(position);
        holder.titleTextView.setText(cardItem.getTitle());
        holder.contentTextView.setText(cardItem.getContent());
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView contentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }
    }
}
