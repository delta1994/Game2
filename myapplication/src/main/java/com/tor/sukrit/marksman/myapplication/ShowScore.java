package com.tor.sukrit.marksman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowScore extends AppCompatActivity {

    private TextView txtShowScore;
    private Button btnPlayAgain, btnExit;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        initialWidget();
        int intScore = getIntent().getExtras().getInt("Score");
        txtShowScore.setText(String.valueOf(intScore) + "/10");

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(ShowScore.this, Game1.class);
                startActivity(objIntent);
                finish();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initialWidget() {
        txtShowScore = (TextView) findViewById(R.id.textv2);
        btnPlayAgain = (Button)findViewById(R.id.button11);
        btnExit = (Button) findViewById(R.id.button12);
    }
}

