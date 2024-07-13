package com.example.listimage;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        List<ListItem> items = new ArrayList<>();
        items.add(new ListItem("Item 1", "https://img.freepik.com/free-photo/painting-mountain-lake-with-mountain-background_188544-9126.jpg"));
        items.add(new ListItem("Item 2", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"));
        // Add more items as needed

        CustomAdapter adapter = new CustomAdapter(this, items);
        listView.setAdapter(adapter);
    }
}
