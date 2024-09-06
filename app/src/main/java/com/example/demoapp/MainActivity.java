package com.example.demoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Array of image resources
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private int currentIndex = 0; // Start with the first image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References to ImageView and Buttons
        ImageView imageView = findViewById(R.id.imageView);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnPrevious = findViewById(R.id.btnPrevious);

        // Set initial image
        imageView.setImageResource(images[currentIndex]);

        // Next button click listener (lambda expression)
        btnNext.setOnClickListener(v -> {
            currentIndex++; // Move to next image
            if (currentIndex >= images.length) { // Check if it's out of bounds
                currentIndex = 0; // Reset to the first image
            }
            imageView.setImageResource(images[currentIndex]);
            Toast.makeText(MainActivity.this, "Next Image", Toast.LENGTH_SHORT).show();
        });

        // Previous button click listener (lambda expression)
        btnPrevious.setOnClickListener(v -> {
            currentIndex--; // Move to previous image
            if (currentIndex < 0) { // Check if it's out of bounds
                currentIndex = images.length - 1; // Set to the last image
            }
            imageView.setImageResource(images[currentIndex]);
            Toast.makeText(MainActivity.this, "Previous Image", Toast.LENGTH_SHORT).show();
        });
    }
}
