package com.example.listimage;

public class ListItem {
    private final String title;
    private final String imageUrl;

    public ListItem(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
