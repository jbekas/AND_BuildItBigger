package com.redgeckotech.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dealerinspire.mylibrary.R;

public class ShowJokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "joke";

    TextView jokeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        jokeView = (TextView) findViewById(R.id.joke);

        if (savedInstanceState == null) {
            String joke = getIntent().getStringExtra(EXTRA_JOKE);
            jokeView.setText(joke);
        }
    }
}
