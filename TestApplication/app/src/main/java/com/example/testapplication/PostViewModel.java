package com.example.testapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends AndroidViewModel {

    private final JsonPlaceHolderApi jsonPlaceHolderApi;
    private final MutableLiveData<List<Post>> posts;

    public PostViewModel(@NonNull Application application) {
        super(application);
        jsonPlaceHolderApi = RetrofitInstance.getRetrofitInstance().create(JsonPlaceHolderApi.class);
        posts = new MutableLiveData<>();
    }

    public LiveData<List<Post>> getPosts() {
        return posts;
    }

    public void fetchPosts() {
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    posts.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                // Handle failure, e.g., show an error message
            }
        });
    }
}
