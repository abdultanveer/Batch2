package com.example.batch2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public  static String KEY = "mykey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view) {
        Intent loginIntent =
                new Intent(this,LoginActivity.class); //explicit intent
        loginIntent.putExtra(KEY,"abdul");
        startActivity(loginIntent);
    }
}
