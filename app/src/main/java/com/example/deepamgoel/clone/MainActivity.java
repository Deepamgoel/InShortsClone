package com.example.deepamgoel.clone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VerticalViewPager viewPager = findViewById(R.id.card_view);
        viewPager.setAdapter(new SlidePageAdapter(this));

    }


}

