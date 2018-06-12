package com.example.nagi.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setContent();
    }



    private void setContent() {
        Intent intent = getIntent();
        String movie_name = intent.getStringExtra(MainActivity.MOVIE_EXTRA);

        // 1. imageView
        ImageView imageView = findViewById(R.id.detailImage);
        int img_id = getResources().getIdentifier(movie_name,"drawable",getPackageName());
        imageView.setImageResource(img_id);

        // 2. textView
        int text_id = getResources().getIdentifier(movie_name,"raw",getPackageName());
        Scanner scan = new Scanner(getResources().openRawResource(text_id));
        String allText = "";
        while (scan.hasNextLine()){
            allText += scan.nextLine();
        }
        scan.close();

        TextView textView = findViewById(R.id.detailText);
        textView.setText(allText);
    }
}

