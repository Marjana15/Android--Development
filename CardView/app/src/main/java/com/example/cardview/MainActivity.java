package com.example.cardview;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<CardItem> cardItemList = generateCardItems();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardAdapter cardAdapter = new CardAdapter(cardItemList);
        recyclerView.setAdapter(cardAdapter);
    }

    private List<CardItem> generateCardItems() {
        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem("Card 1", "Content for Card 1"));
        cardItemList.add(new CardItem("Card 2", "Content for Card 2"));
        cardItemList.add(new CardItem("Card 3", "Content for Card 3"));
        return cardItemList;
    }
}
