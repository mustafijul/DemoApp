package com.example.demoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Array of image resources and corresponding text descriptions
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private String[] imageNames = {"Image 1", "Image 2", "Image 3"};
    private int currentIndex = 0; // Start with the first image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References to UI components
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView); // TextView reference
        Button btnNext = findViewById(R.id.btnNext);
        Button btnPrevious = findViewById(R.id.btnPrevious);

        // Set initial image and text
        imageView.setImageResource(images[currentIndex]);
        textView.setText(imageNames[currentIndex]);

        // Next button click listener (lambda expression)
        btnNext.setOnClickListener(v -> {
            currentIndex++; // Move to next image
            if (currentIndex >= images.length) {
                currentIndex = 0; // Reset to the first image if out of bounds
            }
            imageView.setImageResource(images[currentIndex]);
            textView.setText(imageNames[currentIndex]); // Update text for the current image
            Toast.makeText(MainActivity.this, "Next Image", Toast.LENGTH_SHORT).show();
        });

        // Previous button click listener (lambda expression)
        btnPrevious.setOnClickListener(v -> {
            currentIndex--; // Move to previous image
            if (currentIndex < 0) {
                currentIndex = images.length - 1; // Set to the last image if out of bounds
            }
            imageView.setImageResource(images[currentIndex]);
            textView.setText(imageNames[currentIndex]); // Update text for the current image
            Toast.makeText(MainActivity.this, "Previous Image", Toast.LENGTH_SHORT).show();
        });
    }
}
