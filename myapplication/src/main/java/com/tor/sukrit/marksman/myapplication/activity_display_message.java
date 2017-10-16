package com.tor.sukrit.marksman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_display_message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


    }

    public void btn_back23(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void btn_game1(View view){
        Intent intent = new Intent(activity_display_message.this, Game1.class);
        startActivity(intent);
    }
    public void btn_game2(View view){
        Intent intent3333344 = getPackageManager().getLaunchIntentForPackage("first.com");
        startActivity(intent3333344);
    }
}
