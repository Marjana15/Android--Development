package com.example.testapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        PostViewModel postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                displayPosts(posts);
            }
        });

        // Trigger the API call
        postViewModel.fetchPosts();
    }

    private void displayPosts(List<Post> posts) {
        StringBuilder content = new StringBuilder();

        for (Post post : posts) {
            content.append("ID: ").append(post.getId()).append("\n");
            content.append("User ID: ").append(post.getUserId()).append("\n");
            content.append("Title: ").append(post.getTitle()).append("\n");
            content.append("Text: ").append(post.getText()).append("\n\n");
        }

        textViewResult.setText(content.toString());
    }
}
