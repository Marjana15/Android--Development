package com.example.listimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<ListItem> {

    public CustomAdapter(Context context, List<ListItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ListItem item = getItem(position);

        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        if (item != null) {
            textViewTitle.setText(item.getTitle());
            // Load image using Picasso
            Picasso.get().load(item.getImageUrl()).into(imageView);
        }

        return convertView;
    }
}
