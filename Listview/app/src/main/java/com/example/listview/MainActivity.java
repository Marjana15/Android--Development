package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        Button addButton = findViewById(R.id.addItemButton);
        Button secondPageButton = findViewById(R.id.goToAnotherPageButton);
        Button deleteItemButton = findViewById(R.id.deleteItemButton);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.textView, itemList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(view -> addItemToList());
        secondPageButton.setOnClickListener(view -> openSecondActivity());
        deleteItemButton.setOnClickListener(view -> deleteLastItem());
    }

    private void addItemToList() {
        itemList.add("List View Thing " + (itemList.size() + 1));
        adapter.notifyDataSetChanged();
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void deleteLastItem() {
        if (!itemList.isEmpty()) {
            itemList.remove(itemList.size() - 1);
            adapter.notifyDataSetChanged();
        }
    }
}
