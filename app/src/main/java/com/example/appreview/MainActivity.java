package com.example.appreview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appreview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private InAppReview inAppReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @NonNull ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inAppReview = new InAppReview();
        inAppReview.askUserForReview(this);  // Pass 'this' as an Activity parameter
    }
}
