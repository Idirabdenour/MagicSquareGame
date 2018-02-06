package com.example.abdenour.gamemagic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void homeToGame(View v){
        Intent in = new Intent(this, Level.class);
        startActivity(in);
    }
    //intent implicite
    public void doTwo(View v) {
        //intent explicite
        Intent implicitintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fr.wikipedia.org/wiki/Carr%C3%A9_magique_(math%C3%A9matiques)"));
        startActivity(implicitintent);
    }
    public void exit(View v) {
        // TODO Auto-generated method stub
        finish();
        System.exit(0);
    }
}
